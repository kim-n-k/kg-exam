/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaigo.exam.service;

import com.kaigo.exam.entity.LoginUser;
import com.kaigo.exam.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 *
 * @author kai
 */
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor Injection
    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Đăng ký tài khoản
    @Transactional
    public LoginUser register(
            String loginName,
            String email,
            String password) {

        // Kiểm tra email đã tồn tại
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException(
                "Email đã được đăng ký!"
            );
        }

        // Tạo đối tượng User
        LoginUser user = new LoginUser();

        user.setLoginName(loginName);
        user.setEmail(email);

        // Không lưu mật khẩu dạng chữ thường
        user.setPassword(
            passwordEncoder.encode(password)
        );

        user.setRole("STUDENT");

        // Lưu vào PostgreSQL
        return userRepository.save(user);
    }

    // Lấy danh sách tất cả user
    public java.util.List<LoginUser> getAllUsers() {
        return userRepository.findAll();
    }
    
}
