package group4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import group4.comm.Action;
import group4.comm.Forward;

public class WriteFormAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		String category=request.getParameter("cat");
		request.setAttribute("category", category);
		
		Forward f=new Forward();
		f.setForward(true);
		if(id!=null) {
			f.setPath("WEB-INF/board/main.jsp?page=write.jsp");
		}else {
			f.setPath("WEB-INF/board/main.jsp?page=fail.jsp");
		}
		return f;
	}

}
