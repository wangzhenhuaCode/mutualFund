package Struts.Action;

import java.util.Date;
import java.util.Map;

import Hibernate.DAO.ICustomerDAO;
import Hibernate.DAO.IEmployeeDAO;
import Hibernate.DAO.ITransactionDAO;
import Hibernate.PO.Customer;
import Hibernate.PO.Employee;
import Hibernate.PO.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FinanceAction extends ActionSupport {
	private ICustomerDAO customerDAO;
	private IEmployeeDAO employeeDAO;
	private ITransactionDAO transactionDAO;
	private String errorInfo;
	private Customer customer;
	private Employee employee;
	private long amount;

	public String requestCheck(){
		ActionContext ctx=ActionContext.getContext();
		Map<String,Object> session=ctx.getSession();
		Customer customer=(Customer)session.get("customer");
		if(amount<0) {
			errorInfo="Amount cannot be negative!";
			return "requestFailure";
		}
		Transaction transaction=new Transaction();
		transaction.setCustomer(customer);
		transaction.setTransactionType(Transaction.PENDING_DEPOSIT);
		transaction.setAmount(amount);
		transaction.setExecuteDate(new Date());
		transactionDAO.save(transaction);
		return "requestSuccess";
	}
	
	public String financPage(){
		return "Finance";
	}
	
	public String depositPage(){
		return "Deposit check page";
	}
	
	public String deposit(){
		ActionContext ctx=ActionContext.getContext();
		Map<String,Object> session=ctx.getSession();
		Employee e=(Employee)session.get("employee");
		return "Deposit";
	}
	
	public String cancel(){
		return "Cancel";
	}
	
	
	public void setAmount(long amount) {
		this.amount = amount;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
