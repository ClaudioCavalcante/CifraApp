package com.claudio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.claudio.bean.Chord;
import com.claudio.jdbc.DataSourceFactory;


public class ChordDAO extends BaseDAO{
	
	//retorna todos os acordes do banco
	public List<Chord> getChords() throws SQLException{
		List<Chord> chords = new ArrayList<Chord>();
		setStatement("SELECT * FROM CHORD");
		ResultSet rs = stmt.executeQuery();
		String result = "";
		while(rs.next()){
			Chord chord = new Chord();
			chord.setChordID(rs.getInt("chordID"));
			chord.setChord_letter(rs.getString("chord_letter"));
			chords.add(chord);
		}//fim do while
		return chords;
	}//fim de getChords
	
	
	//retorna um Chord seleciondo do banco
	public Chord getChord(int id) throws SQLException{
		Chord chord = getChords().get(id);
		return chord;
	}//fim de getChord

}//fim de ChordDAO
