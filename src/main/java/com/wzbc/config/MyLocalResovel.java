package com.wzbc.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@Configuration
public class MyLocalResovel implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");
        String header = httpServletRequest.getHeader("Accept-Language");
        Locale locale = null;

        if(!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale = new Locale(split[0],split[1]);
        }else{
            String[] split = header.split(",");
            String[] split1 = split[0].split("-");
            locale = new Locale(split1[0],split1[1]);
        }return locale;
    }
    @Override
    public void setLocale(HttpServletRequest httpServletRequest,
        @Nullable HttpServletResponse httpServletResponse,
        @Nullable Locale locale) {
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResovel();
    }
}
