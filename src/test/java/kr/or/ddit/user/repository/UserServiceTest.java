package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class UserServiceTest {

	UserServiceI userService;
	
	@Before
	public void setup() {
		userService = new UserService();
		UserVo userVo = new UserVo("testUser" , "테스트 사용자" , "testUserPass" , new Date(), "대덕" , "대전 중구 중앙로 76"  , "4층" , "2323" , "" , ""); 
		userService.insertUser(userVo); 
		userService.deleteUser("ddit"); 
	}
	
	// service 를 테스트 코드
	
	
	@Test
	public void SelectAllUserTest() {
		/***Given***/

		/***When***/
		List<UserVo> userList = userService.selectAllUser(); 
		
		/***Then***/
		assertEquals(21, userList.size());
		
		
	
	}
	//사용자 아이디를 이용하여 특정 사용자 정보 조회 
	// test 코드를 만들어놓으면 설계가 되는것 
	
	@Test
	public void selectUserTest() {
		/***Given***/
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
		PageVo vo = new PageVo();  
		vo.setPage(2);
		vo.setPagesize(5);
		
		
		/***When***/
		Map<String, Object> map = userService.selectPagingUser(vo); 
		List<UserVo> userList = (List<UserVo>) map.get("userList");
		int userCnt = (int)map.get("cnt");
		/***Then***/
		assertNotNull(map);
		assertEquals( 5 , userList.size());
	
		
	}
	
	//사용자 아이디가 존재하지 않을 떄 특정 사용자 
	@Test
	public void selectUser() {
		/***Given***/
		String userid = "sdfsdfd"; 
		/***When***/
		UserVo user = userService.selectUser(userid);
		/***Then***/
		assertNull(user);
		
		
	}
	
	@Test
	public void modifyUserTest() {
		/***Given***/

		UserVo userVo = new UserVo( "ddit" , "오로라" , "aurora" , new Date() , "사파이어" , "판교동 판교로 판교서" , "아이슬란드 눈밭" , "394-423" , "" , "" ); 

		
		/***When***/

		int cnt = userService.modifyUser(userVo);
		/***Then***/
		assertEquals(1, cnt);

	}
	
	@Test
	public void deleteUserTest() {
		/***Given***/

		String userId = "testUser"; 
		
		/***When***/

		int cnt = userService.deleteUser(userId);
		/***Then***/
		assertEquals(1, cnt);

	}
	

	
	@After 
	public void tearDown(){
		userService.deleteUser("testUser"); 
	}
	
	
	
}
