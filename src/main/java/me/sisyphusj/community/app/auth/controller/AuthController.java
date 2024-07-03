package me.sisyphusj.community.app.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.sisyphusj.community.app.auth.domain.SignupReqDTO;
import me.sisyphusj.community.app.auth.service.AuthService;
import me.sisyphusj.community.app.utils.SessionUtil;

@Slf4j
@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	/**
	 * 회원가입 페이지 연결
	 */
	@GetMapping("/signup")
	public String showSignupPage() {
		return "signup";
	}

	/**
	 * 회원가입
	 */
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute SignupReqDTO signupReqDTO) {
		authService.signup(signupReqDTO);
		return "redirect:/";
	}

	/**
	 * 로그인 페이지 연결
	 */
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}

	/**
	 * 세션 인증이 작동하는지 확인하는 페이지
	 */
	@GetMapping("/my-page")
	public String showMyPage(Model model, HttpServletRequest request) {
		model.addAttribute("user", SessionUtil.getLoginUserId(request.getSession(false)));
		return "myPage";
	}

}