package dao;

import java.util.List;

import dominio.Rua;

public interface RuaDAO {
	
	public void inserir(Rua rua);
	
	public void remover(Rua rua);
	
	public List<Rua> listar();
	
	public Rua buscar(int id);
	
	

}
