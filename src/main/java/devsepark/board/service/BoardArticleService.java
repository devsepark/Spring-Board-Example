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
	public List<BoardArticle> selectArticleList(SearchVo searchVo) {
		return sqlSession.selectList("selectArticleList", searchVo);
	}
	//게시글 생성.
	public void insertArticle(BoardArticle boardArticle) {
		sqlSession.insert("insertArticle", boardArticle);
	}
	//게시글 수정
	public void updateArticle(BoardArticle boardArticle) {
		sqlSession.update("updateArticle", boardArticle);
	}
	//게시글 읽기
	public BoardArticle selectArticleOne(String id) {
		return sqlSession.selectOne("selectArticleOne", id);
	}
	//게시글 삭제
	public void deleteArticleOne(String id) {
		sqlSession.delete("deleteArticleOne", id);
	}
	//조회수 1증가
	public void updateArticleHit(String id) {
		sqlSession.update("updateArticleHit", id);
	}
	//전체 게시글 개수
	public Integer selectArticleCount(SearchVo searchVo) {
		return sqlSession.selectOne("selectArticleCount", searchVo);
	}
	//최근 게시물
	public BoardArticle selectRecentArticle() {
		return sqlSession.selectOne("selectRecentArticle");
	}
}
