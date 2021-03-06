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
		List<BoardDTO> list=service.topViewList();
		List<BoardDTO> list2=service.topLikeList();
		List<BoardDTO> list3=service.noticeList();
		
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		
		
		 Forward forward=new Forward();
		 forward.setForward(true);
		 forward.setPath("WEB-INF/board/main.jsp?page=mainboard.jsp");

		return forward;
	}

}
