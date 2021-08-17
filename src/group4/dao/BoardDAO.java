package group4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import group4.dto.BoardDTO;

public class BoardDAO {
	private static BoardDAO instance=new BoardDAO();
	public static BoardDAO getDAO() {
		return instance;
	}
	public void writeBoard(Connection conn,BoardDTO dto) {
		StringBuilder sql=new StringBuilder();
		sql.append("	insert into	Board_Group4(						");
		sql.append("							title					");
		sql.append("							,id						");
		sql.append("							,viewno					");
		sql.append("							,content				");
		sql.append("							,writedate				");
		sql.append("							,board_name				");
		sql.append("							,likeno)				");
		sql.append("			values(	?,?,0,?,sysdate(),?,0)			");
		
	
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, "hong"); // id 임시로 써줌
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getBoard_name());
			pstmt.executeUpdate();

		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	//특정게시글조회
	/*첨부파일 어떻게 받아올지 고민*/
		public BoardDTO detail(int boardno, Connection conn) {
			StringBuilder sql = new StringBuilder();
			sql.append("  select boardno, title, id, viewno, content, writedate ");
			sql.append("  from Board_Group4  ");
			sql.append("  where boardno= ? ");
			ResultSet rs =null;
			BoardDTO dto = new BoardDTO();
			
			try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
				){
				pstmt.setInt(1, boardno);
				rs=pstmt.executeQuery();	
				if(rs.next()) {
					   dto.setBoardno(rs.getInt("boardno"));
					   dto.setTitle(rs.getString("title"));
					   dto.setId(rs.getString("id"));
					   dto.setViewno(rs.getInt("viewno"));
					   dto.setContent(rs.getString("content"));
					   dto.setWritedate(rs.getString("writedate"));
					   
					}
					
				}catch(SQLException e) {
					System.out.println(e);
				}
				return dto;
		}
	
}
