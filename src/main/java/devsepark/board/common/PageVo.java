package devsepark.board.common;

public class PageVo {
	private Integer displayRowCount = 10;           // 출력할 데이터 개수
    private Integer rowStart;                       // 시작행번호
    private Integer rowEnd;                         // 종료행 번호
    private Integer totalPage;                        // 전체 페이수
    private Integer totalRow = 0;                     // 전체 데이터 수
    private Integer page;                           // 현재 페이지
    private Integer pageStart;                      // 시작페이지
    private Integer pageEnd;                        // 종료페이지

    //전체 데이터 개수(total)를 이용하여 페이지수 계산. 
    public void pageCalculate(Integer total) {
        getPage();
        totalRow  = total;
        totalPage    = (int) ( total / displayRowCount );
        
        if ( total % displayRowCount > 0 ) {
            totalPage++;
        }

        pageStart = (page - (page - 1) % 10) ;
        pageEnd = pageStart + 9;
        if (pageEnd > totalPage) {
            pageEnd = totalPage;
        }
        
        rowStart = ((page - 1) * displayRowCount) + 1 ;
        rowEnd   = rowStart + displayRowCount - 1;
    } 
    
    //현재 페이지 번호
    public Integer getPage() {
        if (page == null || page == 0) {
            page = 1;
        }
        
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRowStart() {
        return rowStart;
    }

    public void setRowStart(Integer rowStart) {
        this.rowStart = rowStart;
    }

    public Integer getRowEnd() {
        return rowEnd;
    }

    public void setRowEnd(Integer rowEnd) {
        this.rowEnd = rowEnd;
    }

    public Integer getDisplayRowCount() {
        return displayRowCount;
    }

    public void setDisplayRowCount(Integer displayRowCount) {
        this.displayRowCount = displayRowCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public Integer getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(Integer pageEnd) {
        this.pageEnd = pageEnd;
    }
}
