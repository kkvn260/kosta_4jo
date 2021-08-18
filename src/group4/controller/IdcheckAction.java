package group4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group4.comm.Action;
import group4.comm.Forward;
import group4.service.MemberService;

public class IdcheckAction implements Action {
 
	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		//System.out.println(id);
		
		MemberService service=MemberService.getMemberService();
		
		
		String result=service.idcheckData(id);
		//System.out.println(result);
		
		Forward forward=new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/board/join.jsp?id="+id+"&msg="+result);
		return forward;
	}

}
