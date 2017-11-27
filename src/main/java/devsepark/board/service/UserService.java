package devsepark.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import devsepark.board.model.UserDetailsVo;
import devsepark.board.model.UserVo;

@Service
public class UserService implements UserDetailsService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public UserService() {};
	
	public UserService(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insertUser(UserVo param) {
		return sqlSession.insert("insertUser", param);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Map<String, Object> user = sqlSession.selectOne("selectUserOne",username);
		System.out.println(user.toString());
		System.out.println(sqlSession.toString());
		if(user == null ) throw new UsernameNotFoundException(username);
		List<GrantedAuthority> grantedAuthList = new ArrayList<GrantedAuthority>();
		grantedAuthList.add(new SimpleGrantedAuthority(user.get("authority").toString()));
		System.out.println(grantedAuthList.get(0).toString());
		return new UserDetailsVo(user.get("username").toString(), user.get("password").toString(), user.get("enabled").equals(true), true, true, true, grantedAuthList,user.get("username").toString());
	}
}
