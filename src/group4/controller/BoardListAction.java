package group4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group4.comm.Action;
import group4.comm.Forward;
import group4.dto.BoardDTO;
import group4.service.BoardService;



public class BoardListAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String curr=request.getParameter("curr");
		int currpage=1;
		if(curr!=null)
		{
			currpage=Integer.parseInt(curr);
		}
		String search=request.getParameter("search");
		String searchtxt=request.getParameter("searchtxt");
		String category=request.getParameter("cat");
		if(search==null) search="";
		if(searchtxt==null) searchtxt="";
		if(category==null) category="";
		
		//��ü �ڷ��
		
		BoardService service=BoardService.getService();
		int totalcount=service.getTotalCount(search, searchtxt,category);
		int pagepercount=5; 
		
		int totalpage=(int) Math.ceil((float)totalcount/pagepercount);
		
		int startrow=(currpage-1)*pagepercount+1;
		int endrow=startrow+pagepercount-1;
		
		if(endrow>totalcount)
			endrow=totalcount;
		
		
		int blockcount=5;
		int startblock=((currpage-1)/blockcount)*blockcount+1;
		int endblock=startblock+blockcount-1;
		if(endblock>totalpage)
		{
			endblock=totalpage;
		}
		List<BoardDTO> list= service.getlist(startrow, endrow, search, searchtxt,category);

		request.setAttribute("list", list);
		request.setAttribute("currpage", currpage);
		request.setAttribute("datacount",list.size());
		request.setAttribute("startblock", startblock);
		request.setAttribute("endblock", endblock);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("search", search);
		request.setAttribute("searchtxt", searchtxt);
		request.setAttribute("startrow", startrow);
		request.setAttribute("category", category);

		
		
		 Forward forward=new Forward();
		 forward.setForward(true);
		 forward.setPath("WEB-INF/board/main.jsp?page=list.jsp");

		return forward;
		
	}
}
