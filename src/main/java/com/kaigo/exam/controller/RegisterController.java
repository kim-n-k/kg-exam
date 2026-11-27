/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaigo.exam.controller;

import com.kaigo.exam.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author kai
 */
@Controller
public class RegisterController {
    
    private final UserService userService;
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    // Hiển thị trang đăng ký
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    // Nhận dữ liệu đăng ký
    @PostMapping("/register")
    public String register(
            @RequestParam("loginName") String loginName,
            @RequestParam("email")  String email, 
            @RequestParam("password")  String password,
            Model model) {

        try {
            userService.register(loginName, email,password);
            return "redirect:/login?registered";

        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
    
}
