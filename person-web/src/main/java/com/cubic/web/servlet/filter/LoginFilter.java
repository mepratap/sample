package com.cubic.web.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);

		if (isValidUser(session) || (req.getRequestURI().contains("login"))) {
			logger.debug("checking for valid user or not");
			chain.doFilter(request, response);
		} else {
			logger.debug("redirect to the login form");
			resp.sendRedirect("loginform");
		}

	}

	private boolean isValidUser(HttpSession session) {
		return (session != null && session.getAttribute("User") != null);
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}