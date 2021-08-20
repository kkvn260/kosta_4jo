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
	
	
	public int getTotalCount(String search, String searchtxt,String category) {
		// TODO Auto-generated method stub
		DBConnection dbconn=DBConnection.getDBConn();
		Connection conn=null;
		int totalcount=0;
		try {
			conn=dbconn.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getDAO();
			totalcount=dao.getTotalCount(conn,search,searchtxt,category);
			
			conn.commit();
		}catch(SQLException|NamingException e)
		{
			try {conn.rollback();} catch(SQLException e2) {}
		}finally {
			if(conn!=null) try { conn.close();} catch(SQLException e) {}
		}
		return totalcount;
	}
	

	public List<BoardDTO> getlist(int startrow,int endrow, String search , String searchtxt,String category) {
		// TODO Auto-generated method stub
		
		DBConnection dbconn=DBConnection.getDBConn();
		Connection conn=null;
		List<BoardDTO> list=new ArrayList<BoardDTO>();
		try {
				conn=dbconn.getConnection();
				BoardDAO dao=BoardDAO.getDAO();
				
				list=dao.getList(conn,startrow,endrow,search,searchtxt,category);
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
		
		public int deleteBoard(int bno) {
			// TODO Auto-generated method stub
			DBConnection dbconn = DBConnection.getDBConn();
			Connection conn = null;
			int result=0;
			
			try {
				conn=dbconn.getConnection();
				BoardDAO dao = new BoardDAO();
				dao.deleteBoard(conn,bno);	
				
			}catch(Exception e) {
				System.out.println(e);
			}finally {
				if(conn!=null) try {conn.close();}catch(SQLException e) {}
			}
			return result;
			
		}
		
		
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

		public List<BoardDTO> topViewList() {
			DBConnection dbConn = DBConnection.getDBConn();
			Connection conn=null;
			List<BoardDTO> list=new ArrayList<BoardDTO>();
			try {
				conn=dbConn.getConnection();
				BoardDAO dao=BoardDAO.getDAO();
				list=dao.topViewList(conn);
			}catch(SQLException| NamingException e) {
				System.out.println(e);
			}finally {
				if(conn!=null) try{conn.close();}catch(SQLException e) {}
			}
			return list;
		}
		public List<BoardDTO> topLikeList() {
			DBConnection dbConn = DBConnection.getDBConn();
			Connection conn=null;
			List<BoardDTO> list=new ArrayList<BoardDTO>();
			try {
				conn=dbConn.getConnection();
				BoardDAO dao=BoardDAO.getDAO();
				list=dao.topLikeList(conn);
			}catch(SQLException| NamingException e) {
				System.out.println(e);
			}finally {
				if(conn!=null) try{conn.close();}catch(SQLException e) {}
			}
			return list;
		}
		
		public List<BoardDTO> noticeList() {
			DBConnection dbConn = DBConnection.getDBConn();
			Connection conn=null;
			List<BoardDTO> list=new ArrayList<BoardDTO>();
			try {
				conn=dbConn.getConnection();
				BoardDAO dao=BoardDAO.getDAO();
				list=dao.noticeList(conn);
			}catch(SQLException| NamingException e) {
				System.out.println(e);
			}finally {
				if(conn!=null) try{conn.close();}catch(SQLException e) {}
			}
			return list;
		}
		
		public void modifyBoard(BoardDTO dto) {
			DBConnection dbConn = DBConnection.getDBConn();
			Connection conn=null;
			
			try {
				conn= dbConn.getConnection();
				BoardDAO dao = new BoardDAO();
				dao.modifyBoard(conn,dto);
				
			}catch(SQLException| NamingException e) {
				System.out.println(e);
			}finally {
				if(conn!=null) try{conn.close();}catch(SQLException e) {}
			}
		}
		public void viewUp(int boardno) {
			DBConnection dbConn = DBConnection.getDBConn();
			Connection conn=null;
			
			try {
				conn= dbConn.getConnection();
				BoardDAO dao = new BoardDAO();
				dao.viewUp(conn,boardno);
				
			}catch(SQLException| NamingException e) {
				System.out.println(e);
			}finally {
				if(conn!=null) try{conn.close();}catch(SQLException e) {}
			}
			
		}
		
		
		public int likeCount(int num) {
			// TODO Auto-generated method stub
			DBConnection dbconn = DBConnection.getDBConn();
			Connection conn = null;
			BoardDTO dto = new BoardDTO();
			int likecount=0;
	
			try {
				conn=dbconn.getConnection();
				BoardDAO dao = new BoardDAO();
				dto = dao.likeCount(conn, num);
				likecount = dto.getLikeno();
				System.out.println(likecount);
				
			}catch(SQLException| NamingException e) {
				System.out.println(e);
			}finally {
				if(conn!=null) try{conn.close();}catch(SQLException e) {}
			}
			return likecount;
		}//end likeCount
		
		
		public int likeCheck(int num, String id) {
			DBConnection dbconn = DBConnection.getDBConn();
			Connection conn = null;
			int check=1;
			
			try {
				conn=dbconn.getConnection();
				BoardDAO dao = new BoardDAO();
				check= dao.likeCheck(conn, num,id);
				
			}catch(SQLException| NamingException e) {
				System.out.println(e);
			}finally {
				if(conn!=null) try{conn.close();}catch(SQLException e) {}
			}
			return check;
		}//end likeCheck
		
		
		public void likeUpdate(int num, String id) {

			DBConnection dbconn = DBConnection.getDBConn();
			Connection conn = null;
			
			try {
				conn=dbconn.getConnection();
				BoardDAO dao = new BoardDAO();
				dao.likeUpdate(conn, num,id);
				
			}catch(SQLException| NamingException e) {
				System.out.println(e);
			}finally {
				if(conn!=null) try{conn.close();}catch(SQLException e) {}
			}
			
		}//end likeUpdate
		
		
		public void likeCancel(int num, String id) {

			DBConnection dbconn = DBConnection.getDBConn();
			Connection conn = null;
			
			try {
				conn=dbconn.getConnection();
				BoardDAO dao = new BoardDAO();
				dao.likeCancel(conn,num,id);
				
			}catch(SQLException| NamingException e) {
				System.out.println(e);
			}finally {
				if(conn!=null) try{conn.close();}catch(SQLException e) {}
			}
			
		}//end likeCancel
		
		
		public void modifyLike(int i, int num) {
			
			DBConnection dbconn = DBConnection.getDBConn();
			Connection conn = null;
			
			try {
				conn=dbconn.getConnection();
				BoardDAO dao = new BoardDAO();
				dao.modifyLike(conn,i,num);
				
			}catch(SQLException| NamingException e) {
				System.out.println(e);
			}finally {
				if(conn!=null) try{conn.close();}catch(SQLException e) {}
			}
		}//end modifyLike
		public ArrayList<ReplyDTO> getReplyCount() {
			DBConnection dbconn=DBConnection.getDBConn();
			Connection conn=null;
			ArrayList<ReplyDTO> arr=new ArrayList<ReplyDTO>();
			try {
				conn=dbconn.getConnection();
				conn.setAutoCommit(false);
				BoardDAO dao=BoardDAO.getDAO();
				arr=dao.getTotalCount(conn);

				conn.commit();
			}catch(SQLException|NamingException e)
			{
				try {conn.rollback();} catch(SQLException e2) {}
			}finally {
				if(conn!=null) try { conn.close();} catch(SQLException e) {}
			}
			return arr;
		}

		
	
}
