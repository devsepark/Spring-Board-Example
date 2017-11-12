package devsepark.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devsepark.board.common.CommentVo;
import devsepark.board.common.SearchVo;
import devsepark.board.model.BoardArticle;

//게시판 서비스
@Service
public class BoardArticleService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//게시글 목록.
	public List<?> selectBoardList(SearchVo param) {
		return sqlSession.selectList("selectBoardList", param);
	}
	//게시글 생성.
	public void insertBoard(BoardArticle param) {
		sqlSession.insert("insertBoard", param);
	}
	//게시글 수정
	public void updateBoard(BoardArticle param) {
		sqlSession.insert("updateBoard", param);
	}
	//게시글 읽기
	public BoardArticle selectBoardOne(String param) {
		return sqlSession.selectOne("selectBoardOne", param);
	}
	//게시글 삭제
	public void deleteBoardOne(String param) {
		sqlSession.delete("deleteBoardOne", param);
	}
	//조회수 1증가
	public void updateBoardHit(String param) {
		sqlSession.update("updateBoardHit", param);
	}
	//전체 게시글 개수
	public Integer selectBoardCount(SearchVo param) {
		return sqlSession.selectOne("selectBoardCount", param);
	}

	public void insertBoardReply(CommentVo param) {
		if (param.getReplyid()==null || "".equals(param.getReplyid())) {
			sqlSession.insert("insertBoardReply", param);
		} else {
			sqlSession.insert("updateBoardReply", param);
		}
	}
}
