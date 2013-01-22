package Struts.Action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import Hibernate.DAO.IFundDAO;
import Hibernate.DAO.IPositionDAO;
import Hibernate.DAO.ITransactionDAO;
import Hibernate.PO.Customer;
import Hibernate.PO.Fund;
import Hibernate.PO.Position;
import Hibernate.PO.PositionId;
import Hibernate.PO.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TradeAction extends ActionSupport {
	private IFundDAO fundDAO;
	private IPositionDAO positionDAO;
	private ITransactionDAO transactionDAO;
	private List<Fund> fundlist;
	private Integer pageNum;
	private Integer maxPage;
	private Integer _PAGE_SIZE=20;
	private Fund fund;
	private Long amount;
	public String buy(){
		ActionContext ctx=ActionContext.getContext();
		Map<String,Object> session=ctx.getSession();
		Customer customer=(Customer)session.get("customer");
		if(amount>customer.getCash()) return "buyfailure";
		Transaction transaction=new Transaction();
		transaction.setCustomer(customer);
		transaction.setFund(fund);
		transaction.setTransactionType(Transaction.PENDING_SELL);
		transaction.setAmount(amount);
		transaction.setExecuteDate(new Date());
		transaction.setPosition(null);
		transactionDAO.save(transaction);
		return "buysuccess";
	}

	public String sell(){
		ActionContext ctx=ActionContext.getContext();
		Map<String,Object> session=ctx.getSession();
		Customer customer=(Customer)session.get("customer");
		PositionId pid=new PositionId(customer,fund);
		Position p=new Position(pid);
		positionDAO.find(p);
		Transaction transaction=new Transaction();
		transaction.setCustomer(customer);
		transaction.setFund(fund);
		transaction.setTransactionType(Transaction.PENDING_SELL);
		transaction.setAmount(amount);
		transaction.setExecuteDate(new Date());
		transaction.setPosition(null);
		transactionDAO.save(transaction);
		return "buysuccess";
	}
	public String search(){
		
		return "";
	}
	public String gotoTrade(){
		List<Fund> fundlist=fundDAO.getListByPage(0, _PAGE_SIZE,null,null);
		maxPage=fundDAO.count(null,null)/20+1;
		return "gotoTrade";
	}
	public String changePage(){
		if(maxPage==null)
			maxPage=fundDAO.count(null,null)/_PAGE_SIZE+1;
		if(pageNum<1)
			pageNum=1;
		if(pageNum>maxPage)
			pageNum=maxPage;
		List<Fund> fundlist=fundDAO.getListByPage((pageNum-1)*_PAGE_SIZE, _PAGE_SIZE,null,null);
		return "gotoTrade";
	}
	public String research(){
		return "";
	}
	
	
	
	//setter getter
	public void setFundDAO(IFundDAO fundDAO) {
		this.fundDAO = fundDAO;
	}
	public void setPositionDAO(IPositionDAO positionDAO) {
		this.positionDAO = positionDAO;
	}
	public void setTransactionDAO(ITransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;
	}

	public List<Fund> getFundlist() {
		return fundlist;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
}
