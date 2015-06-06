package dao;

import java.util.List;

import dominio.Ocorrencia;

public interface OcorrenciaDAO {
//	
//	public void inserir(Rua rua);
//	
//	public void remover(Rua rua);
	
	public List<Ocorrencia> listar();
	
	public Ocorrencia buscar(int id);
	
	

}