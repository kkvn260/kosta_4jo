package group4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group4.comm.Action;
import group4.comm.Forward;

public class MainBaordAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Forward forward=new Forward();
		 forward.setForward(true);
		 forward.setPath("WEB-INF/board/main.jsp?page=mainboard.jsp");

		return forward;
	}

}
