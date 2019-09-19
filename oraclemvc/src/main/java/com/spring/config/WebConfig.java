package com.spring.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfig implements WebApplicationInitializer {
	

	@Override
	public void onStartup(ServletContext servlet) throws ServletException {
		AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
		context.setConfigLocation("com.spring.config");
		
		/*
		context.register(RootConfig.class);
		
		<context-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/spring/root-context.xml</param-value>
		</context-param>
		*/
		
		
		/*
		ContextLoaderListener listner=new ContextLoaderListener(context);
		servlet.addListener(listner);
		<listener>
			<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
		</listener>
		*/
		
		ServletRegistration.Dynamic dispatcher=servlet.addServlet("DispatcherServlet", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		/*
		AnnotationConfigWebApplicationContext appServlet=new AnnotationConfigWebApplicationContext();
		appServlet.register(ServletConfig.class);
		
		<servlet>
			<servlet-name>appServlet</servlet-name>
			<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
			<init-param>
				<param-name>contextConfigLocation</param-name>
				<param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
			</init-param>
			<load-on-startup>1</load-on-startup>
		</servlet>
		<servlet-mapping>
			<servlet-name>appServlet</servlet-name>
			<url-pattern>/</url-pattern>
		</servlet-mapping>
		*/
		
		FilterRegistration.Dynamic encoding=servlet.addFilter("characterEncodingFilter", new CharacterEncodingFilter());
		encoding.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
		encoding.setInitParameter("encoding", "UTF-8");
		encoding.setInitParameter("forEncoding", "true");
		
		/*
		<filter>
			<filter-name>encodingFilter</filter-name>
			<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
			<init-param>
				<param-name>encoding</param-name>
				<param-value>utf-8</param-value>
			</init-param>
		</filter>
		<filter-mapping>
			<filter-name>encodingFilter</filter-name>
			<url-pattern>/*</url-pattern>
		</filter-mapping>
		*/
	}

}
