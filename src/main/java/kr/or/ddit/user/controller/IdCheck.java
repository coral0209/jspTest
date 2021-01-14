package kr.or.ddit.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/idcheck")
public class IdCheck extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		String id = req.getParameter("id");
		
		UserServiceI service = new UserService(); 
		int checkIdCnt = service.checkId(id); 
		
		
		req.setAttribute("cnt", checkIdCnt);
		
		req.getRequestDispatcher("/user/idcheck.jsp").forward(req, resp);
		
		
	}

}
