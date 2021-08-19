package group4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group4.comm.Action;
import group4.comm.Forward;
import group4.service.BoardService;

public class LikeUpdateAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int likeCount = Integer.parseInt(request.getParameter("no"));
		String id = (String)request.getSession().getAttribute("id");
		
		BoardService service = BoardService.getService();
		service.likeUpdate(no);
		
		
		
		
		return null;
	}

}
