/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaigo.exam.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 *
 * @author kai
 */
@Entity
@Table(name = "users")
public class LoginUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // ten đăng nhập
    @Column(name = "login_name", nullable = false, unique = true)
    private String loginName;

    // Email đăng nhập
    @Column(nullable = false, unique = true)
    private String email;

    // Mật khẩu
    @Column(nullable = false)
    private String password;

    // Họ tên
    @Column(name = "full_name")
    private String fullName;

    // Thời gian tạo tài khoản
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Thời gian update tài khoản
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Constructor
    public LoginUser() {
    }

    // STUDENT hoặc ADMIN
    @Column(nullable = false)
    private String role;

    // Tự động điền thời gian khi INSERT
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();

        if (role == null) {
            role = "STUDENT";
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginUser)) {
            return false;
        }
        LoginUser other = (LoginUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kaigo.exam.entity.LoginUser[ id=" + id + " ]";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

}
