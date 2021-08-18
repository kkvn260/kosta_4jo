package group4.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import group4.comm.DBConnection;
import group4.dao.MemberDAO;
import group4.dto.MemberDTO;

public class MemberService {
	private static MemberService memberService=new MemberService();
	
	public static MemberService getMemberService() {
		return memberService;
		
	}
	private MemberService() {}
	
	public void JoinMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		DBConnection dbconn=DBConnection.getDBConn();
		Connection conn=null;
		
		try {
			conn=dbconn.getConnection();
			
			MemberDAO dao=MemberDAO.getDAO();
			dao.joinMember(conn,dto);
		}catch(SQLException |NamingException e) {
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}
	public int login(String id, String pwd) {
		// TODO Auto-generated method stub
		DBConnection dbconn=DBConnection.getDBConn();
		Connection conn=null;
		int result=0;
		
		try {
			conn=dbconn.getConnection();
			
			MemberDAO dao=MemberDAO.getDAO();
			result=dao.logindata(conn,id,pwd);
		}catch(SQLException | NamingException e) {
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return result;
	}
	public String idcheckData(String id) {
		// TODO Auto-generated method stub

		DBConnection dbconn=DBConnection.getDBConn();
		Connection conn=null;
		String result = "";

		try {
			conn=dbconn.getConnection();
			
			MemberDAO dao=MemberDAO.getDAO();
			result=dao.idcheck(conn, id);

		}catch(SQLException | NamingException e) {
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return result;
	}
	public MemberDTO info(String id) {
		// TODO Auto-generated method stub
		DBConnection dbconn=DBConnection.getDBConn();
		Connection conn=null;
		MemberDTO dto=new MemberDTO();
		
		try {
			conn=dbconn.getConnection();
			MemberDAO dao=MemberDAO.getDAO();
			dto=dao.myInfo(conn,id);
		}catch(SQLException | NamingException e) {
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return dto;
	}


	
}
