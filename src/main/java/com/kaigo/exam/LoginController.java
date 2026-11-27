/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaigo.exam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.kaigo.exam.entity.LoginUser;
import com.kaigo.exam.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author kai
 */

@Controller
public class LoginController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    // Constructor Injection

    public LoginController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

//    // Xử lý đăng nhập
//    @PostMapping("/login")
//    public String login(
//            @RequestParam String loginName,
//            @RequestParam String password,
//            jakarta.servlet.http.HttpServletRequest request,
//            Model model) {
//
//        LoginUser user = userRepository
//                .findByLoginName(loginName)
//                .orElse(null);
//
//        if (user == null
//                || !passwordEncoder.matches(password, user.getPassword())) {
//
//            model.addAttribute(
//                    "error",
//                    "Login name or password is incorrect."
//            );
//
//            return "login";
//        }
//
//        // Chống Session Fixation
//        request.changeSessionId();
//
//        HttpSession session = request.getSession();
//
//        session.setAttribute("userId", user.getId());
//        session.setAttribute("loginName", user.getLoginName());
//        session.setAttribute("role", user.getRole());
//
//        return "redirect:/dashboard";
//    }
// Đăng xuất
//
//    @GetMapping("/logout")
//    public String logout(HttpSession session) {
//
//        session.invalidate();
//
//        return "redirect:/login";
//    }
}
