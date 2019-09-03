/**
 * 
 */
package com.bmw.imiles.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author avadheshkumar
 *
 */
@Entity
@Table(name = "IMILES_TRANSACTION_HISTORY")
@AttributeOverride(name = "id", column = @Column(name = "IMILES_TRANSACTION_ID", nullable = false, columnDefinition = "BIGINT"))
public class ImilesTransactionHistory extends BaseEntityAudit {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="RIDE_ID")
	private long rideID;
	
	@Column(name = "CREDITED_IMILES")
	private double creditedImiles;

	@Column(name = "REDEEMED_IMILES")
	private double redeemedImiles;

	public ImilesTransactionHistory() {
	}

	public double getCreditedImiles() {
		return creditedImiles;
	}

	public void setCreditedImiles(double creditedImiles) {
		this.creditedImiles = creditedImiles;
	}

	public double getRedeemedImiles() {
		return redeemedImiles;
	}

	public void setRedeemedImiles(double redeemedImiles) {
		this.redeemedImiles = redeemedImiles;
	}

}
