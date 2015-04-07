package com.claudio.bean;

public class Cifra_Letter {

	private int letterID;
	private String syllable;
	private int chordID;//FK CHORD
	private String chordLetter;
	public String getChordLetter() {
		return chordLetter;
	}
	public void setChordLetter(String chordLetter) {
		this.chordLetter = chordLetter;
	}
	private int acidentesID;//FK ACIDENTES
	private int interID;//FK INTERVALOS
	private int tonsID;//FK SEMITONS
	private int cifraID;//FK CIFRA
	public int getLetterID() {
		return letterID;
	}
	public void setLetterID(int letterID) {
		this.letterID = letterID;
	}
	public String getSyllable() {
		return syllable;
	}
	public void setSyllable(String syllable) {
		this.syllable = syllable;
	}
	public int getChordID() {
		return chordID;
	}
	public void setChordID(int chordID) {
		this.chordID = chordID;
	}
	public int getAcidentesID() {
		return acidentesID;
	}
	public void setAcidentesID(int acidentesID) {
		this.acidentesID = acidentesID;
	}
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
	public int getCifraID() {
		return cifraID;
	}
	public void setCifraID(int cifraID) {
		this.cifraID = cifraID;
	}
	
	
}//fim de cifra_Letter
