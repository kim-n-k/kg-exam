/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaigo.exam.config;
import java.util.Locale;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.context.i18n.LocaleContextHolder;
/**
 *
 * @author kai
 */
@ControllerAdvice
public class GlobalModelConfig {
     @ModelAttribute("currentLanguage")
    public String currentLanguage() {

        Locale locale = LocaleContextHolder.getLocale();

        return locale.getLanguage();
    }
}
