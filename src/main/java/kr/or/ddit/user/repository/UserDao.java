package kr.or.ddit.user.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MyBatisUtil;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoI {

	@Override
	public List<UserVo> selectAllUser() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		//select : 리턴되는 값의 복수 유무를 판단 
		// 1. 단건 : 일반객체를 반환(UserVo) selectOne() 
		// 2. 여러건 : 컬렉션으로 묶어준다. List<UserVo> selectList() 
		// insert, update, delete : insert , update, delete 메소드이름과 동일하다. 
		
		//메소드 이름과 실행할 sql id 를 동일하게 맞추자. (유지보수-디른 개발자의 가독성) 
		
		List<UserVo> userList = sqlSession.selectList("users.selectAllUser");
		
		//mybatis 라는 프레임워크가 처리를 해줌.. connection 등등 안해줘도 된다. 
		sqlSession.close(); 
		
		return userList;
	}

	@Override
	public UserVo selectUser(String userid) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(); 
		
		UserVo user = sqlSession.selectOne("users.selectUser" , userid);
		
		
		sqlSession.close(); 
		return user ;
	}

	//사용자 페이징 리스트 
	@Override
	public List<UserVo> selectPagingUser(PageVo vo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(); 
		
		List<UserVo> userlist = sqlSession.selectList("users.selectPagingUser", vo);
		
		sqlSession.close(); 
		return  userlist;
	}

	@Override
	public int selectAllUserCount() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(); 
		int userCnt = sqlSession.selectOne("users.selectAllUserCount"); 

		sqlSession.close();
		return userCnt;
	}

	


}
