package com.AnimalFactsChatmentAssignment.api.data;

import java.util.Date;

import org.yaml.snakeyaml.util.EnumUtils;

public class AnimalFact {
	
	private String text;
	
	private Date createdAt;
	
	private Date updatedAt;
	
	private Animals type;
	
	public AnimalFact() {}
	
	public AnimalFact(String text, Date createdAt, Date updatedAt, String type) {
		this.text = text;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.type = EnumUtils.findEnumInsensitiveCase(Animals.class, type);
	}
	
	public AnimalFact(String text, Date createdAt, Date updatedAt, Animals type) {
		this.text = text;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.type = type;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Animals getType() {
		return type;
	}
	public void setType(Animals type) {
		this.type = type;
	}
	
	public void setType(String type) {
		this.type = EnumUtils.findEnumInsensitiveCase(Animals.class, type);
	}
	
}
