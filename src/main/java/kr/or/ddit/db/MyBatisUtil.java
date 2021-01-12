package kr.or.ddit.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	//class 로딩시 실행되는 블록 (  static 블록 )
	//객체가 생성이 되어야만 사용이 가능하다.
	//클래스가 만들어지는 순간 ( vm 에서 존재를 알아차린것 ) , 초기화를 하겠다. 
	// 객체 생성순간이랑 클래스 생성순간은 다르다. 
	
	static SqlSessionFactory sqlSessionFactory;
	static {
		
		
		try {
			String resource = "kr/or/ddit/config/mybatis/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
		public static SqlSession getSqlSession() {
			return sqlSessionFactory.openSession();
		}
		
	
}
