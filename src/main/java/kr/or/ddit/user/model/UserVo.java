package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserVo {
	private String userid;
	private String usernm;
	private String pass;
	private Date reg_dt; 
	private String alias;
	
	//대다수의 framework 는 기본 생성자를 필요로 한다. 
	public UserVo(){}
	
	
	public Date getReg_dt() {
		return reg_dt;
	}


	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	
	public String getReg_dt_fmt() {
		if(this.reg_dt == null) {
			return ""; 
		}
		else {
	
			return  new SimpleDateFormat("yyyy.MM.dd").format(this.reg_dt); 	
		}
		
		
		//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd"); 
		//	return sdf.format(this.reg_dt); 
		//reg_dt 필드가 null 이면 "" 문자열 반환 
		//reg_dt 필드가 null 이 아니면 SimpleDateFormat 을 
		//생성하여 yyyy.MM.dd 포맷의 문자열로 반환하여 리턴 
	}


	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsernm() {
		return usernm;
	}
	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAllias() {
		return alias;
	}
	public void setAllias(String alias) {
		this.alias = alias;
	}


	@Override
	public String toString() {
		return "UserVo [userid=" + userid + ", usernm=" + usernm + ", pass=" + pass + ", reg_dt=" + reg_dt + ", alias="
				+ alias + "]";
	} 
		
	

}