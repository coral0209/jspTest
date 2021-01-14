package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/registUser")
public class RegistUser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/user/registUser.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터를 읽기 전에 실행해야 한다.
		// servlet 의 doPost 메소드 마다 실행 필요 ==> Filter 에다가 한번만 등록을 하면 편함
		req.setCharacterEncoding("UTF-8");
		UserService service = new UserService();
		String userid = req.getParameter("userid");

		// 0보다 크면 아이디가 존재하는것
		int checkIdCnt = service.checkId(userid);
		// 중복된 아이가 중복되는 것
		if (checkIdCnt > 0) {
			doGet(req, resp);
		} else {

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

			UserVo uservo = new UserVo(userid, usernm, pass, reg_dt, userAlias, addr1, addr2, zipcode);
			int cnt = 0;
			try {
				cnt = service.insertUser(uservo);
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (cnt == 1) {
				// post 방식으로
				// doGet(req, resp);
				//
				resp.sendRedirect(req.getContextPath() + "/pagingUser");

			} else {
				doGet(req, resp);
			}

		}

	}

}