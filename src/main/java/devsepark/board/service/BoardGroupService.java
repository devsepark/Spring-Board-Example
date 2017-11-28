package devsepark.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devsepark.board.model.BoardGroup;

//게시판 그룹 서비스
@Service
public class BoardGroupService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public BoardGroup selectBoardGroupOne(String param) {
		return sqlSession.selectOne("selectBoardGroupOne", param);
	}
	
	public List<BoardGroup> selectBoardGroupList() {
		return sqlSession.selectList("selectBoardGroupList");
	}
}
