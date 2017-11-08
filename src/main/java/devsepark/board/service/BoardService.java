package devsepark.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devsepark.board.common.CommentVo;
import devsepark.board.common.SearchVo;
import devsepark.board.model.Board;

@Service
public class BoardService {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<?> selectBoardList(SearchVo param) {
		return sqlSession.selectList("selectBoardList", param);
	}

	public void insertBoard(Board param) {
		sqlSession.insert("insertBoard", param);
	}

	public void updateBoard(Board param) {
		sqlSession.insert("updateBoard", param);
	}

	public Board selectBoardOne(String param) {
		return sqlSession.selectOne("selectBoardOne", param);
	}

	public void deleteBoardOne(String param) {
		sqlSession.delete("deleteBoardOne", param);
	}

	public void updateBoardHit(String param) {
		sqlSession.update("updateBoardHit", param);
	}

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
