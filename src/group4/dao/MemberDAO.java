package group4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.Session;

import group4.dto.MemberDTO;

public class MemberDAO {

	private static MemberDAO dao=new MemberDAO();
	
	public static MemberDAO getDAO() {
		return dao;
	}
	private MemberDAO() {}
	
	//가입메서드
	public void joinMember(Connection conn, MemberDTO dto) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		sql.append(" insert into SignUp_Group4(                                        ");
		sql.append("                                                 id                                    ");
		sql.append("                                               , pwd                                ");
		sql.append("                                               , name                              ");
		sql.append("                                               , email)                             ");
		sql.append(" values(?,?,?,?)                                                                ");
		
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());){
		    pstmt.setString(1, dto.getId());
		    pstmt.setString(2, dto.getPwd());
		    pstmt.setString(3, dto.getName());
		    pstmt.setString(4, dto.getEmail());
		    pstmt.executeUpdate();
		    
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	public int  logindata(Connection conn, String id, String pwd) {
		// TODO Auto-generated method stub
		int result=-1;
		StringBuilder sql=new StringBuilder();
		sql.append(" select pwd                                   ");
		sql.append(" from SignUp_Group4                 ");
		sql.append(" where id=?                                 ");
		ResultSet rs=null;
	
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());){
			pstmt.setString(1,id);
			
			rs=pstmt.executeQuery();
		
			if(rs.next()) {
				if(rs.getString("pwd").equals(pwd)) {
					result=1;
				}else {
					result=0;
				}
			}
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		return result;
	
	}
	//아이디 중복체크
/*
	public int idCheck(Connection conn,String id) {
		int value=0;
	
		StringBuilder sql=new StringBuilder();
		sql.append(" select id                                              ");
		sql.append(" from SignUP_Group4                        ");
		sql.append(" where id=?                                         ");
		
		ResultSet rs=null;
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());){
		     pstmt.setString(1, id);
		     rs=pstmt.executeQuery();
		     
		     if(rs.next()) {
		    	 value=1;
		     }
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		return value;
	}
	*/
}
