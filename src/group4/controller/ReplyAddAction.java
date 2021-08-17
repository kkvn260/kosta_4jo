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
		int boardnum =Integer.parseInt(request.getParameter("num"));
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		ReplyDTO dto = new ReplyDTO();
		dto.setReplycontent(content);
		dto.setId(writer);
		dto.setBoardno(boardnum);
		
		BoardService service = BoardService.getService();
		//service.insertReply(dto);
		

		Forward f = new Forward();
		f.setForward(false);
		f.setPath("detail.do?num="+boardnum);
		
		return f;
		
		
		return null;
	}

}
