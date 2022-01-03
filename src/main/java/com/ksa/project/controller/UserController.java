package com.ksa.project.controller;

import javax.servlet.http.HttpSession;

import com.ksa.project.model.User;
import com.ksa.project.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
	HttpSession session;


    @GetMapping("/signin")
	public String signin() {
		return "signin";
	}

	@PostMapping("/signin")
	public String signinPost(@ModelAttribute User user) {
		User dbUser = 
			userRepository.findByEmailAndPassword(
				user.getEmail(), user.getPassword());
			userRepository.findByBirthAndPhone(
				user.getBirth(), user.getPhone());
			userRepository.findByAddressAndName(
				user.getAddress(), user.getName());
			
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
        return "signup";
    }

    @PostMapping("/signup")
    public String signupPost(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/";
    }
};
