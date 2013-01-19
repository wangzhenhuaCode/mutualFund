package Hibernate.PO;

import java.util.Date;

/**
 * FundPriceHistoryId entity. @author MyEclipse Persistence Tools
 */

public class FundPriceHistoryId implements java.io.Serializable {

	// Fields

	private Fund fund;
	private Date priceDate;

	// Constructors

	/** default constructor */
	public FundPriceHistoryId() {
	}

	/** full constructor */
	public FundPriceHistoryId(Fund fund, Date priceDate) {
		this.fund = fund;
		this.priceDate = priceDate;
	}

	// Property accessors

	public Fund getFund() {
		return this.fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public Date getPriceDate() {
		return this.priceDate;
	}

	public void setPriceDate(Date priceDate) {
		this.priceDate = priceDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FundPriceHistoryId))
			return false;
		FundPriceHistoryId castOther = (FundPriceHistoryId) other;

		return ((this.getFund() == castOther.getFund()) || (this.getFund() != null
				&& castOther.getFund() != null && this.getFund().equals(
				castOther.getFund())))
				&& ((this.getPriceDate() == castOther.getPriceDate()) || (this
						.getPriceDate() != null
						&& castOther.getPriceDate() != null && this
						.getPriceDate().equals(castOther.getPriceDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFund() == null ? 0 : this.getFund().hashCode());
		result = 37 * result
				+ (getPriceDate() == null ? 0 : this.getPriceDate().hashCode());
		return result;
	}

}