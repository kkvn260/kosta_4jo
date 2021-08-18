package group4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import group4.comm.Action;
import group4.comm.Forward;

public class LogoutAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		session.invalidate(); // 세션끝
		
		Forward forward=new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/board/logout.jsp");
		return forward;
	}

}
