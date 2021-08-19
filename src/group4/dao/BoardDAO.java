package group4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import group4.comm.DBConnection;
import group4.dto.BoardDTO;
import group4.dto.FileDTO;
import group4.dto.ReplyDTO;

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
		sql.append("							,likeno,filename)		");
		sql.append("			values(	?,?,0,?,sysdate(),?,0,?)		");


		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getId()); 
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getBoard_name());
			pstmt.setString(5, dto.getFilename());
			pstmt.executeUpdate();

		}catch(Exception e) {
			System.out.println(e);
		}

	}


	//
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

	//page
	public int getTotalCount(Connection conn, String search, String searchtxt,String category) {
		// TODO Auto-generated method stub

		StringBuilder sql = new StringBuilder();
		sql.append(" select  count(*)             ");
		sql.append("  from   Board_Group4         ");

		if(!search.equals("") && !searchtxt.equals(""))
		{
			if(search.equals("title"))
			{
				sql.append(" where title like ?  and board_name like ?           ");
			}
			else if(search.equals("id"))
			{
				sql.append(" where lower(id) like ? and board_name like ? ");
			}
			else if(search.equals("content"))
			{
				sql.append(" where content like ?  and board_name like ?  ");

			}
		}else {
			sql.append("	where	board_name	like ? 	");
		}

		int totalcount=0;
		ResultSet rs=null;
		try(
				PreparedStatement pstmt=conn.prepareStatement(sql.toString());	

				){
			if(!search.equals("") && !searchtxt.equals(""))
			{
				pstmt.setString(1, "%"+searchtxt.toLowerCase()+"%");
				pstmt.setString(2, "%"+category+"%");
			}else {
				pstmt.setString(1, "%"+category+"%");
			}
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				totalcount=rs.getInt(1);

			}
		}catch(SQLException e)
		{
			System.out.println(e);
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}

		}
		return totalcount;

	}

	public List<BoardDTO> getList(Connection conn,int startrow, int endrow, String search, String searchtxt,String category) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		sql.append(" select      c.*                          	         ");
		sql.append(" from (                                		         ");
		sql.append("        select @rownum:=@rownum+1 as rnum, b.* 		 ");
		sql.append("        from (                          	         ");
		sql.append("               select                  		         ");
		sql.append("                      boardno         		         ");
		sql.append("                     ,title            		         ");
		sql.append("                     ,id               		         ");
		sql.append("                     ,viewno            	         ");
		sql.append("                     ,content          		         ");
		sql.append("                     ,writedate        		         ");
		sql.append("                     ,likeno           		         ");
		sql.append("                     ,board_name           		     ");
		sql.append("        from Board_Group4                            ");

		if(!search.equals("")&& !searchtxt.equals(""))
		{
			sql.append("where "+search+" like ?");
			if(!category.equals("")) {
				sql.append("	and board_name like ?	");
			}
			sql.append("             )b  ,   (select @rownum:=0) R    			 ");
			sql.append("	order by writedate desc	");
			sql.append("      )    c                                            					 ");
			sql.append(" where rnum>=? and rnum<=?        	");
			
		}else {
			if(!category.equals("")) {
				sql.append("where board_name like ?");
				
			}
			sql.append("             )b  ,   (select @rownum:=0) R    			 ");
			sql.append("	order by writedate desc	");
			sql.append("      )    c                                            					 ");
			sql.append(" where rnum>=? and rnum<=?                              ");

			
		}

		List<BoardDTO> list=new ArrayList<BoardDTO>();
		ResultSet rs=null;
		try(
				PreparedStatement pstmt=conn.prepareStatement(sql.toString());

				) {
			if(!search.equals("") && !searchtxt.equals(""))
			{
				if(!category.equals("")) {
					pstmt.setString(1, "%"+searchtxt.toLowerCase()+"%");
					pstmt.setString(2, "%"+category+"%");
					pstmt.setInt(3, startrow);
					pstmt.setInt(4, endrow);
				}else {
					pstmt.setString(1, "%"+searchtxt.toLowerCase()+"%");
					pstmt.setInt(2, startrow);
					pstmt.setInt(3, endrow);
				}
				

			}else
			{

				if(!category.equals("")) {
					pstmt.setString(1, category);
					pstmt.setInt(2, startrow);
					pstmt.setInt(3, endrow);
				}
				else {
					pstmt.setInt(1, startrow);
					pstmt.setInt(2, endrow);
				}
			}
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				BoardDTO dto=new BoardDTO();
				dto.setBoardno(rs.getInt("boardno"));
				dto.setTitle(rs.getString("title"));
				dto.setId(rs.getString("id"));
				dto.setContent(rs.getString("content"));
				dto.setViewno(rs.getInt("viewno"));
				dto.setWritedate(rs.getString("writedate"));
				dto.setLikeno(rs.getInt("likeno")); 
				dto.setBoard_name(rs.getString("board_name"));
				list.add(dto);
			}
		}catch(SQLException e)
		{
			System.out.println(e);
		}finally{
			if(rs!=null) try { rs.close();} catch(SQLException e) {}
		}

		return list;



	}

	public void viewnocount(Connection conn, int boardno) {
		StringBuilder sql=new StringBuilder();
		sql.append("  update from Board_Group4        ");
		sql.append("  set                             ");
		sql.append("         viewno=nvl(viewno,0) +1  ");
		sql.append("  where                           ");
		sql.append("         boardno=?                ");
		
		try(
				PreparedStatement pstmt=conn.prepareStatement(sql.toString());
				){
				
				pstmt.setInt(1, boardno);
				pstmt.executeUpdate();
		}catch(SQLException e) {
			
			System.out.println(e);
		}
		
	}

	public void insertFile(Connection conn, FileDTO dto2) {
		StringBuilder sql=new StringBuilder();
		sql.append("	insert into	file_Group4(					");
		sql.append("							filename			");
		sql.append("							,realname)			");
		sql.append("			values(	?,?)						");

		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, dto2.getFilename());
			pstmt.setString(2, dto2.getRealname()); 
			pstmt.executeUpdate();

		}catch(Exception e) {
			System.out.println(e); 
		}

	}
	
	
	public List<ReplyDTO> replyList(Connection conn, int num) {
		StringBuilder sql=new StringBuilder();
		sql.append("  select   			 		");
		sql.append("          replyno,	 		");
		sql.append("          id,    	 		");
		sql.append("          reply_writedate,  ");
		sql.append("          replycontent,     ");
		sql.append("          boardno	 		");
		sql.append("  from reply_Group4			");
		sql.append("  where boardno=?			");
		
		ResultSet rs =null;
		List<ReplyDTO> replyList = new ArrayList<>();
		
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
			){
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ReplyDTO dto = new ReplyDTO();
				dto.setReplyno(rs.getInt("replyno"));
				dto.setId(rs.getString("id"));
				dto.setReply_writedate(rs.getString("reply_writedate"));
				dto.setReplycontent(rs.getString("replycontent"));
				dto.setBoardno(rs.getInt("boardno"));
				replyList.add(dto);
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}finally{
			if(rs!=null) try { rs.close();} catch(SQLException e) {}
		}
		return replyList;
	}//end replyList
	
	
	public void addReply(Connection conn, ReplyDTO dto) {
		StringBuilder sql=new StringBuilder();
		sql.append(" insert into reply_Group4(	         ");
		sql.append("          id,    	 		         ");
		sql.append("          replycontent,              ");
		sql.append("          reply_writedate,           ");
		sql.append("          boardno)	 		         ");
		sql.append("   values (?,?,sysdate(),?)          ");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())
				  ){
					pstmt.setString(1, dto.getId());
					pstmt.setString(2, dto.getReplycontent());
					pstmt.setInt(3, dto.getBoardno());
					pstmt.executeUpdate();
					
				}catch(SQLException e) {
					System.out.println(e);
				}
		}//end addReply
	
	
	public void replyDelete(Connection conn, int rno) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		sql.append("  delete from reply_Group4	 ");
		sql.append("         where replyno= ?    ");  
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())
				  ){
					pstmt.setInt(1, rno);
					pstmt.executeUpdate();
					
				}catch(SQLException e) {
					System.out.println(e);
				}
		
	}//end replyDelete
	public List<BoardDTO> topViewList(Connection conn) {
		StringBuilder sql=new StringBuilder();
		sql.append("	select 											 ");
		sql.append("                      boardno         		         ");
		sql.append("                     ,title            		         ");
		sql.append("                     ,id               		         ");
		sql.append("                     ,viewno            	         ");
		sql.append("                     ,writedate            	         ");
		sql.append("                     ,likeno            	         ");
		sql.append("     from Board_Group4                   	         ");
		sql.append("     order by viewno desc		limit 10          	         ");
		
		
		List<BoardDTO> list=new ArrayList<BoardDTO>();
		ResultSet rs=null;
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
				){
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto=new BoardDTO();
				dto.setBoardno(rs.getInt("boardno"));
				dto.setTitle(rs.getString("title"));
				dto.setId(rs.getString("id"));
				dto.setViewno(rs.getInt("viewno"));
				dto.setWritedate(rs.getString("writedate"));
				dto.setLikeno(rs.getInt("likeno")); 
				list.add(dto);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	public List<BoardDTO> topLikeList(Connection conn) {
		StringBuilder sql=new StringBuilder();
		sql.append("	select 											 ");
		sql.append("                      filename            	         ");
		sql.append("                     ,likeno            	         ");
		sql.append("                     ,boardno            	         ");
		sql.append("                     ,title            	         ");
		sql.append("     from Board_Group4                   	         ");
		sql.append("     order by likeno desc		limit 5          	 ");
		
		
		List<BoardDTO> list=new ArrayList<BoardDTO>();
		ResultSet rs=null;
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
				){
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto=new BoardDTO();
				dto.setBoardno(rs.getInt("boardno"));
				dto.setLikeno(rs.getInt("likeno"));
				dto.setFilename(rs.getString("filename"));
				dto.setTitle(rs.getString("title"));
				list.add(dto);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public void deleteBoard(Connection conn, int bno) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		sql.append("  delete from Board_Group4	 ");
		sql.append("         where replyno= ?    ");
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
		   ){
					pstmt.setInt(1, bno);
					pstmt.executeUpdate();
			}catch(SQLException e) {
				System.out.println(e);
			}
	}//end deleteBoard
	

}


