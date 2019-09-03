/**
 * 
 */
package com.bmw.imiles.enumeration;

/**
 * @author avadheshkumar
 *
 */
public enum ImilesTransactionEnum {
	CREDITTED("creditted"), DEBITTED("debitted");
	public String transaction;

	ImilesTransactionEnum(String transaction) {
		this.transaction = transaction;
	}

	/**
	 * @return the transaction
	 */
	public String getTransaction() {
		return transaction;
	}

}
