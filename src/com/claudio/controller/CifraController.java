package com.claudio.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.claudio.bean.Chord;
import com.claudio.business.Chords;

public class CifraController extends MainController{

	private String name;
	private String author;
	private Chords ch;
	
	
	public CifraController() {
		super("main");
		setTitlePage("Cifras");
		// TODO Auto-generated constructor stub
	}
	
	public void setTitle(String name,String author){
		this.name = name;
		this.author = author;
		
		setAttribute("name", name);
		setAttribute("author", author);
	}//fim de setTitle

	
	
	public void novaCifra(String name, String author, String letter) throws SQLException{
		
		setTitle(name, author);
		String result = "";
		for (int i = 0; i < letter.length(); i++) {
			result += letter.charAt(i);
			result += addChords();
		}//fim do for
		result += "<input type='submit'>";
		result += "</form>";
		
		view = "novacifra";
		setAttribute("letter", result);
	}//fim de novaCifra
	
	public String addChords() throws SQLException{
		Chords ch = new Chords();
		List<Chord> chords = ch.chordList();
		setTitlePage("Nova Cifra - "+name);
		String result = "<form action='action_page.php' align = 'top'>";
		result += "<select name='cars'>";
		result += "<option value = 'blank'> </option>";
		for (int i = 0; i < chords.size(); i++) {
			result += "<option value='"+chords.get(i).getChord_letter()+"'>"+chords.get(i).getChord_letter()+"</option>";	
		}//fim do for

		result +=  "</select>";
		result += "<br><br>";
		
		return result;
		//setAttribute("letter", result);	
	}
	
	@Override
	public String getView() {
		// TODO Auto-generated method stub
		return view;
	}

}
