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
		
		//boardno가 고유값을 가진 pk라고 가정
		int boardno = Integer.parseInt(request.getParameter("boardno"));
		
		BoardService service = BoardService.getService();
		BoardDTO boarddto = service.detail(boardno);
		 
		request.setAttribute("Boarddto", boarddto);
		Forward f = new Forward();
		f.setForward(true);
		f.setPath("WEB-INF/board/detail.jsp");
		
		return f;  
	}

}
