package postoffice.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import postoffice.demo.interceptor.AuthorizationInterceptor;

import java.io.File;

@Configuration
@Slf4j(topic = "WebSecurityConfig")
public class WebSecurityConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("进入权限拦截器进行拦截！");
//        registry.addInterceptor(new testInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new AuthorizationInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new NewInterceptor()).addPathPatterns("/**");

//       registry.addInterceptor(new SqlInjectInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public HttpPutFormContentFilter httpPutFormContentFilter() {
        return new HttpPutFormContentFilter();
    }


}
