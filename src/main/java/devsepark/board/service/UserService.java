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

//스프링 시큐리티 UserDetailsService를 구현한 서비스
@Service
public class UserService implements UserDetailsService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public UserService() {};
	
	public UserService(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void insertUser(UserVo param) {
		try {
			sqlSession.insert("insertUser", param);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//스프링 시큐리티 인증
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Map<String, Object> user = sqlSession.selectOne("selectUserOne",username);
		if(user == null ) throw new UsernameNotFoundException(username);
		List<GrantedAuthority> grantedAuthList = new ArrayList<GrantedAuthority>();
		grantedAuthList.add(new SimpleGrantedAuthority(user.get("authority").toString().toUpperCase()));
		System.out.println(grantedAuthList.get(0).toString());
		return new UserDetailsVo(user.get("username").toString(), 
				user.get("password").toString(), 
				user.get("enabled").equals(true), 
				true, true, true, 
				grantedAuthList,
				user.get("username").toString(),
				user.get("name").toString());
	}
}
