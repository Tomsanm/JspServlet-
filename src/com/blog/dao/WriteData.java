package com.blog.dao;

public class WriteData {
	private String text;
	private String title;

	public WriteData(String text) {
		super();
		this.text = text;
	}
	public WriteData() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	

}
