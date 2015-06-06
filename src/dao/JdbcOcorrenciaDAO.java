package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import util.ConnectionFactory;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dominio.Ocorrencia;

public class JdbcOcorrenciaDAO implements OcorrenciaDAO {

	Connection conexao;

	public JdbcOcorrenciaDAO() {
		conexao = (Connection) ConnectionFactory.getConnection();
	}

//	@Override
//	public void inserir(Ocorrencia Ocorrencia) {
//		// TODO Auto-generated method stub
//		try {
//			String SQL = "INSERT INTO Ocorrencia (nome,latitude,longitude) VALUES"
//					+ "(?,?,?)";
//			PreparedStatement ps = (PreparedStatement) conexao
//					.prepareStatement(SQL);
//			ps.setString(1, Ocorrencia.getNome());
//			ps.setFloat(2, Ocorrencia.getLatitude());
//			ps.setFloat(3, Ocorrencia.getLongitude());
//			ps.executeUpdate();
//			ps.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void remover(Ocorrencia Ocorrencia) {
//		// TODO Auto-generated method stub
//
//	}

	@Override
	public List<Ocorrencia> listar() {
		List<Ocorrencia> Ocorrencias = new ArrayList<Ocorrencia>();

		try {
			String SQL = "SELECT nome, tipo, horario, pontuacao "
					+ "FROM  rua_has_ocorrencias, ocorrencia, rua "
					+ "WHERE ocorrencias_idocorrencias = ocorrencia.idocorrencias "
					+ "AND ruas_idruas = rua.idruas";
			PreparedStatement ps = (PreparedStatement) conexao
					.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Ocorrencia Ocorrencia = new Ocorrencia();
				Ocorrencia.setRuaDaOcorrencia(rs.getString(	"nome"));
				Ocorrencia.setTipo(rs.getString("tipo"));
				Ocorrencia.setHorario(rs.getString("horario"));
				Ocorrencia.setPontuacao(rs.getInt("pontuacao"));
				Ocorrencias.add(Ocorrencia);

			}
			return Ocorrencias;

		} catch (SQLException ex) {
			java.util.logging.Logger.getLogger(
					JdbcOcorrenciaDAO.class.getName()).log(Level.SEVERE, null,
					ex);
			throw new RuntimeException("Falha ao listar Ocorrencias em JdbcOcorrenciaDAO", ex);
		}
	}

	@Override
	public Ocorrencia buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}