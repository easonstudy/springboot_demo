package com.gmh.framework.config;

import com.gmh.framework.interceptor.CorsInterceptor;
import com.gmh.framework.interceptor.PermissionInterceptor;
import com.gmh.framework.interceptor.SessionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by sun on 2017-3-21.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 此方法把该拦截器实例化成一个bean,否则在拦截器里无法注入其它bean
     * @return
     */
    @Bean
    SessionInterceptor sessionInterceptor() {
        return new SessionInterceptor();
    }

    @Bean
    CorsInterceptor corsInterceptor(){ return new CorsInterceptor(); }

    @Bean
    PermissionInterceptor permissionInterceptor(){ return new PermissionInterceptor(); }

    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/error","/vcode/gif");

        //registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");

        registry.addInterceptor(permissionInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/error","/vcode/gif","/index");
        //super.addInterceptors(registry);
    }

}
