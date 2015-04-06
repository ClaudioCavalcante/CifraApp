package com.claudio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.claudio.bean.Cifra;

public class CifraDAO extends BaseDAO{

	public void setName(String title) {
		// TODO Auto-generated method stub
		
	}

	public void setauthor(String author) {
		// TODO Auto-generated method stub
		
	}

	public void setUserId(int userID) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Cifra> getCifras() throws SQLException{
		List<Cifra> cifras = new ArrayList<Cifra>();
		setStatement("SELECT * FROM CIFRA");
		ResultSet rs = stmt.executeQuery();
		String result = "";
		while(rs.next()){
			Cifra cifra = new Cifra();
			cifra.setCifraID(rs.getInt("cifraID"));
			cifra.setName(rs.getString("name"));
			cifra.setAuthor(rs.getString("author"));
			cifra.setUserID(rs.getInt("userID"));
			cifras.add(cifra);
		}//fim do while
		return cifras;
	}//fom de getCifraas

	public Cifra getCifra(String nome) throws SQLException{
		Cifra cifra = new Cifra();
		setStatement("SELECT * FROM CIFRA where name = '"+nome+"'");
		ResultSet rs = stmt.executeQuery();
		String result = "";
		while(rs.next()){
			cifra.setCifraID(rs.getInt("cifraID"));
			cifra.setName(rs.getString("name"));
			cifra.setAuthor(rs.getString("author"));
			cifra.setUserID(rs.getInt("userID"));
		}//fim do while
		return cifra;
	}//fom de getCifraas

	public void insertCifra(String name, String author, int result) throws SQLException {
		// TODO Auto-generated method stub
		setStatement("INSERT INTO CIFRA (name, author,userID) VALUES (?,?,?)");
		stmt.setString(1, name);
		stmt.setString(2, author);
		stmt.setInt(3, result);
		
		stmt.execute();
	}//fim de insertCifra

	public void insertCifraLetter(String letter, String chordId, int cifraId) throws SQLException {
		// TODO Auto-generated method stub
		int chordID = 0;
		for (int i = 0; i < letter.length(); i++) {
			setStatement("INSERT INTO CIFRA_LETTER (syllable, chordID, cifraID) VALUES (?,?,?)");
			stmt.setString(1, ""+letter.charAt(i));
			if(chordId.charAt(i) == ' ' ){
				chordID = 0;
			}else{
				chordID = Integer.parseInt(""+chordId.charAt(i));
			}
			stmt.setInt(2, chordID);
			stmt.setInt(3, cifraId);
			
			stmt.execute();
		}
		
	}
}//fim da classe CifraDAO
