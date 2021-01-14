package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class UserServiceTest {

	
	
	
	// service 를 테스트 코드
	
	
	@Test
	public void SelectAllUserTest() {
		/***Given***/
		UserServiceI userService = new UserService(); 

		/***When***/
		List<UserVo> userList = userService.selectAllUser(); 
		
		/***Then***/
		assertEquals(16, userList.size());
		
		
	
	}
	//사용자 아이디를 이용하여 특정 사용자 정보 조회 
	// test 코드를 만들어놓으면 설계가 되는것 
	
	@Test
	public void selectUserTest() {
		/***Given***/
		UserServiceI userService = new UserService(); 
		String userid = "brown"; 
		/***When***/
		UserVo user = userService.selectUser(userid);
		/***Then***/

		assertNotNull(user);
		assertEquals("브라운" , user.getUsernm()); 
		
	
		
		
	}
	
	
	//사용자 페이징 조회 테스트 
	
	@Test
	public void selectPageingUser() {
		/***Given***/
		UserServiceI userService = new UserService(); 
		PageVo vo = new PageVo();  
		vo.setPage(2);
		vo.setPagesize(5);
		
		
		/***When***/
		Map<String, Object> map = userService.selectPagingUser(vo); 
		List<UserVo> userList = (List<UserVo>) map.get("userList");
		int userCnt = (int)map.get("cnt");
		/***Then***/
		assertNotNull(map);
		assertEquals("cony" , userList.get(0).getUserid());
	
		
	}
	
	//사용자 아이디가 존재하지 않을 떄 특정 사용자 
	@Test
	public void selectUser() {
		/***Given***/
		UserServiceI userService = new UserService(); 
		String userid = "sdfsdfd"; 
		/***When***/
		UserVo user = userService.selectUser(userid);
		/***Then***/
		assertNull(user);
		
		
	}
	
	@Test
	public void modifyUserTest() {
		/***Given***/
		UserServiceI userService = new UserService();

		UserVo userVo = new UserVo( "ddit" , "오로라" , "aurora" , new Date() , "사파이어" , "판교동 판교로 판교서" , "아이슬란드 눈밭" , "394-423" ); 

		
		/***When***/

		int cnt = userService.modifyUser(userVo);
		/***Then***/
		assertEquals(1, cnt);

	}
	
	
	
	
}
