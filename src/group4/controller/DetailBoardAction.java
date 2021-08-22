package group4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group4.comm.Action;
import group4.comm.Forward;
import group4.dto.BoardDTO;
import group4.service.BoardService;

public class DetailBoardAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int boardno = Integer.parseInt(request.getParameter("boardno"));
		String id = (String)request.getSession().getAttribute("id");
		
		BoardService service = BoardService.getService();
		service.viewUp(boardno);
		BoardDTO boarddto = service.detail(boardno);
		int likeCheck = service.likeCheck(boardno, id);
		
		request.setAttribute("boarddto", boarddto);
		request.setAttribute("likecheck", likeCheck);
		
		Forward f = new Forward();
		f.setForward(true);
		f.setPath("WEB-INF/board/main.jsp?page=detail.jsp");
		
		return f;  
	}

}
