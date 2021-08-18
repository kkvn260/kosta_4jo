package group4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group4.comm.Action;
import group4.comm.Forward;
import group4.dto.MemberDTO;
import group4.service.MemberService;

public class JoinResultAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		MemberService service=MemberService.getMemberService();
		
		MemberDTO dto=new MemberDTO();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setName(name);
		dto.setEmail(email);
		
		service.JoinMember(dto);
		
		Forward forward=new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/board/main.jsp?page=reok.jsp");
		return forward;
	}

}
