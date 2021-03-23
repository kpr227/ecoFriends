package com.goott.eco.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class, SecurityConfig.class};
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter cef = new CharacterEncodingFilter();
		cef.setEncoding("UTF-8");
		cef.setForceEncoding(true);
		
		return new Filter[] { cef };
	}
	
	
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setInitParameter("thorwExceptionIfNoHandlerFound", "true");
		
//		String prjPath = "C:\\Users\\sdwsg\\Documents\\GitHub\\eco";
//		MultipartConfigElement multipartConfig = new MultipartConfigElement(prjPath, 20971520, 41943040, 20971520);
		MultipartConfigElement multipartConfig = new MultipartConfigElement("C:\\upload\\img", 20971520, 41943040, 20971520);
		registration.setMultipartConfig(multipartConfig);
	}
}
