package Struts.Action;

import java.util.List;
import java.util.Map;

import Hibernate.DAO.ICustomerDAO;
import Hibernate.DAO.IEmployeeDAO;
import Hibernate.DAO.IFundDAO;
import Hibernate.PO.Customer;
import Hibernate.PO.Employee;
import Hibernate.PO.Fund;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {
	private IEmployeeDAO employeeDAO;
	private ICustomerDAO customerDAO;
	private Customer customer;
	private Employee employee;
	private String newPassword;
	private String errorInfo;
	private Fund fund;
	private IFundDAO fundDAO;
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setFund(Fund fund) {
		this.fund = fund;
	}
	public void setEmployeeDAO(IEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	public void setCustomerDAO(ICustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	public void setFundDAO(IFundDAO fundDAO) {
		this.fundDAO = fundDAO;
	}
	public String login(){
		errorInfo="";
		List<Employee> list=employeeDAO.findByProperty("username", employee.getUsername());
		if(list.size()==0){
			errorInfo="Username error!";
			return "failure";
		}
		if(list.get(0).getPassword().equals(employee.getPassword())){
			ActionContext ctx=ActionContext.getContext();
			Map<String,Object> session=ctx.getSession();
			session.put("employee", list.get(0));
			return "employeeSucessLogin";
		}
		else{
			errorInfo="Password error!";
			return "employeeFailureLogin";
		}
	}
	public String logout(){
		errorInfo="";
		ActionContext ctx=ActionContext.getContext();
		Map<String,Object> session=ctx.getSession();
		session.put("employee", null);
		return "logoutSuccess";
	}
	public String changePassword(){
		errorInfo="";
		ActionContext ctx=ActionContext.getContext();
		Map<String,Object> session=ctx.getSession();
		Employee e=(Employee)session.get("employee");
		if(e.getPassword().equals(employee.getPassword())){
			e.setPassword(newPassword);
			employeeDAO.update(e);
			return "employeeSucessChangePassword";
		}else{
			errorInfo="Password Error";
			return "employeeFailureChangePassword";
		}
	}
	public String addNewFund(){
		errorInfo="";
		fundDAO.save(fund);
		return "addNewFundSuccess";
	}
	public String addNewCustomerAccount(){
		errorInfo="";
		customerDAO.save(customer);
		return "addNewCustomerAccountSuccess";
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
