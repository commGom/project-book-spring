package com.ksa.project.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.ksa.project.model.User;
import com.ksa.project.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
	HttpSession session;

	// 아이디 체크
	@PostMapping("/emailCheck")
	@ResponseBody
	public User emailCheck(@RequestParam("email") String email, User user){
		log.info("userEmailCheck 진입");
		log.info("전달받은 email:"+email);
		User dbUser = 
				userRepository.findByEmail(user.getEmail());
		log.info("확인 결과:"+dbUser);
		return dbUser;
	}

    @GetMapping("/signin")
	public String signin() {
		return "user/signin";
	}

	@PostMapping("/signin")
	public String signinPost(@ModelAttribute User user) {
		User dbUser = 
			userRepository.findByEmailAndPassword(
				user.getEmail(), user.getPassword());
			
		if(dbUser != null) {
			session.setAttribute("user_info", dbUser);
		}
		return "redirect:/";
	}

	@GetMapping("/signout")
	public String signout() {
		session.invalidate();
		return "redirect:/";
	}

    @GetMapping("/signup")
    public String signup() {
        return "user/signup";
    }

    @PostMapping("/signup")
	@ResponseBody
    public Map<String, Object> signupPost (@ModelAttribute User user) {
		System.out.println(user);
		Map<String, Object> result = new HashMap<>();
		User dbUser = 
				userRepository.findByEmail(user.getEmail());
		log.info("확인 결과:"+dbUser);
		if (dbUser != null) {
			System.out.println("회원가입 실패");
			result.put("msg", "회원가입 실패");
			result.put("code", 201);
		} else {
			userRepository.save(user);
			System.out.println("회원가입 성공");
			result.put("msg", "회원가입 성공");
			result.put("code", 200);
		}
		return result;

    }
};
