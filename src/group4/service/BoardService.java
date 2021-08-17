package group4.service;

import java.sql.Connection;
import java.sql.SQLException;

import group4.comm.DBConnection;
import group4.dao.BoardDAO;
import group4.dto.BoardDTO;
import group4.dto.FileDTO;

public class BoardService {
	private static BoardService instance=new BoardService();
	public static BoardService getService() {
		return instance;
	}
	private BoardService () {}
	
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
	
}
