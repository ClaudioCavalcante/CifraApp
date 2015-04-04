package com.claudio.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.claudio.bean.Acidentes;
import com.claudio.bean.Chord;
import com.claudio.jdbc.DataSourceFactory;

public class AcidentesDAO extends BaseDAO{

	public List<Acidentes> getAcidentes() throws SQLException{
		List<Acidentes> acidentes = new ArrayList<Acidentes>();
		setStatement("SELECT * FROM ACIDENTES");
		ResultSet rs = stmt.executeQuery();
		String result = "";
		while(rs.next()){
			Acidentes acidente = new Acidentes();
			acidente.setAcidentesID(rs.getInt("acidentesID"));
			acidente.setAcidentes_name(rs.getString("acidentes_name"));
			acidente.setAcidentes_char(rs.getString("acidentes_char"));
			acidentes.add(acidente);
		}//fim do while
		return acidentes;
	}//fim de getChords

	public Acidentes getAcidente(int id) throws SQLException{
		Acidentes acidente = getAcidentes().get(id);
		return acidente;
	}//fim de getChord
	
}//fim da classe AcidentesDAO
