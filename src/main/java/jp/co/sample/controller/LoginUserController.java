package jp.co.sample.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.sample.domain.LoginUser;
import jp.co.sample.domain.User;

/**
 * ユーザー情報をもとにログイン処理をするコントローラ.
 * 
 * @author yuta.ikeda
 *
 */
@Controller
@RequestMapping("/")
@SessionAttributes(types = {User.class})
public class LoginUserController {

	
	/**
	 * ログイン画面を表示する.
	 * @param model
	 * @param error
	 * @param loginUser
	 * @return ログイン画面
	 */
	@RequestMapping("/")
	public String login(Model model ,
						@RequestParam(required = false) String error,
						@AuthenticationPrincipal LoginUser loginUser) {
		
		if(error != null) {
			model.addAttribute("loginError", "メールアドレスまたはパスワードが違います");
		}
		
		return "login";
	}
	
	
}
