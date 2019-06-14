package com.example.i18n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {


    @Bean("localeResolver")
    public LocaleResolver getSessionLocalResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        //  设置默认 locale
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }

    public LocaleChangeInterceptor getLocalChangeInterceptor() {
        return new LocaleChangeInterceptor();

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLocalChangeInterceptor());
    }
}
