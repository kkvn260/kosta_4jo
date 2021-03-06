package group4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group4.comm.Action;
import group4.comm.Forward;
import group4.dto.BoardDTO;
import group4.service.BoardService;

public class ModifyBoardAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
        int bno = Integer.parseInt(request.getParameter("boardno"));
		BoardService service = BoardService.getService();
		BoardDTO dto = service.detail(bno);
		
		request.setAttribute("dto", dto);		
		
		Forward forward = new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/board/main.jsp?page=detailForm.jsp");
		return forward;	
	}

}
