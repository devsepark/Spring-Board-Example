package devsepark.board.model;

public class BoardGroup {
	private String id;
	private String simpleName;
	private String detailedName;
	private String parent;
	private String deleted;
	private String available;
	private String commentable;
	private String writable;
	private String date;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSimpleName() {
		return simpleName;
	}
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
	public String getDetailedName() {
		return detailedName;
	}
	public void setDetailedName(String detailedName) {
		this.detailedName = detailedName;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public String getCommentable() {
		return commentable;
	}
	public void setCommentable(String commentable) {
		this.commentable = commentable;
	}
	public String getWritable() {
		return writable;
	}
	public void setWritable(String writable) {
		this.writable = writable;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
