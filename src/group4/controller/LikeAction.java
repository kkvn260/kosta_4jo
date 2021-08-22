package group4.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.mysql.cj.xdevapi.JsonNumber;

import group4.service.BoardService;

/**
 * Servlet implementation class LikeAction
 */
@WebServlet("/like.group4")
public class LikeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doReq(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doReq(request, response);
	}
	
	private void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		PrintWriter out = response.getWriter();
		int bno = Integer.parseInt(request.getParameter("no"));
		String id = (String)request.getSession().getAttribute("id");
				
		BoardService service = BoardService.getService();
		int likeNum = service.likeCount(bno);	
		System.out.println("현재like값: "+likeNum);
		int likeCheck = service.likeCheck(bno, id);
		System.out.println(likeCheck);
		
		if(likeCheck==0) {
			service.likeUp(likeNum, id,bno);
		}else {
			service.likeDown(likeNum,id,bno);
		}
		
		int totalLike =service.likeCount(bno);
		
		System.out.println("변경된like값: "+totalLike);

		JSONObject obj = new JSONObject();
		obj.put("total", totalLike);
		obj.put("likeCheck", likeCheck);
		out.print(obj);
		
		
		
	}
		

}
