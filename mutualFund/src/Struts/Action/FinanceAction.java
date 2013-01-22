package Struts.Action;

import java.util.Date;
import java.util.Map;

import Hibernate.DAO.ICustomerDAO;
import Hibernate.DAO.ITransactionDAO;
import Hibernate.PO.Customer;
import Hibernate.PO.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FinanceAction extends ActionSupport {
	private ITransactionDAO transactionDAO;
	private String errorInfo;
	private Customer customer;
	private ICustomerDAO customerDAO;

	private long amountRequest;
	private long amountDeposit;

	public String requestCheck(){
		ActionContext ctx=ActionContext.getContext();
		Map<String,Object> session=ctx.getSession();
		Customer customer=(Customer)session.get("customer");
		if(amountRequest<0) {
			errorInfo="Amount cannot be negative!";
			return "requestFailure";
		}
		Transaction transaction=new Transaction();
		transaction.setCustomer(customer);
		transaction.setTransactionType(Transaction.PENDING_WITHDRAW);
		transaction.setAmount(amountRequest);
		transaction.setExecuteDate(new Date());
		transactionDAO.save(transaction);
		return "requestSuccess";
	}
	
	public String financPage(){
		return "gotoFinance";
	}
	
	public String depositPage(){
		return "gotoDeposit";
	}
	
	public String deposit(){
		if(amountDeposit<0) {
			errorInfo="Amount cannot be negative!";
			return "depositFailure";
		}
		customer=customerDAO.find(customer).get(0);
		customer.setCash(customer.getCash()+amountDeposit);
		Transaction transaction=new Transaction();
		transaction.setCustomer(customer);
		transaction.setTransactionType(Transaction.PENDING_DEPOSIT);
		transaction.setAmount(amountDeposit);
		transaction.setExecuteDate(new Date());
		transactionDAO.save(transaction);
		return "depositSuccess";
	}
	
	public void setAmount(long amount) {
		this.amountRequest = amount;
	}

	public String getErrorInfo() {
		return errorInfo;
	}
	
	public void setTransactionDAO(ITransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;
	}

	public void setAmountDeposit(long amountDeposit) {
		this.amountDeposit = amountDeposit;
	}
	
	public void setCustermor(Customer customer) {
		this.customer = customer;
	}
	

	public void setCustomerDAO(ICustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

}
