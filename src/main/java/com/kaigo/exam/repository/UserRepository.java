/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaigo.exam.repository;


import com.kaigo.exam.entity.LoginUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author kai
 */
public interface UserRepository extends JpaRepository<LoginUser, Long> {
      // Tìm user theo email
    Optional<LoginUser> findByEmail(String email);

    // Kiểm tra email đã tồn tại chưa
    boolean existsByEmail(String email);
    
    // Tìm tài khoản bằng Login Name
    Optional<LoginUser> findByLoginName(String loginName);
}
