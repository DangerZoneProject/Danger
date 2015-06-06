package util;

import dao.JdbcOcorrenciaDAO;
import dao.JdbcRuaDAO;
import dao.OcorrenciaDAO;
import dao.RuaDAO;

public class DAOFactory {
	
	public static RuaDAO createRuaDAO(){
		return new JdbcRuaDAO();
	}
	
	public static OcorrenciaDAO createOcorrenciaDAO(){
		return new JdbcOcorrenciaDAO();
	}
	
}
