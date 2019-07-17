package blog.yujun.leo.dto;

import java.util.Date;

public class BoardDTO {

	private int board_num;
	private String board_title;
	private String board_writer;
	private String board_content; 
	private int board_viewCount;
	private Date board_date;
	
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public int getBoard_viewCount() {
		return board_viewCount;
	}
	public void setBoard_viewCount(int board_viewCount) { this.board_viewCount = board_viewCount; }
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	
	
	
	
}
