package Struts.Action;

import com.opensymphony.xwork2.ActionSupport;

public class FinaceAction extends ActionSupport {

	public String requestCheck(){
		return "Request Check succesfully";
	}
	
	public String financPage(){
		return "Finance";
	}
	
	public String depositPage(){
		return "Deposit check page";
	}
	
	public String deposit(){
		return "Deposit";
	}
	
	public String cancel(){
		return "cancel";
	}
}
