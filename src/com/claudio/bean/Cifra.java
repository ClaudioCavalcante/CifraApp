package com.claudio.bean;

public class Cifra extends BaseBean{

	private int cifraID;
	private String name;
	private String author;
	private int userID;
	
	public int getCifraID() {
		return cifraID;
	}

	public void setCifraID(int cifraID) {
		this.cifraID = cifraID;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
