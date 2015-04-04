package com.claudio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.claudio.bean.Semitons;

public class SemitonsDAO extends BaseDAO {

	public List<Semitons> getSemitons() throws SQLException {
		List<Semitons> intervalos = new ArrayList<Semitons>();
		setStatement("SELECT * FROM INTERVALOS");
		ResultSet rs = stmt.executeQuery();
		String result = "";
		while(rs.next()){
			Semitons semitom = new Semitons();
			semitom.setTonsID(rs.getInt("tonsID"));
			semitom.setSemi_names(rs.getString("semi_name"));
			semitom.setInterID(rs.getInt("interID"));
			intervalos.add(semitom);
		}//fim do while
		return intervalos;
	}

	public Semitons getSemitom(int i) throws SQLException {
		Semitons semitom = getSemitons().get(i);
		return semitom;
	}

}
