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
@Table(name = "IMILES_WALLET")
@AttributeOverride(name = "id", column = @Column(name = "IMILES_ID", nullable = false, columnDefinition = "BIGINT"))
public class Imiles extends BaseEntityAudit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "GCID", nullable = false)
	private String gcid;

	@Column(name = "VIN", nullable = false)
	private String vin;

	@Column(name = "RIDE_ID")
	private long rideID;

	@Column(name = "TOTAL_IMILES")
	private double totalImiles;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "IS_ARCHIVE")
	private boolean isArchive;

	@Column(name = "IS_DELETED")
	private boolean isDeleted;

	@Column(name = "IS_LATEST")
	private boolean isLatest;

	@Column(name = "CREDITTED_OR_DEBITTED")
	private String credittedOrDebitted;

	@Column(name = "IMILES_COUNT")
	private long imilesCount;

	@Column(name = "IS_EXPIRED", columnDefinition="boolean default false")
	private boolean isExpired;

	public Imiles() {
		super();
	}

	/**
	 * @return the rideID
	 */
	public long getRideID() {
		return rideID;
	}

	/**
	 * @param rideID the rideID to set
	 */
	public void setRideID(long rideID) {
		this.rideID = rideID;
	}

	/**
	 * @return the isLatest
	 */
	public boolean isLatest() {
		return isLatest;
	}

	/**
	 * @param isLatest the isLatest to set
	 */
	public void setLatest(boolean isLatest) {
		this.isLatest = isLatest;
	}

	/**
	 * @return the credittedOrDebitted
	 */
	public String getCredittedOrDebitted() {
		return credittedOrDebitted;
	}

	/**
	 * @param credittedOrDebitted the credittedOrDebitted to set
	 */
	public void setCredittedOrDebitted(String credittedOrDebitted) {
		this.credittedOrDebitted = credittedOrDebitted;
	}

	/**
	 * @return the imilesCount
	 */
	public long getImilesCount() {
		return imilesCount;
	}

	/**
	 * @param imilesCount the imilesCount to set
	 */
	public void setImilesCount(long imilesCount) {
		this.imilesCount = imilesCount;
	}

	/**
	 * @return the isExpired
	 */
	public boolean isExpired() {
		return isExpired;
	}

	/**
	 * @param isExpired the isExpired to set
	 */
	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

	public String getGcid() {
		return gcid;
	}

	public void setGcid(String gcid) {
		this.gcid = gcid;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public double getTotalImiles() {
		return totalImiles;
	}

	public void setTotalImiles(double totalImiles) {
		this.totalImiles = totalImiles;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isArchive() {
		return isArchive;
	}

	public void setArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Imiles [gcid=" + gcid + ", vin=" + vin + ", rideID=" + rideID + ", totalImiles=" + totalImiles
				+ ", status=" + status + ", isArchive=" + isArchive + ", isDeleted=" + isDeleted + ", isLatest="
				+ isLatest + ", credittedOrDebitted=" + credittedOrDebitted + ", imilesCount=" + imilesCount
				+ ", isExpired=" + isExpired + "]";
	}

}
