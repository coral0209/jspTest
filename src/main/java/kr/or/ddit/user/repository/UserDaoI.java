package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserDaoI {

	//전체 사용자 정보 조회 
	/*SELECT *
	 * FROM users;
	 */
	//인터페이스에는 public 이 자동으로 붙는다. 
	//반환타입 메도스명() ; 
	List<UserVo> selectAllUser();

	//특정한 유저 1명에대한 정보 
	UserVo selectUser(String userid); 

	//사용자 페이징 리스트 
	List<UserVo> selectPagingUser(PageVo vo);

	
	//사용자 전체 수 조회 
	
	int selectAllUserCount();
	
	//사용자 정보 수정 
	int modifyUser(UserVo userVo); 
	//사용자 정보 등록 
	int insertUser(UserVo userVo); 
	
	//중복검사
	int checkId(String userid );
	
	//유저 삭제
	int deleteUser(String userid); 
	
}