package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet{


	//doXXX 메소드의 인자 : req , res 로 규약 정의되어 있다. 
	//doget , dopost -> httpservlet 에보면 정의가 되있고 재정의 해서 오버라이딩해서 사용. 
	// GET , POST , DELETE , PUSH , HEAD ... : HTTP 메소드 
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//printwriter 객체 생성 
		
		PrintWriter pw = resp.getWriter();
		pw.println("Hello, World");
		
		
		//효율성을 위해서 버퍼에 어느정도 양이 차면 사용 -> 조금만 찼어도 보내도 된다. . 더이상 작성할 내용이 없으므로 작업을 마무리 한다. 
		pw.flush();  
		//사용한 자원 반납 
		pw.close();
		
	
	}


	
	
	
	
}
