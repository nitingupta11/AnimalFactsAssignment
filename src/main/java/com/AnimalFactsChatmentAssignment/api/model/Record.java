package com.AnimalFactsChatmentAssignment.api.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "record")
public class Record {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ipAddress")
	private String ipAddress;
	
	@Column(name = "fact")
	private String fact;
	
	@Column(name = "createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	private Date date;
	
	public Record() {}
	
	public Record(String ipAddress, String fact) {
		super();
		this.ipAddress = ipAddress;
		this.fact = fact;
	}

	public Record(Long id, String ipAddress, String fact, Date date) {
		super();
		this.id = id;
		this.ipAddress = ipAddress;
		this.fact = fact;
		this.date = date;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getFact() {
		return fact;
	}

	public void setFact(String fact) {
		this.fact = fact;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Record [ipAddress=" + ipAddress + ", fact=" + fact + ", date=" + date + "]";
	}
	
	
	

}
