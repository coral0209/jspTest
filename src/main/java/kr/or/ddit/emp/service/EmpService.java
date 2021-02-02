package kr.or.ddit.emp.service;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.emp.repository.EmpDao;
import kr.or.ddit.emp.repository.EmpDaoI;

public class EmpService implements EmpServiceI {


	EmpDaoI dao = new EmpDao(); 
	
	//전체회원직원
	@Override
	public List<EmpVo> selectAllUser() {
		return dao.selectAllUser();
	};

	//한명의 회원직원
	@Override
	public EmpVo selectUser(int empno) {
		return dao.selectUser(empno);
	}
	
	//지정된 페이지에 있는 모든 직원 정보 조회

	@Override
	public List<EmpVo> selectPagingEmp(PageVo vo) {
		return dao.selectPagingEmp(vo);
	}

}
