package kr.or.ddit.servlet.scope;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/sumcalculation")
public class sumCalculation extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(sumCalculation.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int start = Integer.parseInt(req.getParameter("start")); 
		int end = Integer.parseInt(req.getParameter("end")); 
		int result = 0; 
		
		
		for(int i = start ; i <= end ; i++) {
			result += i; 
		}
		
		
		logger.info("결과값 " + result);

		
		HttpSession session = req.getSession();  
		session.setAttribute("sumResult", result );
		
		req.getRequestDispatcher("/jsp/sumResult.jsp").forward(req, resp);		
	
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/jsp/sumcal.jsp").forward(req, resp);
	
	}
}
