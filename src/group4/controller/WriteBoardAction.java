package group4.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import group4.comm.Action;
import group4.comm.Forward;
import group4.dto.BoardDTO;
import group4.dto.FileDTO;
import group4.service.BoardService;

public class WriteBoardAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String savePath=request.getServletContext().getRealPath("file");
		System.out.println("파일 저장 경로"+savePath);
		File dir=new File(savePath);
		if(!dir.exists()) dir.mkdir(); //폴더 없으면 만들기
		int limitSize=1024*1024*10; //10MB limit
		MultipartRequest multi=new MultipartRequest(request, savePath, limitSize, "utf-8",new DefaultFileRenamePolicy());
		//multi로 받아줘서 request 불필요
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id"); // id로 세션 잡아준다고 가정하에 가져오기
		String board_name=multi.getParameter("board_name");
		String title=multi.getParameter("write_title");
		String content=multi.getParameter("write_content");
		String filename=multi.getFilesystemName("put_file");
		String realname=multi.getOriginalFileName("put_file");
		
		BoardDTO dto=new BoardDTO();
//		dto.setId(id);
		dto.setBoard_name(board_name);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setFilename(filename);
		
		FileDTO dto2=new FileDTO();
		dto2.setFilename(filename);
		dto2.setRealname(realname);
		
		System.out.println(id);
		System.out.println(dto.getBoard_name());
		System.out.println(dto.getTitle());
		System.out.println(dto.getContent());
		System.out.println();
		
		BoardService service=BoardService.getService();
		service.writeBoard(dto);
		service.insertFile(dto2);
	

		
		Forward f=new Forward();
		f.setForward(true);
		f.setPath("main.jsp?page=write.jsp"); // list가 없어서 write로 임시 대체
		return f;
	}

}
