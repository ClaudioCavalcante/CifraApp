package com.claudio.bean;

public class Semitons {

	private int tonsID;
	private String sem_names;
	private int interID;//chave estrangeira de Intervalo
	
	public int getInterID() {
		return interID;
	}
	public void setInterID(int interID) {
		this.interID = interID;
	}
	public int getTonsID() {
		return tonsID;
	}
	public void setTonsID(int tonsID) {
		this.tonsID = tonsID;
	}
	public String getSemi_names() {
		return sem_names;
	}
	public void setSemi_names(String semi_names) {
		this.sem_names = semi_names;
	}
	
	
	
}//fim da classe Semitons
