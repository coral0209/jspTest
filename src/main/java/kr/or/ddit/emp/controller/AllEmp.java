package kr.or.ddit.emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.emp.service.EmpService;
import kr.or.ddit.emp.service.EmpServiceI;

@WebServlet("/allEmp")
public class AllEmp extends HttpServlet {
	EmpServiceI service = new EmpService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
	
		List<EmpVo> listVo = service.selectAllUser();
		
		req.setAttribute("listVo", listVo);
		
		req.getRequestDispatcher("/emp/allEmp.jsp").forward(req, resp);
	
	
	}

}
