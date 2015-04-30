package com.chaley.football.draft.filter;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter implements javax.servlet.Filter {
	
	private EntityManagerFactory emf;

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		InitialContext ctx;
	    try {
	      ctx = new InitialContext();
	      emf = (EntityManagerFactory) ctx.lookup("java:local_ds");
	    } catch (NamingException e) {
	      // Add some logging
	      e.printStackTrace();
	    }
	    if (emf != null) {
	      config.getServletContext().setAttribute(EntityManagerFactory.class.getName(), emf);
	    }
		
	}

}
