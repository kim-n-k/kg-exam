/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaigo.exam.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 *
 * @author kai
 */
@Configuration
public class LocaleConfig implements WebMvcConfigurer {

    // Lưu ngôn ngữ đang sử dụng trong Session
    @Bean
    public LocaleResolver localeResolver() {

        SessionLocaleResolver resolver
                = new SessionLocaleResolver();

        // Ngôn ngữ mặc định
        resolver.setDefaultLocale(Locale.JAPANESE);

        return resolver;
    }

    // Nhận yêu cầu thay đổi ngôn ngữ
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {

        LocaleChangeInterceptor interceptor
                = new LocaleChangeInterceptor();

        // Đọc tham số lang trên URL
        interceptor.setParamName("lang");

        return interceptor;
    }

    // Đăng ký Interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(localeChangeInterceptor());
    }
}
