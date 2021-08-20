package group4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group4.comm.Action;
import group4.comm.Forward;
import group4.dto.BoardDTO;
import group4.service.BoardService;

public class LikeUpdateAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("no"));
		String id = (String)request.getSession().getAttribute("id");
				
		BoardService service = BoardService.getService();
	
		int totalLike = service.likeCount(num);	
		int one = 1;
		
		if(service.likeCheck(num,id)==0) {
			service.likeUpdate(num,id);
			service.modifyLike(totalLike+one,num);
			BoardDTO boarddto = service.detail(num);
			request.setAttribute("boarddto", boarddto);

		}else {
			service.modifyLike(totalLike-one,num);
			service.likeCancel(num,id);
			BoardDTO boarddto = service.detail(num);
			request.setAttribute("boarddto", boarddto);
		}	
		
		Forward f = new Forward();
		f.setForward(true);
		f.setPath("WEB-INF/board/main.jsp?page=detail.jsp");
		
		return f;
	}

}
