package kr.or.ddit.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DefaultParameterRequestWrapper extends HttpServletRequestWrapper {

	private Map<String, String[]> customMap ;
	public DefaultParameterRequestWrapper(HttpServletRequest request) {
		super(request);
		
		customMap = new HashMap<String , String[]>(request.getParameterMap());
		//새롭게 정의할 수 있네..! 
		
		
		//사정에 의해서 모든 요청객체에 UNT_CD 파라미터로 DDIT 문자열값을 넣어줘 
		customMap.put("UNT_CD", new String[] {"DDIT"});
		
		//parameter 관련된 메소드 4가지가 있었다. 
		
		
		
	}

	@Override
	public String getParameter(String name) {
		//키에 해당하는 값중에 첫번째 값을 반환 
		//키에 해당하는 값이 없을때? ==> null  
		String[] values = customMap.get(name);
		if(values == null || values.length == 0) {
			return null; 
		}
		else 
			return values[0]; 
	
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return customMap;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		 
		
		return Collections.enumeration(customMap.keySet());
	}
	
	//map 은 Collection 인터페이스 구현을 안한다. list, set은 collection  

	//특정파라미터값 리턴 
	@Override
	public String[] getParameterValues(String name) {
		return customMap.get(name);
	}

}
