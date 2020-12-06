package com.shortrent.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Title:
 * @Description:
 * @Version:1.0.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    //映射地址（访问地址）
    public static final String Path="/upload/";
   
   // private String filePath="./src/main/resources/static/img/rent-img/";
    //注解获取配置文件本地存储的绝对地址
    @Value("${filePath}")
    private String filePath;
    
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //映射图片保存地址
        registry.addResourceHandler(Path+"**").addResourceLocations("file:"+filePath);
    }
}