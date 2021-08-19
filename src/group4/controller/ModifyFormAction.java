package group4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group4.comm.Action;
import group4.comm.Forward;
import group4.dao.BoardDAO;
import group4.dto.BoardDTO;
import group4.service.BoardService;


public class ModifyFormAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String cat = request.getParameter("cat");
		
		BoardDTO dto = new BoardDTO();
		dto.setBoardno(bno);
		dto.setTitle(title);
		dto.setContent(content);
		
		BoardService service = BoardService.getService();
		service.modifyBoard(dto);
		
		Forward forward = new Forward();
		forward.setForward(false);
		forward.setPath("list.do?cat="+cat);
		
		return forward;
	}

}
