package kr.or.ddit.servlet.scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/mulcalculation")
public class mulCalculation extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(sumCalculation.class);
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//두가지 : forward, redirect(요청 2번 발생)
		req.getRequestDispatcher("/jsp/mulcal.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int start = Integer.parseInt(req.getParameter("start")); 
		int end = Integer.parseInt(req.getParameter("end")); 
		int result = 0; 
		
		result = start * end ; 
		
		logger.info("결과값 " + result);

		
		HttpSession session = req.getSession();  
		session.setAttribute("mulResult", result );
		
		req.getRequestDispatcher("/jsp/mulResult.jsp").forward(req, resp);
	
	}

}
