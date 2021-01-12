package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;

@WebServlet("/pagingUser")
public class PagingUser extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(PagingUser.class);

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		//request 객체에서 제공하는 파라미터 변수 : 
		//getParameter , getParameterValues , getParameterMap() , getParameterNames()
		//doGet 메소드에서 page, pageSize 파라미터가 request 객체에 존재하지 않을 떄 
		//page 는 1로 pageSize 는 5로 생각을 코드를 작성
		//파라미터가 존재하면 해당 파라미터 이용
		
		
		
		
		req.setCharacterEncoding("utf-8");
		
		
		// 3항 연산자를 통한 page 와 pagesize 파타미터에 대한 조건 
//		String pageParam = req.getParameter("page");
//		int page = pageParam == null ? 1 : Integer.parseInt(pageParam) ; 
//		String pageSizeParam = req.getParameter("pagesize");
//		int pageSize = pageSizeParam == null ?  5 : Integer.parseInt(pageSizeParam) ; 
		
		

		
		
		//if 연산자를 통한 page 와 pagesize 파타미터에 대한 조건
		int pageSize = 0;
		int page = 0; 
		if(req.getParameter("page") != null ) {
			page = Integer.parseInt(req.getParameter("page"));
		}else {
			page = 1;
		}
		if (req.getParameter("pagesize") != null) {
			pageSize = Integer.parseInt(req.getParameter("pagesize")) ;
		}else {
			
			pageSize = 5;   
		}
		
		UserService service = new UserService(); 
		
		PageVo vo = new PageVo(page, pageSize); 
		Map<String, Object> map = service.selectPagingUser(vo);
		
	
		//페이징 처리된 페이지의 회원들만 조회 
		List<UserVo> userList = (List<UserVo>) map.get("userList");
		//총 회원 수 
		int pagnation = (int) map.get("cnt"); 
		
		
		  
		req.setAttribute("list", userList);
		//총 회원 수 
		req.setAttribute("pagnation", pagnation);
		req.getRequestDispatcher("/user/allUser.jsp").forward(req, resp);
		
	}

}
