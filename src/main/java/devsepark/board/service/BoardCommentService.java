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
	public void insertBoardComment(BoardComment param) {
		sqlSession.insert("insertBoardComment", param);
	}
	//댓글 수정
	public void updateBoardComment(BoardComment param) {
		sqlSession.update("updateBoardComment", param);
	}
	//댓글 읽기
	public List<BoardComment> selectBoardCommentList(String param) {
		return sqlSession.selectList("selectBoardCommentList", param);
	}
	//댓글 삭제
	public void deleteBoardComment(String param) {
		sqlSession.delete("deleteBoardComment", param);
	}    
}
