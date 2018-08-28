package org.shafin.ssapp.core.config;

import org.shafin.ssapp.api.helper.converter.BaseDtoEntityConverter;
import org.shafin.ssapp.api.helper.converter.ProductCodeDtoToEntityConverter;
import org.shafin.ssapp.api.helper.converter.ProductCodeEntityToDtoConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Slf4j
@SpringBootApplication
@EnableAutoConfiguration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@Configuration
@ComponentScan(
        basePackages = {
            "org.shafin.ssapp.api.endpoint",
            "org.shafin.ssapp.common.logging",
            "org.shafin.ssapp.core.dao",
            "org.shafin.ssapp.core.service",
            "org.shafin.ssapp.spring_integration.endpoint"
        }
)
@EntityScan(
        basePackages = {
            "org.shafin.ssapp.core.entity"
        }
)
@ImportResource("classpath*:com/konasl/ssapp/core/config/spring-integration.xml")
public class Application {

    public static final String DTO_ENTITY_CONVERSION_SERVICE = "DtoEntityConversionService";

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        log.debug("*********************************************************");
        log.debug("Let's inspect the beans provided by Spring Boot :: START ");
        log.debug("*********************************************************");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            log.debug(beanName);
        }

        log.debug("*********************************************************");
        log.debug("Let's inspect the beans provided by Spring Boot :: END   ");
        log.debug("*********************************************************");
    }

    @Bean(name = Application.DTO_ENTITY_CONVERSION_SERVICE)
    public ConversionService getDtoEnityConversionService() {
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        Set<BaseDtoEntityConverter> dtoEnityConverters = new HashSet<>();

        dtoEnityConverters.add(new ProductCodeEntityToDtoConverter());
        dtoEnityConverters.add(new ProductCodeDtoToEntityConverter());

        conversionServiceFactoryBean.setConverters(dtoEnityConverters);
        conversionServiceFactoryBean.afterPropertiesSet();
        return conversionServiceFactoryBean.getObject();
    }

    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        List<HttpMessageConverter<?>> listConverters = new ArrayList<>();
        listConverters.add(new MappingJackson2HttpMessageConverter());
        listConverters.add(new MappingJackson2XmlHttpMessageConverter());

        restTemplate.setMessageConverters(listConverters);
        restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

        return restTemplate;
    }

    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
//        config.addAllowedOrigin("http://192.168.56.160:8080");
        config.addAllowedOrigin("http://localhost:8383");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}
