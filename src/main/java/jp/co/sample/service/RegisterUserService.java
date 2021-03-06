package jp.co.sample.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jp.co.sample.domain.User;
import jp.co.sample.form.RegisterUserForm;
import jp.co.sample.repository.UserRepository;

@Service
public class RegisterUserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * パスワードをハッシュ化する.
	 * @param rawPassword
	 * @return
	 */
	public String encodePassword(String password) {
		String encodedPassword = passwordEncoder.encode(password);
		return encodedPassword;
	}
	
	
	/**
	 * ユーザー情報を登録する.
	 * 
	 * @param registerUserForm
	 * @return
	 */
	public User save(RegisterUserForm registerUserForm) {
	
		registerUserForm.setPassword(encodePassword(registerUserForm.getPassword()));
		
		User user = new User();
		BeanUtils.copyProperties(registerUserForm, user);
		user = userRepository.save(user);
		
		return user;
	}
	
	public boolean checkEmail(RegisterUserForm registerUserForm) {
		User user = userRepository.findByName(registerUserForm.getEmail());
		if(user != null) {
			return true;
		}
		return false;
	}
	
}
