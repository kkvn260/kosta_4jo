package group4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import group4.comm.Action;
import group4.comm.Forward;
import group4.dto.BoardDTO;
import group4.service.BoardService;

public class WriteBoardAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		HttpSession session=request.getSession();
//		String id=(String)session.getAttribute("id"); // id로 세션 잡아준다고 가정하에 가져오기
		String board_name=request.getParameter("board_name");
		String title=request.getParameter("write_title");
		String content=request.getParameter("write_content");
//		String filename=request.getParameter("in_file");
		
		BoardDTO dto=new BoardDTO();
//		dto.setId(id);
		dto.setBoard_name(board_name);
		dto.setTitle(title);
		dto.setContent(content);
		
		System.out.println(dto.getBoard_name());
		System.out.println(dto.getContent());
		
		BoardService service=BoardService.getService();
		service.writeBoard(dto);
		
		Forward f=new Forward();
		f.setForward(true);
		f.setPath("main.jsp?page=write.jsp"); // list가 없어서 write로 임시 대체
		return f;
	}

}
