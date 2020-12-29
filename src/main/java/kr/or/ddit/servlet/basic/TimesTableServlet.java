package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimesTableServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("<style>");
		pw.println("table {   border-collapse : collapse; width : 100%;  "
				+ "}"); 
		
		
		pw.println("</style>");
		
		
		pw.println("		<title>Times Tables Servelt</title>");
		pw.println("	</head>");
		pw.println("	<body>");
		
		
		pw.println("<table border = '1'>");
		
		//tr이 9개 반복
		for(int i = 1 ; i <= 9 ; i++) {
			pw.println("<tr>");
			
			for(int k = 1 ; k <= 8 ; k++) {
			
				//td가 8개 반복
		
				pw.println("<td>"); 
				
				pw.println( (k+1) + "*" + i + "=" + (k+1)*i ) ; 
			
				pw.println("</td>"); 
			}
		
	
			pw.println("</tr>");
		
		}
		
		
		pw.println("</table>"); 
		
		
		pw.println("	</body>");
		pw.println("</html>");
		
		
		
		//효율성을 위해서 버퍼에 어느정도 양이 차면 사용 -> 조금만 찼어도 보내도 된다. . 더이상 작성할 내용이 없으므로 작업을 마무리 한다. 
		pw.flush();  
		//사용한 자원 반납 
		pw.close();
		
	
	
	
	}



	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	
	
	
	
}

