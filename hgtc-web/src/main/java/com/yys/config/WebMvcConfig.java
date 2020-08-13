package com.yys.config;

import com.yys.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*******************************

 * * 创建日期: 2020/2/12 13:58
 * * 创建作者: Kevin
 * * 版本:  1.0
 * * 功能:
 * * 最后修改时间:
 * * 修改记录:
 ********************************/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }
    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 以下接口无须进行登录验证
         * */
        // 前台页面url模式, 需要给哪些url添加拦截器
       registry.addInterceptor(loginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(
                        "/swagger-resources/**"
                        ,"/swagger-ui.html"
                        ,"/webjars/**"
                        ,"/**.html"
                        ,"/css/**"
                        ,"/js/**"
                        ,"/plugins/**"
                        ,"/member/register"
                        ,"/member/login"
                );
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/favicon.ico")//favicon.ico
                .addResourceLocations("classpath:/static/");
    }
    //    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        ObjectMapper objectMapper = converter.getObjectMapper();
//
//        // 生成JSON时,将所有Long转换成String
////        SimpleModule simpleModule = new SimpleModule();
////        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
////        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
////        objectMapper.registerModule(simpleModule);
//        // 时间格式化
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        objectMapper.setDateFormat(new SimpleDateFormat(TimeUtils.ymdhms));
//        // 设置格式化内容
//        converter.setObjectMapper(objectMapper);
//        converters.add(0, converter);
//    }

}
