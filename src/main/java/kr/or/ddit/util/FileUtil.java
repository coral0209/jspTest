package kr.or.ddit.util;

public class FileUtil {
	public static String getFileName(String contentDisposition) {
		String[] attrs = contentDisposition.split("; ");
		for(String attr : attrs) {
			if(attr.startsWith("filename=")) {
				attr = attr.replace("filename=", ""); 
				attr = attr.substring(1, (attr.length() - 1));
				return attr; 
			}
		}
		
		return "";
	}

	public static String getFileExtension2(String filename) {
		
		String attr = filename.split("\\.")[1]; 
		
		return attr;
		
	}
	
	public static String getFileExtension(String filename) {
		
		
		if(filename.indexOf(".") == -1) {
			return "";
		}
		
		return "." + filename.substring(filename.lastIndexOf(".") + 1);
		
	}

		
	
}
