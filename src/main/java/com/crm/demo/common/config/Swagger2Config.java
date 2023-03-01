package com.crm.demo.common.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket adminApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("clientApi")
                .apiInfo(adminInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.crm.demo.controller"))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .paths(Predicates.and(PathSelectors.regex("/.*")))
                .build();

    }

    private ApiInfo adminInfo() {
        return new ApiInfoBuilder()
                .title("客户关系管理系统-API文档")
                .description("本文档描述了客户关系管理管理系统接口")
                .version("1.0")
                .contact(new Contact("Qioes", "www.baidu.com", "2902594577@qq.com"))
                .build();
    }
}
