package kr.or.ddit.servlet.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import kr.or.ddit.servlet.FileUploadServlet;
import kr.or.ddit.util.FileUtil;

public class FileTest  {
	
	@Test
	public void Test() {
		/***Given***/
		String contentDisposition = "form-data; name=\"file\"; filename=\"brown.png\""; 
		/***When***/ 
		String filename = FileUtil.getFileName(contentDisposition);
		
		/***Then***/
		assertEquals("brown.png", filename);
	}
	
	@Test
	public void getFileExtensionTest2() {
		/***Given***/
		String filename = "brown.png"; 

		/***When***/
		String extension = FileUtil.getFileExtension2(filename); 

		/***Then***/
		assertEquals("png", extension);
	}
	
	@Test
	public void getFileExtensionTest() {
		/***Given***/
		String filename = "line.brown.png"; 

		/***When***/
		String extension = FileUtil.getFileExtension(filename); 

		/***Then***/
		assertEquals("png", extension);
	}
	


}
