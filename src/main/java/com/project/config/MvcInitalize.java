package com.project.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MvcInitalize implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
			
		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(MvcConfig.class);
		context.setServletContext(servletContext);
		
		// Create and register the DispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet(context);
		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
	}
}