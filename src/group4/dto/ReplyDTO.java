package group4.dto;

public class ReplyDTO {
	
	private int replyno;
	private int board_id;
	private String id;
	private String reply_writedate;
	private String replycontent;
	
	public int getReplyno() {
		return replyno;
	}
	public void setReplyno(int replyno) {
		this.replyno = replyno;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReply_writedate() {
		return reply_writedate;
	}
	public void setReply_writedate(String reply_writedate) {
		this.reply_writedate = reply_writedate;
	}
	public String getReplycontent() {
		return replycontent;
	}
	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}	

}
