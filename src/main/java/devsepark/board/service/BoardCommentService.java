package devsepark.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devsepark.board.model.BoardComment;

//
@Service
public class BoardCommentService {
	@Autowired
	private SqlSessionTemplate sqlSession;

	//댓글 저장
	public void insertBoardComment(BoardComment boardComment) {
		sqlSession.insert("insertBoardComment", boardComment);
	}
	//댓글 수정
	public void updateBoardComment(BoardComment boardComment) {
		sqlSession.update("updateBoardComment", boardComment);
	}
	//댓글 읽기
	public List<BoardComment> selectBoardCommentList(String id) {
		return sqlSession.selectList("selectBoardCommentList", id);
	}
	//댓글 삭제
	public void deleteBoardComment(String id) {
		sqlSession.delete("deleteBoardComment", id);
	}
	//댓글 하나 읽기
	public BoardComment selectBoardCommentOne(String id) {
		return sqlSession.selectOne("selectBoardCommentOne", id);
	}
}
