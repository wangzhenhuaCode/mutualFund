package Struts.Action;

import Hibernate.DAO.IFundDAO;
import Hibernate.DAO.IPositionDAO;
import Hibernate.DAO.ITransactionDAO;

import com.opensymphony.xwork2.ActionSupport;

public class TradeAction extends ActionSupport {
	private IFundDAO fundDAO;
	private IPositionDAO positionDAO;
	private ITransactionDAO transactionDAO;
	private Long amount;

	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String buy(){
		return "";
	}
	public void setFundDAO(IFundDAO fundDAO) {
		this.fundDAO = fundDAO;
	}
	public void setPositionDAO(IPositionDAO positionDAO) {
		this.positionDAO = positionDAO;
	}
	public void setTransactionDAO(ITransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;
	}
	public String sell(){
		return "";
	}
	public String search(){
		return "";
	}
	public String gotoTrade(){
		
		return "";
	}
	public String research(){
		return "";
	}
}
