package jp.co.sample.domain;

/**
 * ユーザー情報を表すドメイン.
 * 
 * @author yuta.ikeda
 *
 */
public class User {

	
	/**	ユーザーID */
	private Integer id;
	/**	ユーザーのメールアドレス*/
	private String email;
	/**	ユーザーのパスワード */
	private String password;
	

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
