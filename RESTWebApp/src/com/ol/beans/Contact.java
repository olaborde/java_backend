package com.ol.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "contact")
public class Contact {
	
	int id;
	String name;
	
	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Contact(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + "]";
	}
	
	

}
