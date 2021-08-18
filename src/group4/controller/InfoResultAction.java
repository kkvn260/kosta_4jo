package group4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import group4.comm.Action;
import group4.comm.Forward;
import group4.dto.MemberDTO;
import group4.service.MemberService;

public class InfoResultAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("id");


		MemberService service=MemberService.getMemberService();
        MemberDTO dto=service.info(id);
		
		request.setAttribute("dto",dto);
		
		Forward forward =new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/board/main.jsp?page=myinfo.jsp");
		return forward;
	}

}
