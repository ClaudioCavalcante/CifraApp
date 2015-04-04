package com.claudio.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.claudio.bean.Acidentes;
import com.claudio.bean.Chord;
import com.claudio.bean.Intervalos;
import com.claudio.bean.Semitons;
import com.claudio.dao.AcidentesDAO;
import com.claudio.dao.ChordDAO;
import com.claudio.dao.IntervalosDAO;
import com.claudio.dao.SemitonsDAO;

public class Chords {

	// RETORNA OS ACORDES
	public List<Chord> chordList() throws SQLException {
		return new ChordDAO().getChords();
	}// fim do metodo chordList

	public Chord chordSelect(int id) throws SQLException {
		return new ChordDAO().getChord(id);
	}// fim do metodo chordSelect

	// RETORNA OS ACIDENTES
	public List<Acidentes> acidentesList() throws SQLException {
		return new AcidentesDAO().getAcidentes();
	}// fim do metodo acidentesList

	public Acidentes acidentesSelect(int i) throws SQLException {
		return new AcidentesDAO().getAcidente(i);
	}// fim do metodo acidentesSelect

	// RETORNA OS INTERVALOS
	public List<Intervalos> intervalosList() throws SQLException {
		return new IntervalosDAO().getIntervalos();
	}// fim do metodo intervalosList

	public Intervalos intervalosSelect(int i) throws SQLException {
		return new IntervalosDAO().getIntervalo(i);
	}// fim do metodo intervalosSelect

	// RETORNA OS SEMITONS
	public List<Semitons> semitonsList() throws SQLException {
		return new SemitonsDAO().getSemitons();
	}// fim do metodo intervalosList

	public Semitons semitonsSelect(int i) throws SQLException {
		return new SemitonsDAO().getSemitom(i);
	}// fim do metodo intervalosSelect

}// fim da calase chords
