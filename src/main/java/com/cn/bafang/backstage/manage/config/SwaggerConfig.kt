package com.cn.bafang.backstage.manage.config

import com.google.common.base.Predicates
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import springfox.documentation.builders.PathSelectors.ant

@Configuration
@EnableSwagger2
open class SwaggerConfig{
    @Bean
    open fun createRestApi(): Docket {
    return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors
            .basePackage("com.cn.bafang.backstage.manage.controller"))
            .paths(Predicates.and(ant("/**"), Predicates.not(ant("/error")))).build();
    }

    private fun apiInfo(): ApiInfo {

        return ApiInfoBuilder()
                .title("RESTful APIs")
                .contact( Contact("", "", "")).version("1.2").build();

    }

}