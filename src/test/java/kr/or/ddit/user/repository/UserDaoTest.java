package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class UserDaoTest {

	//이름은 테스트 원하는 메소드 + test ( 명명규칙 ) 
	//전체 사용자 조회 테스트 
	
	@Test
	public void SelectAllUserTest() {
		/***Given***/
		UserDaoI userDao = new UserDao(); 

		/***When***/
		List<UserVo> userList = userDao.selectAllUser(); 
		
		/***Then***/
		assertEquals(16, userList.size());
		
		
	
	}
	
	
	//사용자 아이디를 이용하여 특정 사용자 정보 조회 
	// test 코드를 만들어놓으면 설계가 되는것 
	
	@Test
	public void selectUserTest() {
		/***Given***/
		UserDaoI userDao = new UserDao(); 
		String userid = "brown"; 
		/***When***/
		UserVo user = userDao.selectUser(userid);
		/***Then***/

		assertNotNull(user);
		assertEquals("브라운" , user.getUsernm()); 
		
	
		
		
	}
	
	
	//사용자 페이징 조회 테스트 
	
	@Test
	public void selectPageingUser() {
		/***Given***/
		UserDaoI userDao = new UserDao();
		PageVo vo = new PageVo();  
		vo.setPage(2);
		vo.setPagesize(5);
		
		
		/***When***/
		List<UserVo> list = userDao.selectPagingUser(vo); 
		
		/***Then***/
		assertNotNull(list);
		assertEquals("cony" , list.get(0).getUserid());
	
		
	}
	
	
	@Test
	public void modifyUserTest() {
		/***Given***/
		UserDaoI userDao = new UserDao();
		//userid, usernm , pass , reg_dt , alias , addr1 , addr2 , zipcode 
		UserVo userVo = new UserVo( "ddit" , "오로라" , "aurora" , new Date() , "사파이어" , "판교동 판교로 판교서" , "아이슬란드 눈밭" , "394-423" ); 

		/***When***/

		int updateCnt = userDao.modifyUser(userVo);
		
		/***Then***/

		assertEquals(1, updateCnt);
		
	}

	
	

	
	
	
}
