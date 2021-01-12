package kr.or.ddit.emp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MyBatisUtil;
import kr.or.ddit.emp.model.EmpVo;

public class EmpDao implements EmpDaoI {
	
	

	//모든 유저 정보 가져오기 
	@Override
	public List<EmpVo> selectAllUser() {
		//sqlSession 객체 생성
		SqlSession sqlSession = MyBatisUtil.getSqlSession(); 
		//List<EmpVo> 타입으로 받아온다. 
		//조회한 모든 회원하나하나의 정보를 리스트로 받아온다. 
		List<EmpVo> allUserList = sqlSession.selectList("emp.selectAllUser"); 
		//생성한 sqlSession 객체 닫아주기 
		sqlSession.close();
		//받아온 리스트 리턴해주기 
		return allUserList;
	}

	//한명의 유저 정보 받아오기 
	// 파라미터는 empno (pk) 
	@Override
	public EmpVo selectUser(int empno) {
		//sqlSession 객체 생성 
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		//selectOne 메소드를 활용해서 파라미터값으로 보내준 empno 에 해당하는 유저 정보 가져오기 
		EmpVo vo = sqlSession.selectOne("emp.selectUser", empno);
		//세션 닫아주기 
		sqlSession.close();
		//얻어온 vo 리턴해주기 
		return vo;
	}

	@Override
	public List<EmpVo> selectPagingEmp(PageVo vo) {
		//sqlSession 객체 생성 
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		//selectList() 메소드를 이용해서 지정한 vo(paging 정보)를 넘겨줬을때 그 페이지에 해당하는 회원들정보를 List<EmpVo> 타입의 변수에 담아주기 
		List<EmpVo> pageList = sqlSession.selectList("emp.selectPagingEmp", vo);
		//객체 닫아주기 
		sqlSession.close();
		//얻어온 정보 리턴 
		return pageList;
	}

}
