package com.classes;

public class Commentary {

	public Commentary() {
		
	}
	
	public Commentary(String name, String text) {
		super();
		this.name = name;
		this.text = text;
	}
	
	private String name;
	private String text;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
