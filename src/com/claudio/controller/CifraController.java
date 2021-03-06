package com.claudio.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.claudio.bean.Chord;
import com.claudio.bean.Cifra;
import com.claudio.bean.Cifra_Letter;
import com.claudio.business.Chords;
import com.claudio.business.Cifras;

public class CifraController extends MainController {

	private String name;
	private String author;
	private String letter;
	private Chords ch;
	private Cifras cfr = new Cifras();

	public CifraController() throws SQLException {
		super("cifras");
		setTitlePage("Cifras");
		// TODO Auto-generated constructor stub
	}

	// ::::::METODOS PARA CIFRA LETTER::::::::::

	public void novaCifra() {
		setTitlePage("Cifras - Nova Cifra");
		view = "novacifra";
	}// fim de novaCifra(Chama formulario de nova cifra)

	public void novaCifra(String name, String author, String letter)
			throws SQLException {
		if (findTitle(name)) {
			setTitle(name, author);
			int cifraID = getCifra(name).getCifraID();
			String result = "<form action='/CifraApp/Cifra/salvarCifra/letter/cifraID.do' method='post'>";
			for (int i = 0; i < letter.length(); i++) {
				result += letter.charAt(i);
				result += "<select name='" + i + "'>";
				result += getChords();
			}// fim do for
			
			result += "<input hidden type='checkbox' name='letter' value='"
					+ letter + "' checked>";
			result += "<input hidden type='checkbox' name='cifraID' value='"
					+ cifraID + "' checked>";
			result += "<input type='submit'>";
			result += "</form>";

			view = "editcifra";
			setAttribute("letter", result);
		}// fim de if
		else {
			view = "novacifra";
			setAttribute("error", "A cifra ja existe!");
		}

	}// fim de novaCifra
	
	
	

	// ::: FUNCOES DE ACESSO A DAO (SALVAR, EXIBIR, EDITAR)

	//exibe a lista de cifras cadastradas
	public void listarCifras() throws SQLException {
		List<Cifra> cifrasTitle = cfr.getCifras();
		String result = "";
		for (int i = 0; i < cifrasTitle.size(); i++) {
			result += "<form action='exibirCifra/title.do' method = 'post'>"+
			"<input hidden type='radio' name='title' value='" + cifrasTitle.get(i).getName() + "' checked>"
			+ cifrasTitle.get(i).getName() +" - "
			+ cifrasTitle.get(i).getAuthor() 
			+"<input type='submit' value = 'Ver'>"+
			"</form> <br>";
		}// fim do for
		setAttribute("titlecifra", result);
	}// fim de listar cifras

	//Exibe a cifra completa
		public void exibirCifra(String cifraName) throws SQLException{
			cifraName = cifraName.replace("%20", " ");
			int cifraID = cfr.getCifra(cifraName).getCifraID();
			
			List<Cifra_Letter> cfLetter = cfr.getCifraLetter(cifraID);
			String result = "";
			for (int i = 0; i < cfLetter.size(); i++) {
				if(cfLetter.get(i).getChordLetter().equals("null") || cfLetter.get(i).getChordLetter() == null){
					result += "&nbsp; ";
				}else{result += cfLetter.get(i).getChordLetter();}
			} //fim do for
			
			result += "<br>";
			for (int i = 0; i < cfLetter.size(); i++) {
				result += cfLetter.get(i).getSyllable();
			} //fim do for
			setAttribute("cifraname", cfr.getCifra(cifraName).getName());
			setAttribute("cifraauthor", cfr.getCifra(cifraName).getAuthor());
			setAttribute("cifraletter", result);
			view = "exibircifraletter";
		}//fim de exibirCifra
	
	public void salvarCifra(String letter,String cifraID) throws SQLException {
		String chordID = "";
		for (int i = 0; i < letter.length(); i++) {
			chordID += getRequest().getParameter("" + i);
		}// fim do for
		cfr.insertCifraLetter(letter, chordID, cifraID);
		view = "saveletter";
	}// fim de recreateLetter
	
	// :::: FERRAMENTAS

	public void setTitle(String name, String author) throws SQLException {
		this.name = name;
		this.author = author;
		cfr.insertCifra(name, author, "0");
		setAttribute("name", name);
		setAttribute("author", author);
	}// fim de setTitle

	public boolean findTitle(String name) throws SQLException {
		if (!cfr.findTitle(name)) {
			return true;
		}// fim de if
		else {
			return false;
		}
	}// fim de findTitle
	
	public Cifra getCifra(String name) throws SQLException{
		return cfr.getCifra(name);
	}//fim de getCifra

	public String getChords() throws SQLException {
		Chords ch = new Chords();
		List<Chord> chords = ch.chordList();
		setTitlePage("Nova Cifra - " + name);
		String result = "<option value = '0'> </option>";
		for (int i = 0; i < chords.size(); i++) {
			result += "<option value='" + i + " '>" + chords.get(i).getChord_letter() + "</option>";
		}// fim do for

		result += "</select>";
		result += "<br><br>";

		return result;
		// setAttribute("letter", result);
	}

	

	// :::: GETVIEW
	@Override
	public String getView() {
		// TODO Auto-generated method stub
		return view;
	}

}
