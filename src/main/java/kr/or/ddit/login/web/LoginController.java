package kr.or.ddit.login.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* web.xml 에 설정하는 servlet , servlet-mapping 을 어노테이션을 통해 설정하는 방법 */

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	//요청 메소드와 관련없이 서블릿이 동작하게 하려면? SERVICE 
	// get 으로 보내든, post 로 보내든 
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		//개발자도구에 가서 Network -> Name 중에 클릭 -> Headers -> Form Data 로 가면 넘어온 parameter 데이터를 볼 수 있다. 
		//사용자가 userid, pass 파라미터를 전송 했다는 가정으로 개발 
		//하나의 파라미터 확인 
		logger.debug("하나의 파라미터 확인");
		logger.debug("req.getParameter(\"userid\") : {}", req.getParameter("userid"));
		logger.debug("req.getParameter(\"pass\") : {}" , req.getParameter("pass"));
		
		
		//복수개의 값을 갖는 파라미터 확인
		logger.debug("복수개의 값을 갖는 파라미터 확인");
		logger.debug("req.getParameterValues(\"userid\") : " ) ;
		
		for(String userid : req.getParameterValues("userid")) {
			logger.debug("복수개의 유저 아이디 : " + userid);
		}
		
		//요청이 담긴 파라미터 이름을 확인
		logger.debug("요청이 담긴 파라미터 이름을 확인");
		logger.debug("req.getParameterNames() : ");
		
		Enumeration<String> enumeration = req.getParameterNames(); 
		
		while(enumeration.hasMoreElements()) {
			logger.debug(enumeration.nextElement()); 
		}
		
		
		//요청이 담긴 파라미터를 관리하는 앱객체 확인
		logger.debug("요청이 담긴 파라미터를 관리하는 맴객체 확인");
		logger.debug("req.getParameterMap() : ");
		Map<String, String[]> map = req.getParameterMap();
		//key, value 를 entrySet 으로 관리를 한다. 
		
		Set<String> keys = map.keySet();
		
		//iterator 그 안에 담겨져 있는 것을 꺼내올 수 있다. list 이든 set이든 
		
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			logger.debug("{}" , map.get(it.next()));
		
		}
		
	}
	

}
