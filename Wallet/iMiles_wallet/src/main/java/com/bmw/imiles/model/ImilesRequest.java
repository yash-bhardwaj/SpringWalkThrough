package com.bmw.imiles.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude
public class ImilesRequest {
	@JsonProperty("vehicleNumber")
	private String vehicleNo;
	@JsonProperty("gcid")
	private String gcid;
	@JsonProperty("imiles")
	private long imiles;
	@JsonProperty("creditedOrRedemed")
	private String creditedOrRedemed;

	public ImilesRequest() {
	}

	public ImilesRequest(String vehicleNo, long imiles) {
		this.vehicleNo = vehicleNo;
		this.imiles = imiles;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public long getImiles() {
		return imiles;
	}

	public void setImiles(long imiles) {
		this.imiles = imiles;
	}

	/**
	 * @return the gcid
	 */
	public String getGcid() {
		return gcid;
	}

	/**
	 * @param gcid the gcid to set
	 */
	public void setGcid(String gcid) {
		this.gcid = gcid;
	}

	/**
	 * @return the creditedOrRedemed
	 */
	public String getCreditedOrRedemed() {
		return creditedOrRedemed;
	}

	/**
	 * @param creditedOrRedemed the creditedOrRedemed to set
	 */
	public void setCreditedOrRedemed(String creditedOrRedemed) {
		this.creditedOrRedemed = creditedOrRedemed;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ImilesDTO [vehicleNo=" + vehicleNo + ", gcid=" + gcid + ", imiles=" + imiles + ", creditedOrRedemed="
				+ creditedOrRedemed + "]";
	}

}
