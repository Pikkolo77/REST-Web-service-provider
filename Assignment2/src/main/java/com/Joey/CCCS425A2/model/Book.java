package com.Joey.CCCS425A2.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Book")
public class Book {
	
	private long id;
	private String title;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
