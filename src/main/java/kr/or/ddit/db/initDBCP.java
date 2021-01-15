package kr.or.ddit.db;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(value="/initDBCP" , loadOnStartup = 1)
public class initDBCP extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(initDBCP.class);
	
	@Override
	public void init() throws ServletException {
		logger.debug("InitDBCP.init()");
		
		//connectionfull 생성
		//jdbc.jsp 
		//커넥션풀은 웹 어플리케이션당 1개만 만든다. 
		//application scope 에 커넥션 풀 저장 
		//////////////////////////기본 설정
		BasicDataSource bs = new BasicDataSource(); 
		bs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		//객체말고 string 
		bs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bs.setUsername("Aurora");
		bs.setPassword("java");
		bs.setInitialSize(20);
		////////////////////////////
		//bs.getConnection()
		
		
		
		
		//dbcp.jsp 에서는 application scope 에 저장된 컨넥션 풀을 사용하여 컨넥션 객체를 얻어올 것이다. 
		//얻고 해제 하는 과정을 반복 - 시간체크  
		//application은 ServletContext타입이다.
	
		ServletContext sc = getServletContext(); 
		sc.setAttribute("bs", bs);
	}

}
