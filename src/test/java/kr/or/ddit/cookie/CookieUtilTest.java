package kr.or.ddit.cookie;

import static org.junit.Assert.*;

import org.junit.Test;

public class CookieUtilTest {

	// 테스트 메소드 명명 규칙 : 테스트할 메소드+ "Test"
	@Test
	public void getCookieValuetest() {

		/*** Given ***/
		String cookieStr = "userid=brown; rememberme=Y; test=testcookie";
		String cookieName = "rememberme";
		/*** When ***/
		String cookieValue = CookieUtil.getCookieValue(cookieStr, cookieName);
		/*** Then ***/
		assertEquals("Y", cookieValue);

	}

	/*
	 * //테스트 메소드 명명 규칙 : 테스트할 메소드+ "Test"
	 * 
	 * @Test public void getCookieValue2test() {
	 * 
	 *//*** Given ***/
	/*
	 * String cookieStr = "userid=brown; rememberme=Y; test = testcookie"; String
	 * cookieName = "brown";
	 *//*** When ***/
	/*
	 * String cookieValue = CookieUtil.getCookie2Value(cookieStr, cookieName);
	 *//*** Then ***//*
						 * assertEquals("Y" , cookieValue);
						 * 
						 * 
						 * }
						 */
}
