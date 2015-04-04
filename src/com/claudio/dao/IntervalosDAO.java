package com.claudio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.claudio.bean.Acidentes;
import com.claudio.bean.Intervalos;

public class IntervalosDAO extends BaseDAO {

	public List<Intervalos> getIntervalos() throws SQLException {
		List<Intervalos> intervalos = new ArrayList<Intervalos>();
		setStatement("SELECT * FROM INTERVALOS");
		ResultSet rs = stmt.executeQuery();
		String result = "";
		while(rs.next()){
			Intervalos intervalo = new Intervalos();
			intervalo.setInterID(rs.getInt("interID"));
			intervalo.setIntervalo_name(rs.getString("intervalo_name"));
			intervalo.setIntervalo_char(rs.getString("intervalo_char"));
			intervalos.add(intervalo);
		}//fim do while
		return intervalos;

	}

	public Intervalos getIntervalo(int i) throws SQLException {
		Intervalos intervalo = getIntervalos().get(i);
		return intervalo;
	}

}
