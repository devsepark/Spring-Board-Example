package devsepark.board.common;

//페이징 처리를 위한 모델 클래스
public class PageVo {
	private Integer displayRowCount = 10;           // 출력할 데이터 개수
    private Integer startRow;                       // 시작행번호
    private Integer endRow;                         // 종료행 번호
    private Integer totalPage;                      // 전체 페이지 수
    private Integer totalRow = 0;                   // 전체 데이터 수
    private Integer page;                           // 현재 페이지
    private Integer startPage;                      // 보이는 첫번째 페이지 ex:1~10,11~20
    private Integer endPage;                        // 보이는 마지막 페이지 ex:1~10,11~20

    //게시글 수(totalCount)를 이용한 페이징 속성 설정.
    public void pageCalculate(Integer totalCount) {
        getPage();
        totalRow = totalCount;
        
        //게시글 수/페이지 표시 게시글
        totalPage = (int)(totalCount / displayRowCount);
        
        //(게시글 수/페이지 표시 게시글)의 나머지가 0보다 클 경우 페이지수+1
        totalPage += (totalCount % displayRowCount > 0)?1:0;
        
        //시작 페이지, 종료 페이지 설정
        startPage = (page - (page - 1) % 10);
        endPage = startPage + 9;
        if (endPage > totalPage) {
            endPage = totalPage;
        }
        
        //시작행, 종료행 설정
        startRow = ((page - 1) * displayRowCount) + 1;
        endRow   = startRow + displayRowCount - 1;
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
        return startRow;
    }

    public void setRowStart(Integer rowStart) {
        this.startRow = rowStart;
    }

    public Integer getRowEnd() {
        return endRow;
    }

    public void setRowEnd(Integer rowEnd) {
        this.endRow = rowEnd;
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

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getEndRow() {
		return endRow;
	}

	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}
}
