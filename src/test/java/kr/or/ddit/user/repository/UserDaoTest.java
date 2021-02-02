package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class UserDaoTest {

	//이름은 테스트 원하는 메소드 + test ( 명명규칙 ) 
	//전체 사용자 조회 테스트 
	private UserDaoI userDao ; 
	
	
	@Test
	public void SelectAllUserTest() {
		/***Given***/
		userDao = new UserDao(); 

		/***When***/
		List<UserVo> userList = userDao.selectAllUser(); 
		
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
		UserVo user = userDao.selectUser(userid);
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
		List<UserVo> list = userDao.selectPagingUser(vo); 
		
		/***Then***/
		assertNotNull(list);
		assertEquals("con" , list.get(0).getUserid());
	
		
	}
	
	
	@Test
	public void modifyUserTest() {
		/***Given***/
		//신규 입력 테스트를 위해 테스트 과정에서 입력된 데이터를 삭제 
		
		//userid, usernm , pass , reg_dt , alias , addr1 , addr2 , zipcode 
		UserVo userVo = new UserVo( "ddit" , "오로라" , "aurora" , new Date() , "사파이어" , "판교동 판교로 판교서" , "아이슬란드 눈밭" , "394-423" , "" , "" ); 

		/***When***/

		int updateCnt = userDao.insertUser(userVo);
		
		/***Then***/

		assertEquals(1, updateCnt);
		
	}

	//삭제 테스트
	@Test
	public void deleteUserTest() { 
	/***Given***/
	//해당 테스트가 실행될 때는 testUser 라는 사용자가 before 메소드에 의해 등록이 된 상태 
	String userid = "testUser"; 
	
	/***When***/
	int deleteCnt = userDao.deleteUser(userid); 
	
	
	/***Then***/
	assertEquals(1, deleteCnt);
	}
	
	// 모든 테스트 코드 실행 전에 테스트에 참여할 수 있는 임의의 사용자를 입력 
//	
//	@BeforeClass -> static 으로 사용해야함
//	
//	@Before
//	
//	@AfterClass -> static 으로 사용해야함
//	

	// 모든 테스트 코드 실행 전에 테스트에 참여할 수 있는 임의의 사용자를 입력  
	@Before
	public void setUp() {
		userDao = new UserDao(); 
		userDao.deleteUser("ddit"); 
		UserVo userVo = new UserVo("testUser" , "테스트 사용자" , "testUserPass" , new Date(), "대덕" , "대전 중구 중앙로 76"  , "4층" , "2323" , "" , ""); 
		
		userDao.insertUser(userVo); 

	}
	
	
	@After
	public void tearDown () {
		userDao.deleteUser("testUser"); 		
	}
	
	
//	@Before
//	 	1. testUser 삭제
//	 	2. testUser 등록
//	 
//	 @Test 
//	 	테스트 실행
	
		
	
	
}
