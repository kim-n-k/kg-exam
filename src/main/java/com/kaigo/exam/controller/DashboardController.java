/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaigo.exam.controller;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author kai
 */
@Controller
public class DashboardController {
    
    @GetMapping("/dashboard")
    public String dashboard(
            HttpSession session,
            Model model) {

        String loginName =
                (String) session.getAttribute("loginName");

        if (loginName == null) {
            return "redirect:/login";
        }

        model.addAttribute("loginName", loginName);

        return "dashboard";
    }
}
