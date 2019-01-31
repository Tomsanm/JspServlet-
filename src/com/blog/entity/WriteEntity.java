package com.blog.entity;

public class WriteEntity {
	private String text;
	private String title;

	public WriteEntity(String text) {
		super();
		this.text = text;
	}
	public WriteEntity() {
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
