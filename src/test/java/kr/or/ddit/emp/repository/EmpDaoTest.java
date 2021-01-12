package kr.or.ddit.emp.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;

public class EmpDaoTest {
	
	
	@Test
	public void selectAllUserTest() {
		/***Given***/
		EmpDaoI dao = new EmpDao();
		/***When***/
		List<EmpVo> listVo = dao.selectAllUser();
		/***Then***/
		assertEquals(19, listVo.size());
	}
	@Test
	public void selectUser() {
		/***Given***/
		EmpDaoI dao = new EmpDao();
		/***When***/
		EmpVo vo = dao.selectUser(7369);
		/***Then***/
		assertEquals("SMITH", vo.getEname());
	}
	@Test
	public void selectPagingEmp() {
		/***Given***/
		PageVo vo = new PageVo();
		EmpDaoI dao = new EmpDao();
		/***When***/
		vo.setPage(2); 
		vo.setPagesize(4);
		List<EmpVo> listDao = dao.selectPagingEmp(vo);
		/***Then***/
		assertEquals(4, listDao.size());
	}
}
