package kr.or.ddit.servlet.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Factorial {
	
	private static final Logger logger = LoggerFactory.getLogger(Factorial.class);

	public static void main(String[] args) {
		Factorial factorial = new Factorial(); 
		int result = factorial.calculate2(5);
				if(result == 120) {
					logger.debug("success");
					
				}else {
					logger.debug("fail"); 
				}
		result = factorial.calculate(0);
				if(result == 1) {
					logger.debug("success");
					
				}else {
					logger.debug("fail"); 
				}
				
				
				
				
	}
	
	/**
	 * 
	 * Method : calculate 
	 * 작성자 : PC08-PC 
	 * 변경이력 :  
	 * @param fac
	 * @return  
	 * Method 설명 : 인자로 들어온 n 값을 이용하여 팩토리알을 계산 
	 */
	
	
	private int calculate(int fac) {
		//n! 결과값을 내야함 => 
		int res = 1; 
		for (int i = 1; i <= fac ; i++) {
			res *= i ; 
		}
		
		return res; 
		
	}
	
	public int calculate2(int n) {
		//n! 결과값을 내야함 => 
		int res = 1; 
		if(n <= 1 ) 
			return 1 ; 
		else
			return n * (calculate2(--n)); 
		
	}
	
	
	
	
	

}
