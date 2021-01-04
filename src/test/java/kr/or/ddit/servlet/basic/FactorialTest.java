package kr.or.ddit.servlet.basic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactorialTest {

//TDD : Test Driven Development (테스트 기반 개발)
//BDD : Behavior Driven Development 

	
	/* @Test : 테스트 메소드에 붙이는 어노테이션 
			해딩 어노테이션을 붙이지 않으면 테스트 메소드로 인식되지 않음(테스트 대상에서 제외 ) 
			제한사항 : 
			1. 메소드 시그니처를 정해진대로 구성해야함
			   접근제어자 : public
	     	   반환타입 : void 
			   인자 : 없음 
			  테스트 메소드 : 통과 조건 
			  1. 테스트 메소드를 실행하는 과정에서 예외가 없이 끝까지 실행된 경우
			  2. assert 구문이 있을 경우 assert 구문이 전부 통과 했을 때 
		@before : 초기화 메소드에 붙이는 어노테이션 
				@test 어노테이션이 붙은 테스트 메소드를 호출하기 전에 먼저 실행됨 	  
				@before ==> @Test(test)
				@before ==> @Test(test2)
				@before ==> @Test(test3)
	
		@after : @Test 메서드 실행 이후에 실행된 메소드에 붙이는 어노테이션 
				자원 해제를 주로 담당 

		@BeforeClass, @AfterClass 
			클래스 단위로 최초 1회씩 호출 되는 메소드  
			@BeforeClass  
				@before ==> @Test(test) ==> @After
				@before ==> @Test(test2) ==> @After
				@before ==> @Test(test3) ==> @After
			@Afterclass 
			제한사항 : static 메소드로 선언을 해야한다. ==> 해당 메소드에서 사용하는 필드는 static 필드여야함 ==> 사용 빈도가 떨어지는 원인 
			

	*/
	
	private static final Logger logger = LoggerFactory.getLogger(FactorialTest.class);

	private Factorial factorial;
	
	@Before
	public void setup() {
		
		logger.debug("setup");
		factorial = new Factorial(); 
	}
	
	
	
	public void test() {
		logger.debug("test()");
		/***Given***/ //현재 테스트 환경에서 주어진 조건을 기술 
//		Factorial factorial = new Factorial();

		/***When***/ //테스트를 검증 하고자 하는 행위( method call )
		// private 이기 때문에 call 이 안된다. 나중에 다시 보고 public 으로 변경해줌
		int result = factorial.calculate2(5); 
		
		//120부븐은 예측값이고 result 는 결과값이다. 
		//assertEquals(100, result);
		
		
		/***Then***/ //코드를 실행한 결과와 예상한 값이 일치하는지 검증 

	}
	
	
	@Test
	public void test2() {
		logger.debug("test2()");
		/***Given***/ //현재 테스트 환경에서 주어진 조건을 기술 
//		Factorial factorial = new Factorial();

		/***When***/ //테스트를 검증 하고자 하는 행위( method call )
		// private 이기 때문에 call 이 안된다. 나중에 다시 보고 public 으로 변경해줌
		int result = factorial.calculate2(8); 
		
		//120부븐은 예측값이고 result 는 결과값이다. 
		assertEquals(1, result);
		
		
		/***Then***/ //코드를 실행한 결과와 예상한 값이 일치하는지 검증 

	}
	


	
	@Test
	public void test3() {
		logger.debug("test3()");
		/***Given***/ //현재 테스트 환경에서 주어진 조건을 기술 
//		Factorial factorial = new Factorial();

		/***When***/ //테스트를 검증 하고자 하는 행위( method call )
		// private 이기 때문에 call 이 안된다. 나중에 다시 보고 public 으로 변경해줌
		int result = factorial.calculate2(3); 
		
		//120부븐은 예측값이고 result 는 결과값이다. 
		assertEquals(6, result);
		
		
		/***Then***/ //코드를 실행한 결과와 예상한 값이 일치하는지 검증 

	}
}
