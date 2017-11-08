package devsepark.board.common;

public class SearchVo extends PageVo{
	private String boardGroupId;
	private String searchKeyword = "";           // 검색 키워드
	private String searchType = "";                // 검색 필드: 제목, 내용 
	private String[] searchTypeArr;                // 검색 필드를 배열로 변환

	
	public String getBoardGroupId() {
		return boardGroupId;
	}
	public void setBoardGroupId(String boardGroupId) {
		this.boardGroupId = boardGroupId;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String[] getSearchTypeArr() {
		this.searchTypeArr = searchType.split(",");
		return searchTypeArr;
	}
}
