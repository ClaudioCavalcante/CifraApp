package com.claudio.business;

import java.sql.SQLException;
import java.util.List;

import com.claudio.bean.Cifra;
import com.claudio.dao.CifraDAO;

public class Cifras {

	private CifraDAO cifraDao = new CifraDAO();
	
	public List<Cifra> getCifras() throws SQLException {
		// TODO Auto-generated method stub
		return new CifraDAO().getCifras();
	}

	public boolean findTitle(String name) throws SQLException {
		
		if (cifraDao.getCifra(name).getName() != null){
			return true;
		}else{
			return false;
		}// fim de else if

	}// fim de findTitle
	
	public void insertCifra(String name,String author,String userID) throws SQLException{
		int result = Integer.parseInt(userID);
		cifraDao.insertCifra(name,author, result);
	}//fim de insertTitle


	public Cifra getCifra(String name) throws SQLException {
		if(findTitle(name)){
			return cifraDao.getCifra(name);
		}else{
			return null;
		}	
	}//fim de getCifra

	public void insertCifraLetter(String letter, String chordID, String cifraID) throws SQLException {
		// TODO Auto-generated method stub
		int cifraId = Integer.parseInt(cifraID);
		cifraDao.insertCifraLetter(letter,chordID, cifraId);
	}

}//fim da classe Cifras
