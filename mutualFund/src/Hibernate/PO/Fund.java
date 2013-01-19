package Hibernate.PO;

import java.util.HashSet;
import java.util.Set;

/**
 * Fund entity. @author MyEclipse Persistence Tools
 */

public class Fund implements java.io.Serializable {

	// Fields

	private Integer fundId;
	private String name;
	private String symbol;
	private String description;
	private Set positions = new HashSet(0);
	private Set fundPriceHistories = new HashSet(0);
	private Set transactions = new HashSet(0);

	// Constructors

	/** default constructor */
	public Fund() {
	}

	/** minimal constructor */
	public Fund(String name, String symbol) {
		this.name = name;
		this.symbol = symbol;
	}

	/** full constructor */
	public Fund(String name, String symbol, String description, Set positions,
			Set fundPriceHistories, Set transactions) {
		this.name = name;
		this.symbol = symbol;
		this.description = description;
		this.positions = positions;
		this.fundPriceHistories = fundPriceHistories;
		this.transactions = transactions;
	}

	// Property accessors

	public Integer getFundId() {
		return this.fundId;
	}

	public void setFundId(Integer fundId) {
		this.fundId = fundId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getPositions() {
		return this.positions;
	}

	public void setPositions(Set positions) {
		this.positions = positions;
	}

	public Set getFundPriceHistories() {
		return this.fundPriceHistories;
	}

	public void setFundPriceHistories(Set fundPriceHistories) {
		this.fundPriceHistories = fundPriceHistories;
	}

	public Set getTransactions() {
		return this.transactions;
	}

	public void setTransactions(Set transactions) {
		this.transactions = transactions;
	}

}