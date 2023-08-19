//package com.xyd.util;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//@Configuration
//@EnableWebSecurity
//public class GlobalConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // 禁用 csrf
//        http.cors().and().csrf().disable();
//        // 放行全部接口
//        http.authorizeRequests().antMatchers("/**").permitAll();
//    }
//}
