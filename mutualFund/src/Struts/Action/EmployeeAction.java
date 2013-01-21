package Struts.Action;

import Hibernate.DAO.ICustomerDAO;
import Hibernate.PO.Customer;

import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {
	private ICustomerDAO customerDAO;
	private Customer customer;
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setCustomerDAO(ICustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	public String login(){
		return "employeeLoginSuccess";
	}
	public String logout(){
		return "employee";
	}
	public String changePassword(){
		return "employeeLoginSuccess";
	}
	public String addNewFund(){
		return "employeeLoginSuccess";
	}
	public String addNewCustomerAccount(){
		customerDAO.save(customer);
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
