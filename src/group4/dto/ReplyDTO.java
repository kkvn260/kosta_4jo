package group4.dto;

public class ReplyDTO {
	
	private int replyno;
	private int boardno;
	private String id;
	private String reply_writedate;
	private String replycontent;
	
	public int getReplyno() {
		return replyno;
	}
	public void setReplyno(int replyno) {
		this.replyno = replyno;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
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
