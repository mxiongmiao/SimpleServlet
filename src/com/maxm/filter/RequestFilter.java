package com.maxm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class RequestFilter implements Filter {
	private static final Logger log = Logger.getLogger(RequestFilter.class);

	@Override
	public void init(FilterConfig config) throws ServletException {
		log.info(config.getFilterName());
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fchain)
			throws IOException, ServletException {
		log.info("filter ...");
		fchain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		log.info("filter destroy ...");
	}
}
