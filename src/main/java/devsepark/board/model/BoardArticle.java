package devsepark.board.model;

//게시판 모델 클래스
public class BoardArticle {
	private String groupid;		//그룹id
	private String id;			//게시글id
	private String title;		//게시글제목
	private String writer;		//게시글작성자
	private String content;		//게시글내용
	private String date;		//게시글작성일자
	private String hit;			//게시글조회수
	private String isdeleted;	//게시글삭제여부
	
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
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
	public String getIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}
}
