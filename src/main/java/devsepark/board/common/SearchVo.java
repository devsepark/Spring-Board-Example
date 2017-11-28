package devsepark.board.common;

//검색 처리를 위한 모델 클래스
public class SearchVo extends PageVo{
	private String groupid;							// 게시판 그룹 id
	private String searchKeyword = "";           	// 검색 키워드
	private String searchType = "";					// 검색 필드: 제목, 내용 
	private String[] searchTypeArray;               // 검색 필드를 배열로 변환

	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
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
	public String[] getSearchTypeArray() {
		String[] splitType = searchType.split(",");
		//검색 필드가 없을 경우 (체크되있지 않을 경우) null값 반환
		if(splitType.length <= 0 || searchType.length() <= 0 || searchType == "") {
			return null;
		} else {
			this.searchTypeArray = splitType;
		}
		return searchTypeArray;
	}
	public void setSearchTypeArray(String[] searchTypeArray) {
		this.searchTypeArray = searchTypeArray;
	}
}
