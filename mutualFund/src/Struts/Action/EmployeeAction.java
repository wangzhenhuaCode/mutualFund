package Struts.Action;

import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {
//jkjk
	public String login(){
		return "employeeLoginSuccess";
	}
	public String logout(){
		return "employeeLogoutSuccess";
	}
	public String changePassword(){
		return "employeeLoginSuccess";
	}
	public String addNewFund(){
		return "employeeLoginSuccess";
	}
	public String addNewCustomerAccount(){
		return "employeeLoginSuccess";
	}
	public String viewCustomerAccount(){
		return "employeeLoginSuccess";
	}
	public String resetCustomerPassword(){
		return "employeeLoginSuccess";
	}
	public String viewTransactionHistory(){
		return "employeeLoginSuccess";
	}
	public String checkCustomerDeposit(){
		return "employeeLoginSuccess";
	}
}
