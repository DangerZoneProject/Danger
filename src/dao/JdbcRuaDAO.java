package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import util.ConnectionFactory;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dominio.Rua;

public class JdbcRuaDAO implements RuaDAO {
	
	Connection conexao;
	
	public JdbcRuaDAO(){		
		conexao = (Connection) ConnectionFactory.getConnection();
	}

	@Override
	public void inserir(Rua rua) {
		// TODO Auto-generated method stub
		try {			
			String SQL = "INSERT INTO rua (nome,latitude,longitude) VALUES"
				+"(?,?,?)";		
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(SQL);			
			ps.setInt(1, rua.getPontuacao());
			ps.setFloat(2, rua.getLatitude());
			ps.setFloat(3,rua.getLongitude());			
			ps.executeUpdate();		
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void remover(Rua rua) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Rua> listar() {
		List<Rua> ruas = new ArrayList<Rua>();
		
		try {			
			String SQL = "select pontuacao,latitude,longitude from rua , rua_has_ocorrencias , ocorrencia where idruas=ruas_idruas and ocorrencias_idocorrencias=idocorrencias";
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(SQL);			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				Rua rua = new Rua();
				rua.setPontuacao(rs.getInt("pontuacao"));
				rua.setLatitude(rs.getFloat("latitude"));
				rua.setLongitude(rs.getFloat("longitude"));
				ruas.add(rua);			
				
			}
			return ruas;
			
		} catch (SQLException ex) {
			java.util.logging.Logger.getLogger(JdbcRuaDAO.class.getName()).log(Level.SEVERE,null,ex);
			throw new RuntimeException("Falha ao listar ruas em JdbcRuaDAO",ex);
		}
	}

	@Override
	public Rua buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}