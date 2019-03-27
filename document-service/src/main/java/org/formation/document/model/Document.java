package org.formation.document.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Document implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6590486482810196501L;

	@Id @GeneratedValue
	private long id;
	
	private String name,contentType,owner;
	
//	@Lob
//	private byte[] data;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date uploadedDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
//
//	public byte[] getData() {
//		return data;
//	}
//
//	public void setData(byte[] data) {
//		this.data = data;
//	}

	public Date getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
	
	
}
