package group4.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import group4.dto.ReplyDTO;
import group4.service.BoardService;


/**
 * Servlet implementation class ReplyDetailAction
 */
@WebServlet("/replydetail.do")
public class ReplyDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyDetailAction() {
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
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
			int num = Integer.parseInt(request.getParameter("num"));
			BoardService service = BoardService.getService();
			List<ReplyDTO> replyList = service.replyList(num);
	
		    JSONArray arr= new JSONArray();
		    
		    for(ReplyDTO dto: replyList) {
		    	JSONObject replyObj = new JSONObject();
		    	replyObj.put("replyno", dto.getReplyno());
		    	replyObj.put("id", dto.getId());
		    	replyObj.put("reply_writedate", dto.getReply_writedate());
		    	replyObj.put("replycontent", dto.getReplycontent());
		    	replyObj.put("boardno", dto.getBoardno());
		    	arr.add(replyObj);
		    }
		    out.print(arr);
		    
	}

}
