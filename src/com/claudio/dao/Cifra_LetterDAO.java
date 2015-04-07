package com.claudio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.claudio.bean.Cifra_Letter;

public class Cifra_LetterDAO extends BaseDAO {

	/*public List<Cifra_Letter> getCifraLetter(int cifraID) throws SQLException {
		List<Cifra_Letter> cifraLetters = new ArrayList<Cifra_Letter>();
		setStatement("SELECT * FROM CIFRA_LETTER WHERE cifraID = " + cifraID);
		ResultSet rs = stmt.executeQuery();
		String result = "";
		while(rs.next()){
			Cifra_Letter cifraLetter = new Cifra_Letter();
			cifraLetter.setLetterID(rs.getInt("letterID"));
			cifraLetter.setSyllable(rs.getString("syllable"));
			cifraLetter.setChordID(rs.getInt("chordID"));
			cifraLetter.setCifraID(rs.getInt("cifraID"));
			cifraLetters.add(cifraLetter);
		}//fim do while
		return cifraLetters;
	}// fim de getCifraLetter*/
	
	public List<Cifra_Letter> getCifraLetter(int cifraID) throws SQLException {
		List<Cifra_Letter> cifraLetters = new ArrayList<Cifra_Letter>();
		setStatement("SELECT cl.syllable, ch.chord_letter "+
				"FROM CIFRA_LETTER as cl "+
				"LEFT JOIN CHORD as ch ON cl.chordID = ch.chordID "+
				"WHERE cifraID = " + cifraID);
		ResultSet rs = stmt.executeQuery();
		String result = "";
		while(rs.next()){
			Cifra_Letter cifraLetter = new Cifra_Letter();
			cifraLetter.setSyllable(rs.getString("syllable"));
			cifraLetter.setChordLetter(rs.getString("chord_letter"));
			cifraLetters.add(cifraLetter);
		}//fim do while
		return cifraLetters;
	}// fim de getCifraLetter

	public void insertCifraLetter(String letter, String chordId, int cifraId)
			throws SQLException {
		// TODO Auto-generated method stub
		int chordID = 0;
		for (int i = 0; i < letter.length(); i++) {
			setStatement("INSERT INTO CIFRA_LETTER (syllable, chordID, cifraID) VALUES (?,?,?)");
			stmt.setString(1, "" + letter.charAt(i));
			if (chordId.charAt(i) == ' ') {
				chordID = 0;
			} else {
				chordID = Integer.parseInt("" + chordId.charAt(i));
			}
			stmt.setInt(2, chordID);
			stmt.setInt(3, cifraId);

			stmt.execute();
		}

	}// fim de insertCifraLetter
}// fim da classe Cifra_LetterDAO
