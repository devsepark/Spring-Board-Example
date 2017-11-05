package devsepark.board.service;

import javax.servlet.http.HttpSession;

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
	
	public boolean login(User user, HttpSession session) {
		String result = sqlSession.selectOne("login", user);
		boolean success = (result!=null)?true:false;
		if(success) {
			session.setAttribute("user", user);
		}
		return success;
	}
	
	public void logout(HttpSession session) {
		session.invalidate();
	}

}
