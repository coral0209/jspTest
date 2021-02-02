package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;
import kr.or.ddit.util.FileUtil;
@MultipartConfig
@WebServlet("/userModify")
public class UserModify extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		UserServiceI service = new UserService();
		String userid = req.getParameter("userid");
		
		UserVo userVo = service.selectUser(userid);
		req.setAttribute("userVo", userVo);
		
		req.getRequestDispatcher("/user/userModify.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터를 읽기 전에 실행해야 한다. 
		//servlet 의 doPost 메소드 마다 실행 필요 ==> Filter 에다가 한번만 등록을 하면 편함 
		
		req.setCharacterEncoding("UTF-8");
		String userid = req.getParameter("userid");
		String usernm = req.getParameter("userNm");
		String pass = req.getParameter("pass"); 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date reg_dt = null; 
		
		try {
			reg_dt = sdf.parse(req.getParameter("reg_dt"));
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		String userAlias = req.getParameter("userAlias");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String zipcode = req.getParameter("zipcode");
		
		Part profile = req.getPart("profile");
		String filename = "";
		String realfilename = "";
		
		if(profile != null && profile.getSize() > 0 ) {
			filename = FileUtil.getFileName(profile.getHeader("Content-Disposition"));
			String fileExtension = FileUtil.getFileExtension(filename);
			realfilename = UUID.randomUUID().toString() + fileExtension;
			
			/* profile.write("d:\\upload\\" + realfilename); */
			
		}else {
	
			filename = req.getParameter("filename");
			realfilename = req.getParameter("realfilename");
			
		}
	
		
		UserVo usevo = new UserVo(userid , usernm , pass , reg_dt , userAlias , addr1, addr2,
				zipcode , filename , realfilename);
		UserService service = new UserService(); 
		 int cnt  = service.modifyUser(usevo); 
		if (cnt == 1) {
			//post 방식으로 
			//doGet(req, resp);
			//
			resp.sendRedirect(req.getContextPath() +"/usercontroller?userid=" +userid);
			
		}else {
		doGet(req, resp);
		}
		
	}
}
