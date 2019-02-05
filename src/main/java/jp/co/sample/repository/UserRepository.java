package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.User;

@Repository
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	private final static RowMapper<User> USER_ROW_MAPPER = (rs,i) ->{
		User user = new User();
		
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		return user;
	};
	
	
	/**
	 * ユーザーの名前（メールアドレス）をもとにユーザー情報を検索する.
	 * 
	 * @param name ユーザ名（メールアドレス）
	 * @return　検索結果のユーザー情報.
	 */
	public User findByName(String email) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email);
		String sql = "SELECT id,name,password FROM users WHERE name = :email;";
		List<User> userList = template.query(sql, param, USER_ROW_MAPPER);
		System.out.println(userList.size());
		
		if(userList.size()==0) {
			return null;
		}
		return userList.get(0);
	}
	
	/**
	 * ユーザー情報を保存または更新する.
	 * 
	 * @param user 保存または更新するユーザー情報
	 * @return  保存または更新するユーザー情報
	 */
	public User save(User user) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		String sql = null;
		if(user.getId()==null) {
			sql = "INSERT INTO users(name,password) VALUES (:email,:password);";
			template.update(sql, param);
		}else {
			sql = "UPDATE users SET name=:email,password=:password WHERE id=:id;";
			template.update(sql, param);
		}
		return user;
	}
	
}
