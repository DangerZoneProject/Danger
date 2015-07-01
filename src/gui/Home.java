package gui;

import java.io.FileWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;


import java.util.Random;

import util.DAOFactory;
import dao.RuaDAO;
import dominio.Rua;
import json.JSONArray;
import json.JSONException;
import json.JSONObject;

public class Home {

	private static FileWriter writeFile = null;
	
	private static RuaDAO rd = DAOFactory.createRuaDAO();
	private static List<Rua> ruas = rd.listar();
	
	private static JSONArray array = new JSONArray();

	public static void main(String[] args) {
		
		try {	                
			for (Rua rua:ruas){		    
		    JSONObject jsonTeste = new JSONObject();
		
		    jsonTeste.put("Pontuacao", rua.getPontuacao());
		    jsonTeste.put("Latitude", rua.getLatitude());
		    jsonTeste.put("Longitude", rua.getLongitude());		                
		    
		    array.put(jsonTeste);
			}
		    
		    System.out.println("JSONArray: "+ array);
		                        
		    } catch (JSONException e) {
		        e.printStackTrace();
		    }	
		
		/*
		try{
		ConnectionFactory.getConnection();
		}catch(Exception ex){
		JOptionPane.showMessageDialog(null, ex.getMessage());
		JOptionPane.showMessageDialog(null, ex.getCause());
		}
		
		RuaDAO rd = DAOFactory.createRuaDAO();
		List<Rua> ruas = rd.listar();
		
		
		for (Rua rua:ruas){
			System.out.println("Nome : " +rua.getNome());
			System.out.println("Latitude : " +rua.getLatitude());
			System.out.println("Longitude : " +rua.getLongitude());
			System.out.println("");
			System.out.println("###################  NEXT  #########################");
			System.out.println("");
			
		}
		
		
		OcorrenciaDAO od = DAOFactory.createOcorrenciaDAO();
		List<Ocorrencia> ocorrencias = od.listar();
		 
		for(Ocorrencia ocorrencia: ocorrencias){
			System.out.println("Rua da ocorrencia: " + ocorrencia.getRuaDaOcorrencia());
			System.out.println("Tipo: " + ocorrencia.getTipo());
			System.out.println("Data e Hora: " + ocorrencia.getHorario());
			System.out.println("Pontuacao: " + ocorrencia.getPontuacao());
			System.out.println("###################  NEXT  #########################");
			System.out.println("");
		}*/
		
		
	}
}
