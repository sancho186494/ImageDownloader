package com.akh.config;

import javax.naming.NamingException;


import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.akh.dao.*;

@Configuration
@EnableWebMvc
@ComponentScan("com.akh")
public class AppConfig implements WebMvcConfigurer {

	
	@Bean
	public ImageDAO getUserDao() throws NamingException {
	    JndiTemplate jndiTemplate = new JndiTemplate();
	    DataSource dataSource = (DataSource) jndiTemplate.lookup("java:comp/env/jdbc/DB");
	    return new ImageDAOimpl(dataSource);
	}

	@Bean
	public InternalResourceViewResolver resolver() {
		System.out.println("InternalResourceViewResolver ok");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}