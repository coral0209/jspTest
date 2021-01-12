package kr.or.ddit.emp.repository;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;

public interface EmpDaoI {
	
	//전체 회원검색하기
	
	public List<EmpVo> selectAllUser();
	
	//empno 를 받아서 한명의 회원정보검색하기 
	public EmpVo selectUser(int empno);
	
	//페이징처리된 emp 회원의 모든 정보 받아오기 
	public List<EmpVo> selectPagingEmp(PageVo vo); 

	
}
