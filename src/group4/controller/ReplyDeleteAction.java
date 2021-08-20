package group4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group4.comm.Action;
import group4.comm.Forward;
import group4.dto.BoardDTO;
import group4.service.BoardService;

public class ReplyDeleteAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardService service = BoardService.getService();
		service.replyDelete(rno);
		BoardDTO boarddto = service.detail(bno);
		request.setAttribute("boarddto", boarddto);
		
		Forward f = new Forward();
		
		f.setForward(true);
		f.setPath("WEB-INF/board/main.jsp?page=detail.jsp");
			
		return f;

	}

}
