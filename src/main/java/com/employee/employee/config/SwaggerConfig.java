package com.employee.employee.config;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2   
public class SwaggerConfig {


    /**
     * Returns the Docket builder
     *
     * @param servletContext
     * @return Docket builder entity
     */
    @Bean
    public Docket api(ServletContext servletContext) {
        return new Docket(DocumentationType.SWAGGER_2).select()
                        .apis(RequestHandlerSelectors.basePackage(
                                        "com.employee.employee"))
                        .build()
                        .apiInfo(apiEndPointsInfo());
    }

    /**
     * Returns the API endpoint info.
     *
     * @return the api info
     */
    private ApiInfo apiEndPointsInfo() {

        return new ApiInfoBuilder()
                        .title("Employee Management API")
                        .description("Employee Management API")
                        .license("Apache 2.0")
                        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                        .version("1.0.0").build();
    }


   }
