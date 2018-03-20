/**
 * WebConfiguration.java
 * 2017年9月14日
 */
package com.mht.service.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author CY
 * @date 2017年9月14日
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    /**
     * @Author: Mu Haitao
     * @Description: 设置页面请求路径映射
     * @Date: 下午 10:55 2018/3/19
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/login");
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/register").setViewName("/register");
    }

    /**
     * @Author: Mu Haitao
     * @Description: 设置跨域请求
     * @Date: 下午 10:54 2018/3/19
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*");
    }
}
