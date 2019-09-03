/**
 * 
 */
package com.bmw.imiles.enumeration;

/**
 * @author avadheshkumar
 *
 */
public enum ImilesEnum {
	PENDING("pending"), ACCREDITED("accredited");

	private String status;

	ImilesEnum(String status) {
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

}
