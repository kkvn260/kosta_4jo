package group4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group4.comm.Action;
import group4.comm.Forward;
import group4.dto.BoardDTO;
import group4.service.BoardService;

public class MainBaordAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BoardService service=BoardService.getService();
		List<BoardDTO> list=service.topLikeList();
		
		request.setAttribute("list", list);
		
		
		 Forward forward=new Forward();
		 forward.setForward(true);
		 forward.setPath("WEB-INF/board/main.jsp?page=mainboard.jsp");

		return forward;
	}

}
