package devsepark.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devsepark.board.model.BoardGroup;

@Service
public class BoardGroupService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public BoardGroup selectBoardGroupOne(String param) {
		return sqlSession.selectOne("selectBoardGroupOne", param);
	}
}
