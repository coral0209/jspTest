package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet{


	//doXXX 메소드의 인자 : req , res 로 규약 정의되어 있다. 
	//doget , dopost -> httpservlet 에보면 정의가 되있고 재정의 해서 오버라이딩해서 사용. 
	// GET , POST , DELETE , PUSH , HEAD ... : HTTP 메소드 
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html ; charset=utf-8"); //test
		//printwriter 객체 생성 
		//재정의
		//요청을 생성할 때마다 서버의 현재시간이 달라진다.
		// new Date 부분을 db 에서 조회한 데이터라고 생각해보면
		//사용자 별로 요청에 대한 응다을 각각 다르게 생성하는 것이 가능하다.
		//db 에 대한 연동 부분은 html, javascript 만 이용해서는 불가능 ==> 정적
		// servlet 을 통해 응답으로 생성하는 html 을 동적으로 변경 => 동적 ( servlet/jsp 를 배우는 이유) 
		
		
		//servlet 의 라이프 사이클
		// init() ==> service() ==> destroy()
		// init 은 로딩시 최초 1회 , service 메서드는 사용자가 요청을 할 때마다 , destroy() 는 서버 종료 or reload 
		
		//init 메서드는 해당 서블릿에서 사용하는 자원을 초기화 할 때 사용 
		// 로딩시 최초 1회 호출 : 로딩 되는 시점 ==> 해당 서블릿으로 최초 요청이 들어왔을 때 
		// 단 web.xml 의 servlet 엘레메트의 하위 엘레멘트이 load-on-startup 엘레멘트 값으로 양의 정수값을 입력할 경우 서버가 가동하면서 바로 init 메소드 호출
		
		//servlet container 가 요청을 처리하는 방법
		//등록된 url 매핑을 참고하여 등록된 서블릿으로 요청을 전달(service 메소드 호출) 
		// localhost/basicServlet ==> BasicSrervlet의 service 메소드를 통해 응답생성
		//localhost/index.jsp ==> servlet 설정에 있는 web.xml 에 등록된 
		//				*.jsp , *.jspx url-pattern 에 따라 jsp 라는 이름의 서블릿에서 처리 ( JspServlet) 
		//localhost/doc/20201223.txt 정적인 자료 ==>   
		
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<title>basic Servelt</title>");
		pw.println("	</head>");
		pw.println("	<body> Hello World" + new Date());
		pw.println("	</body>");
		pw.println("</html>");
		pw.println("Hello, World");
		
		
		//효율성을 위해서 버퍼에 어느정도 양이 차면 사용 -> 조금만 찼어도 보내도 된다. . 더이상 작성할 내용이 없으므로 작업을 마무리 한다. 
		pw.flush();  
		//사용한 자원 반납 
		pw.close();
		
	
	}




	
	
	
	
}
