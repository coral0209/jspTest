package kr.or.ddit.filter;

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

import kr.or.ddit.user.model.UserVo;

public class SessionCheckFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request; 
		String uri = req.getRequestURI();
		//세션 체크가 필요 없는 주소 : login.jsp, loginController 
		
/*		if(uri.endsWith("login.jsp") || uri.endsWith("LoginController")
				|| uri.endsWith("css") || uri.endsWith("js") || uri.endsWith("png")
				|| uri.endsWith("jps")  {
			chain.doFilter(request, response);
		}*/
		
		if(uri.endsWith("login.jsp") || uri.endsWith("LoginController")  
			||uri.contains("/css/") || uri.contains("/js/") || uri.contains("/image/")) {
			chain.doFilter(request, response);
		}
		
		
		
		//세선 체크가 필요 있는 주소 (S_USER속성 확인) 
		else {
			UserVo user = (UserVo)req.getSession().getAttribute("S_USER"); 
			//user 정보가 null ==> 로그인을 안함 => 로그인 화면으로 이동
			if(user == null) {
				((HttpServletResponse)response).sendRedirect(req.getContextPath() + "/jsp/login.jsp");
			}else {
				chain.doFilter(request, response);
			}
			// user 정보가 !null => 로그인한 상태 ==> 요청 처리  
		}	
		
		
	/*	//session 에 S_USER 속성이 있는 지 확인
		HttpSession session = ((HttpServletRequest)request).getSession(); 방향이 변경됨 */
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
