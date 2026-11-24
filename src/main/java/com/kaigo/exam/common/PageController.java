/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaigo.exam.common;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author kai
 */
@Controller
public class PageController {
    @GetMapping("/")
    public String home() {
        return "dashboard";
    }

    @GetMapping("/exams")
    public String exams(
            @RequestParam(defaultValue = "2026")
            Integer year,

            @RequestParam(defaultValue = "all")
            String examType,

            @RequestParam(defaultValue = "all")
            String subject,

            Model model) {

        model.addAttribute("year", year);
        model.addAttribute("examType", examType);
        model.addAttribute("subject", subject);

        return "exams";
    }

    @GetMapping("/courses")
    public String courses() {
        return "courses";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
