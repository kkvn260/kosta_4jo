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
		
		int num = Integer.parseInt(request.getParameter("no"));
		String id = (String)request.getSession().getAttribute("id");
				
		BoardService service = BoardService.getService();
	
		int totalLike = service.likeCount(num);	
		int one = 1;
		
		if(service.likeCheck(num,id)==0) {
			service.modifyLike(totalLike+one,num);
			service.likeUpdate(num,id);
			
		}else {
			service.modifyLike(totalLike-one,num);
			service.likeCancel(num,id);
		}	
		
		Forward f = new Forward();
		f.setForward(false);
		f.setPath("detail.do?boardno="+num);
		
		return f;
	}

}
