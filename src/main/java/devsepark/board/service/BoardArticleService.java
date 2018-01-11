package devsepark.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devsepark.board.common.SearchVo;
import devsepark.board.model.BoardArticle;

//게시판 서비스
@Service
public class BoardArticleService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//게시글 목록.
	public List<BoardArticle> selectArticleList(SearchVo param) {
		return sqlSession.selectList("selectArticleList", param);
	}
	//게시글 생성.
	public void insertArticle(BoardArticle param) {
		sqlSession.insert("insertArticle", param);
	}
	//게시글 수정
	public void updateArticle(BoardArticle param) {
		sqlSession.update("updateArticle", param);
	}
	//게시글 읽기
	public BoardArticle selectArticleOne(String param) {
		return sqlSession.selectOne("selectArticleOne", param);
	}
	//게시글 삭제
	public void deleteArticleOne(String param) {
		sqlSession.delete("deleteArticleOne", param);
	}
	//조회수 1증가
	public void updateArticleHit(String param) {
		sqlSession.update("updateArticleHit", param);
	}
	//전체 게시글 개수
	public Integer selectArticleCount(SearchVo param) {
		return sqlSession.selectOne("selectArticleCount", param);
	}
}
