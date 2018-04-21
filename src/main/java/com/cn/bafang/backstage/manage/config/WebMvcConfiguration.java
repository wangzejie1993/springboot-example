package com.cn.bafang.backstage.manage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport{

    /**

     * 1、 extends WebMvcConfigurationSupport

     * 2、重写下面方法;

     * setUseSuffixPatternMatch : 设置是否是后缀模式匹配，如“/user”是否匹配/user.*，默认真即匹配；

     * setUseTrailingSlashMatch : 设置是否自动后缀路径模式匹配，如“/user”是否匹配“/user/”，默认真即匹配；

     */

    @Override

    public void configurePathMatch(PathMatchConfigurer configurer) {

        configurer.setUseSuffixPatternMatch(false)

                .setUseTrailingSlashMatch(true);

    }

    /**

     * addPathPatterns 添加需要拦截的url

     * excludePathPatterns 不需要拦截的url

     * @param registry

     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截规则：除了login，其他都拦截判断

        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")

                .excludePathPatterns("/admin/login")

                .excludePathPatterns("/sign")

                .excludePathPatterns("/demo")

                .excludePathPatterns("/swagger");

        super.addInterceptors(registry);

    }

//    @Override
//    protected void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/tologin").setViewName("/admin/login");
//        registry.addViewController("/index").setViewName("/index");
//        registry.addViewController("/errorpage").setViewName("/error");
//
//        super.addViewControllers(registry);
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        //super.addResourceHandlers(registry);
    }


}
