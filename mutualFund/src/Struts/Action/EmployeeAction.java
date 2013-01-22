package Struts.Action;

import java.util.List;
import java.util.Map;

import Hibernate.DAO.ICustomerDAO;
import Hibernate.DAO.IEmployeeDAO;
import Hibernate.PO.Customer;
import Hibernate.PO.Employee;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {
	private IEmployeeDAO employeeDAO;//changes ddd wzh hkhk
	private Employee employee;
	private String newPassword;
	private String errorInfo;
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public void setEmployeeDAO(IEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
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
		return "employee";
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
