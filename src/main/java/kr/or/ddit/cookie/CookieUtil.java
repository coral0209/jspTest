package kr.or.ddit.cookie;

import java.awt.List;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {

	/**  
	 * Method : getCookieValue 
	 * 작성자 : PC08-PC 
	 * 변경이력 :  
	 * @param cookieStr
	 * @param cookieName
	 * @return  
	 * Method 설명 : cookieStr 에서 cookieName 에 해당하는 쿠키 값을 조회 
	 */ 
	
	
	//cookieStr : userid=brown; rememberme=Y; test = testcookie
	public static String getCookieValue(String cookieStr, String cookieName) {
		int index = 0 ; 
		String[] k = cookieStr.split("; "); 
		System.out.println(k[0]);
		System.out.println(k[1]);
		System.out.println(k[2]);
		String res = null; 
		
		for (int i = 0 ; i < k.length ; i++) {
			String[] s = k[i].split("="); 
			if( s[0].equals(cookieName)) {
				res = s[1]; 
				System.out.println(res);
			}
		}
	
		
		return  res;
	}
	
	
//	
	/*
	 * public static String getCookie2Value(String cookieStr, String cookieName) {
	 * int index = 0 ; String[] k = cookieStr.split("; "); System.out.println(k[0]);
	 * System.out.println(k[1]); System.out.println(k[2]); String res = null;
	 * Map<String, String> map = new HashMap<>();
	 * 
	 * for (int i = 0 ; i < k.length ; i++) { String[] s = k[i].split("=");
	 * map.put(s[0] , s[1]); res = map.get(cookieName);
	 * 
	 * }
	 * 
	 * 
	 * return res; }
	 */
	
	
}
