package devsepark.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devsepark.board.model.User;

@Service
public class UserService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public void insertUser(User user) {
		sqlSession.insert("insertUser", user);
	}
	
	public boolean login(User user) {
		String result = sqlSession.selectOne("login", user);
		return (result!=null)?true:false;
	}

}
