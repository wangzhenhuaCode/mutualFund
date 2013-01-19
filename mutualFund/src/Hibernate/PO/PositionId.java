package Hibernate.PO;

/**
 * PositionId entity. @author MyEclipse Persistence Tools
 */

public class PositionId implements java.io.Serializable {

	// Fields

	private Customer customer;
	private Fund fund;

	// Constructors

	/** default constructor */
	public PositionId() {
	}

	/** full constructor */
	public PositionId(Customer customer, Fund fund) {
		this.customer = customer;
		this.fund = fund;
	}

	// Property accessors

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Fund getFund() {
		return this.fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PositionId))
			return false;
		PositionId castOther = (PositionId) other;

		return ((this.getCustomer() == castOther.getCustomer()) || (this
				.getCustomer() != null && castOther.getCustomer() != null && this
				.getCustomer().equals(castOther.getCustomer())))
				&& ((this.getFund() == castOther.getFund()) || (this.getFund() != null
						&& castOther.getFund() != null && this.getFund()
						.equals(castOther.getFund())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCustomer() == null ? 0 : this.getCustomer().hashCode());
		result = 37 * result
				+ (getFund() == null ? 0 : this.getFund().hashCode());
		return result;
	}

}