package Hibernate.PO;

/**
 * FundPriceHistory entity. @author MyEclipse Persistence Tools
 */

public class FundPriceHistory implements java.io.Serializable {

	// Fields

	private FundPriceHistoryId id;
	private Double price;

	// Constructors

	/** default constructor */
	public FundPriceHistory() {
	}

	/** full constructor */
	public FundPriceHistory(FundPriceHistoryId id, Double price) {
		this.id = id;
		this.price = price;
	}

	// Property accessors

	public FundPriceHistoryId getId() {
		return this.id;
	}

	public void setId(FundPriceHistoryId id) {
		this.id = id;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}