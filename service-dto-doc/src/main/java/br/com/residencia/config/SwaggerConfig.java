package br.com.residencia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.residencia.model.Perfil;
import br.com.residencia.model.Usuario;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("br.com.residencia.controller")).paths(PathSelectors.any()).build().ignoredParameterTypes(Usuario.class, Perfil.class).apiInfo(apiInfo());
    }

    public ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder().title("API DO RESIDÊNCIA EM SOFTWARE").description("Essa api foi desenvolvida pelos alunos do serratec").license("Apache License 2.0").licenseUrl("http://www.apache.org/license").termsOfServiceUrl("/service.html").version("1.0.1").contact(new Contact("Serratec", "www.serratec.org.br", "serratec@serratec.org.br")).build();
        
        return apiInfo;
    }
}
