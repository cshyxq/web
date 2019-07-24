package com.example.demo.config;

import com.example.demo.language.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {
   WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {

       @Bean
       public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
       }
   };
   @Bean
   public LocaleResolver localeResolver(){
       return new MyLocalResolver();
   }

}
