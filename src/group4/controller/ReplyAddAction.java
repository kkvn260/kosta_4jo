package group4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group4.comm.Action;
import group4.comm.Forward;
import group4.dto.ReplyDTO;
import group4.service.BoardService;

public class ReplyAddAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		int boardno =Integer.parseInt(request.getParameter("num"));
		
		ReplyDTO dto = new ReplyDTO();
		dto.setReplycontent(content);
		dto.setId(id);
		dto.setBoardno(boardno);
		
		BoardService service = BoardService.getService();
		service.addReply(dto);
		

		Forward f = new Forward();
		f.setForward(false);
		f.setPath("detail.do?boardno="+boardno);
		
		return f;
		
	}

}
