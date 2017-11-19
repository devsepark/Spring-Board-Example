package devsepark.board.model;

public class BoardGroup {
	private String id;
	private String simplename;
	private String detailedname;
	private String parent;
	private String isdeleted;
	private String isavailable;
	private String iscommentable;
	private String readonly;
	private String date;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSimplename() {
		return simplename;
	}
	public void setSimplename(String simplename) {
		this.simplename = simplename;
	}
	public String getDetailedname() {
		return detailedname;
	}
	public void setDetailedname(String detailedname) {
		this.detailedname = detailedname;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}
	public String getIsavailable() {
		return isavailable;
	}
	public void setIsavailable(String isavailable) {
		this.isavailable = isavailable;
	}
	public String getIscommentable() {
		return iscommentable;
	}
	public void setIscommentable(String iscommentable) {
		this.iscommentable = iscommentable;
	}
	public String getReadonly() {
		return readonly;
	}
	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
