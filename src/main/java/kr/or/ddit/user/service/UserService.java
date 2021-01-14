package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.repository.UserDaoI;

public class UserService implements UserServiceI {

	
	//UserDao  선언과 같이 생성해주고(UserDao() 를 ) 해주어야 nullpointException 이 나오지 않는다. 

	//싱글톤패턴으로 받아온것*(과거프로젝트). 

	private UserDaoI dao = new UserDao(); 
	
	
	@Override
	public List<UserVo> selectAllUser() {
		return dao.selectAllUser();
	}

	@Override
	public UserVo selectUser(String userid) {
		// TODO Auto-generated method stub
		return dao.selectUser(userid);
	}

	@Override
	public Map<String, Object> selectPagingUser(PageVo vo) {
		Map<String, Object> map = new HashMap<String, Object>(); 
		//현재 페이징처리된 페이지부분에속하는 회원들만 조회 
		List<UserVo> userList = dao.selectPagingUser(vo); 
		//현재 회원들의 총 숫자. 
		int userCnt = dao.selectAllUserCount(); 
		//그 회원들의 정보들의 리스트 저장 
		map.put("userList" , userList); 
		map.put("cnt" , userCnt);
		
		
		return map;
	}

	@Override
	public int modifyUser(UserVo userVo) {
		return dao.modifyUser(userVo);
	}

	@Override
	public int insertUser(UserVo userVo) {
		return dao.insertUser(userVo);
	}

	@Override
	public int checkId(String userid) {
		return dao.checkId(userid);
	}

}
