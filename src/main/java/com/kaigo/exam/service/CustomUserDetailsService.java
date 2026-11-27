/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaigo.exam.service;
import com.kaigo.exam.entity.LoginUser;
import com.kaigo.exam.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 *
 * @author kai
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUser user = userRepository.findByEmail(username)
                .or(() -> userRepository.findByLoginName(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        String role = (user.getRole() == null || user.getRole().isBlank()) ? "STUDENT" : user.getRole().trim();
        String grantedRole = role.startsWith("ROLE_") ? role : "ROLE_" + role;

        return User.builder()
                .username(user.getLoginName() != null && !user.getLoginName().isBlank()
                        ? user.getLoginName()
                        : user.getEmail())
                .password(user.getPassword()) // Mật khẩu đã được băm bởi PasswordEncoder khi đăng ký
                .authorities(List.of(new SimpleGrantedAuthority(grantedRole)))
                .build();
    }
}
