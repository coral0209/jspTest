package kr.or.ddit.emp.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.emp.service.EmpService;
import kr.or.ddit.emp.service.EmpServiceI;

public class EmpServiceTest {

	@Test
	public void selectAllUserTest() {
		/***Given***/
		EmpServiceI service = new EmpService(); 
		/***When***/
		List<EmpVo> listVo = service.selectAllUser();
		/***Then***/
		assertEquals(15, listVo.size());
	}
	@Test
	public void selectUser() {
		/***Given***/
		EmpServiceI service = new EmpService(); 
		/***When***/
		EmpVo vo = service.selectUser(7369); 
		/***Then***/
		assertEquals(800, vo.getSal());
	}
	@Test 
	public void selectPagingEmp() {
		/***Given***/
		EmpServiceI service = new EmpService(); 
		PageVo vo = new PageVo(); 
		vo.setPage(2);
		vo.setPagesize(4);
		/***When***/
		List<EmpVo> listVo = service.selectPagingEmp(vo);
		/***Then***/
		assertEquals(4 , listVo.size());
	}
	
}
