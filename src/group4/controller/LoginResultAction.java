package group4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import group4.comm.Action;
import group4.comm.Forward;
import group4.dao.MemberDAO;
import group4.dto.MemberDTO;
import group4.service.MemberService;


public class LoginResultAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		MemberService service=MemberService.getMemberService();
		int result=service.login(id, pwd);
		
		if(result==1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			
			request.setAttribute("result", 1); //로그인성공
		}else if(result==0) { 
			request.setAttribute("result", 0); // 비밀번호 오류
		}else {
			request.setAttribute("result", -1); // 아이디 존재x
		}
		Forward forward=new Forward();
		forward.setForward(true);
		forward.setPath("list.do");
		return forward;
	}

}
