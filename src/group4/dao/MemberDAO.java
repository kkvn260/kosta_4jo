package group4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	//로그인
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
	public String  idcheck(Connection conn,String id) {


		//System.out.println(dto.getId());
		String result = "OK";
		
		StringBuilder sql=new StringBuilder();
		sql.append(" select id                                            ");
		sql.append(" from SignUp_Group4                        ");
		sql.append(" where id=?                                         ");
		
		ResultSet rs=null;
		try(
				PreparedStatement pstmt=conn.prepareStatement(sql.toString());
				){
		     pstmt.setString(1, id);
		     rs=pstmt.executeQuery();
		     
		  //  System.out.println(rs.next());
		     
		     //true일 때 , 동작
		     while (rs.next()) {
					result = "NotOK";
				}
		  
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		
		return  result;
	}
	
	//내정보확인
	public MemberDTO myInfo(Connection conn, String id) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		MemberDTO dto=new MemberDTO();
		sql.append(" select                                                      ");
		sql.append("            id                                                 ");
		sql.append("            , name                                         ");
		sql.append("            , email                                         ");
		sql.append(" from SignUp_Group4                           ");
		sql.append(" where                                                    ");
		sql.append("                id=?                                         ");
		
	
		ResultSet rs=null;
		
		
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());){
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
	
		return dto;
	}


}
