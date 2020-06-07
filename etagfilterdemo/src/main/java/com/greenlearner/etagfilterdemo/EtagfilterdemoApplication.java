package com.greenlearner.etagfilterdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@SpringBootApplication
public class EtagfilterdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtagfilterdemoApplication.class, args);
	}

	@Bean
	ShallowEtagHeaderFilter shallowEtagHeaderFilter(){
		ShallowEtagHeaderFilter tag = new ShallowEtagHeaderFilter();

		return tag;
	}

	@Bean
	FilterRegistrationBean<ShallowEtagHeaderFilter> filterFilterRegistrationBean(){
		FilterRegistrationBean<ShallowEtagHeaderFilter> bean = new FilterRegistrationBean<>(
				new ShallowEtagHeaderFilter()
		);
		bean.addUrlPatterns("/rest12/*");
		bean.setName("etagFilter");
		return bean;

	}
}
