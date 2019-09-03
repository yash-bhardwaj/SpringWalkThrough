/**
 * 
 */
package com.bmw.imiles.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 * @author avadheshkumar
 *
 */
@MappedSuperclass
public class BaseEntityAudit extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Size(max = 20)
	@Column(name = "CREATED_BY", length = 20)
	private String createdBy;

	@Column(name = "LAST_UPDATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdationDate;

	@Size(max = 20)
	@Column(name = "LAST_UPDATION_BY", length = 20)
	private String lastUpdatedBy;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastUpdationDate() {
		return lastUpdationDate;
	}

	public void setLastUpdationDate(Date lastUpdationDate) {
		this.lastUpdationDate = lastUpdationDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	
}
