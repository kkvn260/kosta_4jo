package group4.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import group4.comm.DBConnection;
import group4.dao.BoardDAO;
import group4.dto.BoardDTO;
import group4.dto.FileDTO;
import group4.dto.ReplyDTO;


public class BoardService {
	private static BoardService instance=new BoardService();
	public static BoardService getService() {
		return instance;
	}
	private BoardService () {}
	
	
	public int getTotalCount(String search, String searchtxt) {
		// TODO Auto-generated method stub
		DBConnection dbconn=DBConnection.getDBConn();
		Connection conn=null;
		int totalcount=0;
		try {
			conn=dbconn.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getDAO();
			totalcount=dao.getTotalCount(conn,search,searchtxt);
			System.out.println("totalcount!!!:"+totalcount);
			
			conn.commit();
		}catch(SQLException|NamingException e)
		{
			try {conn.rollback();} catch(SQLException e2) {}
		}finally {
			if(conn!=null) try { conn.close();} catch(SQLException e) {}
		}
		return totalcount;
	}
	
	
	public List<BoardDTO> getlist(int startrow,int endrow, String search , String searchtxt) {
		// TODO Auto-generated method stub
		
		DBConnection dbconn=DBConnection.getDBConn();
		Connection conn=null;
		List<BoardDTO> list=new ArrayList<BoardDTO>();
		try {
				conn=dbconn.getConnection();
				BoardDAO dao=BoardDAO.getDAO();
				
				list=dao.getList(conn,startrow,endrow,search,searchtxt);
		}catch(SQLException|NamingException e)
		{
			System.out.println(e);
		}finally {
			if(conn!=null) try { conn.close();} catch(SQLException e) {}
		}
		
		return list;
	}

	
	//list

	public void writeBoard(BoardDTO dto) {
		DBConnection dbconn=DBConnection.getDBConn();
		Connection conn=null;
		
		try {
			conn=dbconn.getConnection();
			conn.setAutoCommit(false);
			
			BoardDAO dao=BoardDAO.getDAO();
			dao.writeBoard(conn,dto);
			
			conn.commit();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
	}
	
	//
	public void insertFile(FileDTO dto2) {
		DBConnection dbconn=DBConnection.getDBConn();
		Connection conn=null;
		
		try {
			conn=dbconn.getConnection();
			conn.setAutoCommit(false);
			
			BoardDAO dao=BoardDAO.getDAO();
			dao.insertFile(conn,dto2);
			
			conn.commit();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}		
	}
	
	
	  
		public BoardDTO detail(int boardno) {
			DBConnection dbconn = DBConnection.getDBConn();
			Connection conn = null;
			BoardDTO dto = new BoardDTO();
			
			try {
				conn=dbconn.getConnection();
				
				BoardDAO dao = new BoardDAO();
				dto=dao.detail(boardno,conn);
				
			}catch(Exception e) {
				System.out.println(e);
			}finally {
				if(conn!=null) try {conn.close();}catch(SQLException e) {}
			}
			return dto;
		}//end detail
		
		
		public List<ReplyDTO> replyList(int num) {
			DBConnection dbConn = DBConnection.getDBConn();
			Connection conn = null;
			List<ReplyDTO> replyList = new ArrayList<>();
			
			try {
				conn = dbConn.getConnection();
				BoardDAO dao = new BoardDAO();
				replyList = dao.replyList(conn,num);
				
			}catch(Exception e) {
				System.out.println(e);
			}finally {
				if(conn!=null) try {conn.close();}catch(SQLException e) {}
			}
			return replyList;
		}//end replyList
		
		
		public void addReply(ReplyDTO dto) {
			DBConnection dbConn = DBConnection.getDBConn();
			Connection conn = null;
			
			try {
				conn = dbConn.getConnection();
				BoardDAO dao =BoardDAO.getDAO();
				dao.addReply(conn,dto);
				
			}catch(Exception e) {
				System.out.println(e);
			}finally {
				if(conn!=null) try {conn.close();}catch(SQLException e) {}
			}			
		}//end addReply
		
		
		public void replyDelete(int rno) {
			// TODO Auto-generated method stub
			DBConnection dbConn = DBConnection.getDBConn();
			Connection conn=null;
			
			try {
				conn= dbConn.getConnection();
				BoardDAO dao = new BoardDAO();
				dao.replyDelete(conn,rno);
				
			}catch(SQLException| NamingException e) {
				System.out.println(e);
			}finally {
				if(conn!=null) try{conn.close();}catch(SQLException e) {}
			}
		}//end replyDelete
	
}
