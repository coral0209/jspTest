package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestContentTypeFilter implements Filter{
	
	//로거로 찍어주기 
	private static final Logger logger = LoggerFactory.getLogger(RequestCounterFilter.class);
	String encoding = "utf-8" ; 
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		logger.debug("init()");
		ServletContext sc = filterConfig.getServletContext();
		sc.setAttribute("encoding", encoding);
		
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.debug("contentTypeFilter 필터 확인");
		request.setCharacterEncoding(encoding);
		
		
		//다음 chain 으로 넘어감 
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		this.encoding = null; 
	}
	

}
