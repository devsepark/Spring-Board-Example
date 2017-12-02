package devsepark.board.model;

//게시판 모델 클래스
public class BoardArticle {
	private String groupId;		//그룹id
	private String id;			//게시글id
	private String title;		//게시글제목
	private String writer;		//게시글작성자
	private String content;		//게시글내용
	private String date;		//게시글작성일자
	private String hit;			//게시글조회수
	private String deleted;		//게시글삭제여부
	private String commentCount;//댓글 수
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	//제목 스크립트 실행 방지
	public String getTitle() {
		return title.replaceAll("(?i)<script", "&lt;script");
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	//글 스크립트 실행 방지
	public String getContent() {
		return content.replaceAll("(?i)<script", "&lt;script");
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public String getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}
}
