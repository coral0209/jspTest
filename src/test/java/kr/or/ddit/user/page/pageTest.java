package kr.or.ddit.user.page;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import kr.or.ddit.user.repository.UserDao;

public class pageTest {
	
	@Test
	public void paginationTest() {
		/***Given***/
		int userTotCnt = 16; 
		int pageSize = 5; 
		int pagination = 0; 
		
		/***When***/
		if(pageSize != 0 ) {
		pagination = (int)Math.ceil((double)userTotCnt/pageSize);

		}else {
		pagination = 1; 
		}
		/***Then***/
		assertEquals(4, pagination);
		
		
	}
	
	@Test
	public void selectAllUserCountTest() {
		/***Given***/
		UserDao dao = new UserDao(); 
		
		/***When***/
		int userCount = dao.selectAllUserCount();
		
		/***Then***/
		assertEquals(16, userCount);

		
	}

}
