/**
 * 
 */
package com.bmw.imiles.model;

import java.util.List;

/**
 * @author avadheshkumar
 *
 */
public class ImilesResponse {
	private String message;
	private int status;
	private List<?> data;
	
	public ImilesResponse() {
	}

	public ImilesResponse(String message, int status, List<?> data) {
		this.message = message;
		this.status = status;
		this.data = data;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

}
