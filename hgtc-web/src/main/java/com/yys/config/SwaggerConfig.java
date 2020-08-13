package com.yys.config;

import com.yys.common.CommonConstants;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
//    /**
//     * 解决跨域问题
//     * @return
//     */
//    @Bean
//    public CorsFilter corsFilter() {
//        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        final CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//        return new CorsFilter(urlBasedCorsConfigurationSource);
//    }

	
	/**
	 * Swagger configuration method
	 * @return
	 */
	@Bean
	public Docket swaggerSettings() {
		String pathMapping="/";

		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("hgtc")
				.useDefaultResponseMessages(false)
				.forCodeGeneration(false)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo())
				.pathMapping(pathMapping)
				.securitySchemes(security())
				.securityContexts(securityContexts())
				;
	}
	private List<ApiKey> security() {
		ArrayList<ApiKey> apiKeys = new ArrayList<>();
		apiKeys.add(new ApiKey("token", CommonConstants.HGTC_ACCESS_TOKEN, "header"));
		return apiKeys;
	}
	private List<SecurityContext> securityContexts() {
		List<SecurityContext> securityContexts=new ArrayList<>();
		securityContexts.add(
				SecurityContext.builder()
						.securityReferences(defaultAuth())
						.forPaths(PathSelectors.regex("^(?!auth).*$"))
						.build());
		return securityContexts;
	}
	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		List<SecurityReference> securityReferences=new ArrayList<>();
		securityReferences.add(new SecurityReference("token", authorizationScopes));
		return securityReferences;
	}

	/**
	 * Swagger UI configuration
	 * @return
	 */
//	@Bean
//	UiConfiguration uiConfig() {
//	    return UiConfigurationBuilder.builder()
//	        .deepLinking(true)
//	        .displayOperationId(false)
//	        .defaultModelsExpandDepth(1)
//	        .defaultModelExpandDepth(1)
//	        .defaultModelRendering(ModelRendering.EXAMPLE)
//	        .displayRequestDuration(false)
//	        .docExpansion(DocExpansion.NONE)
//	        .filter(false)
//	        .maxDisplayedTags(null)
//	        .tagsSorter(TagsSorter.ALPHA)
//	        .operationsSorter(null)
//	        .showExtensions(false)
//	        .validatorUrl(null)
//	        .build();
//	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
                .title("park API")
				.description(initDescription())
				.version("1.0.0")
//				.licenseUrl("http://cn.bing.com")
//				.termsOfServiceUrl("https://www.baidu.com")
				.license("The Apache License, Version 2.0")
				.build();
	}
	
	private String initDescription(){
		StringBuffer sb = new StringBuffer();
		
        sb.append("本页面用来测试PARK接口文档功能")
			.append("<br/>")
			.append("<br/>");
		
		return sb.toString();
	}
	
	/**
	 * 设置全局参数变量
	 * @return
	 */
/*	private List<Parameter> globalOperationParameters() {
	    List<Parameter> pars = new ArrayList<>();
	    ParameterBuilder tokenPar = new ParameterBuilder();
	    tokenPar.name(CommonConstats.PARK_ACCESS_TOKEN).description("普通令牌").modelRef(new ModelRef("string")).parameterType("header").required(false);
	    pars.add(tokenPar.build());
	    
	    return pars;
	}*/
}
