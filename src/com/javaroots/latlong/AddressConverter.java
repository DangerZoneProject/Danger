package com.javaroots.latlong;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * 
 * @author Abhishek Somani
 * 
 */
public class AddressConverter {
 /*
  * Geocode request URL. Here see we are passing "json" it means we will get
  * the output in JSON format. You can also pass "xml" instead of "json" for
  * XML output. For XML output URL will be
  * "http://maps.googleapis.com/maps/api/geocode/xml";
  */

 private static final String URL = "http://maps.googleapis.com/maps/api/geocode/json";

 /*
  * Here the fullAddress String is in format like
  * "address,city,state,zipcode". Here address means "street number + route"
  * .
  */
 public GoogleResponse convertToLatLong(String fullAddress) throws IOException {

  /*
   * Create an java.net.URL object by passing the request URL in
   * constructor. Here you can see I am converting the fullAddress String
   * in UTF-8 format. You will get Exception if you don't convert your
   * address in UTF-8 format. Perhaps google loves UTF-8 format. :) In
   * parameter we also need to pass "sensor" parameter. sensor (required
   * parameter) � Indicates whether or not the geocoding request comes
   * from a device with a location sensor. This value must be either true
   * or false.
   */
  URL url = new URL(URL + "?address="
    + URLEncoder.encode(fullAddress, "UTF-8") + "&sensor=false");
  // Open the Connection
  URLConnection conn = url.openConnection();

  InputStream in = conn.getInputStream() ;
  ObjectMapper mapper = new ObjectMapper();
  GoogleResponse response = (GoogleResponse)mapper.readValue(in,GoogleResponse.class);
  in.close();
  return response;
  

 }
 
 public GoogleResponse convertFromLatLong(String latlongString) throws IOException {

  /*
   * Create an java.net.URL object by passing the request URL in
   * constructor. Here you can see I am converting the fullAddress String
   * in UTF-8 format. You will get Exception if you don't convert your
   * address in UTF-8 format. Perhaps google loves UTF-8 format. :) In
   * parameter we also need to pass "sensor" parameter. sensor (required
   * parameter) � Indicates whether or not the geocoding request comes
   * from a device with a location sensor. This value must be either true
   * or false.
   */
  URL url = new URL(URL + "?latlng="
    + URLEncoder.encode(latlongString, "UTF-8") + "&sensor=false");
  // Open the Connection
  URLConnection conn = url.openConnection();

  InputStream in = conn.getInputStream() ;
  ObjectMapper mapper = new ObjectMapper();
  GoogleResponse response = (GoogleResponse)mapper.readValue(in,GoogleResponse.class);
  in.close();
  return response; 
 }
 
	//m�todo para pegar os 100 pontos 

	static void pegaPontos(float lat, float minX, float maxX,
			float longi, float minY, float maxY, ArrayList<Double> lati,
			ArrayList<Double> lon, int quant, int max, int min, float raio) {
		
		minX = lat - raio ;
		maxX = lat + raio ;

		minY = longi - raio ;
		maxY = longi + raio ;
		
		for(; lati.size() < quant;){
			Random ran = new Random();
		
			float finalX = ran.nextFloat() * (maxX - minX) + minX;
			float finalY = ran.nextFloat() * (maxY - minY) + minY;
			
			if (comparar(finalX, finalY, lat, longi) < max && comparar(finalX, finalY, lat, longi) > min){
				lati.add((double) finalX);
				lon.add((double) finalY);
			};
		}
	}


	//verificar se o ponto est� numa distancia aceitavel da ocorrencia

	static float comparar(float lat1, float longi1, float lat2, float longi2){
		float R = 6378.137f;
		float dLat = (float) ((lat2 - lat1) * Math.PI /180);
		float dLon = (float) ((longi2 - longi1) * Math.PI /180);
		float a = (float) (Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(lat1 * Math.PI / 180) * Math.cos(lat2 * Math.PI / 180)
				* Math.sin(dLon/2) * Math.sin(dLon/2));
		float c = (float) (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)));
		float d = R * c;
		return d*1000;
	}
 
	 public static String printaEndereco(double lat,double longi) throws IOException{
		 String retorno = "";
		  GoogleResponse res1 = new AddressConverter().convertFromLatLong(""+lat+","+longi);
		  if(res1.getStatus().equals("OK"))
		  {
			String Address = res1.getResults()[0].getFormatted_address();
			//System.out.println("O endere�o � :"+ Address);
		    retorno = (Address);
		  }
		  else
		  {
		   System.out.println(res1.getStatus());
		  }
		  return retorno;  
		}
 
 public static void main(String[] args) throws IOException {
		//C�digode teste
		float latitude = 8.0183339f;
		float minLatitude = 0;
		float maxLatitude = 0;

		float longitude = 34.9451496f;
		float minLongitude = 0;
		float maxLongitude = 0;

		ArrayList<Double> listaLatitudes = new ArrayList<Double>();
		ArrayList<Double> listaLongitudes = new ArrayList<Double>();
		
		pegaPontos(latitude, minLatitude, maxLatitude, longitude, minLongitude, maxLongitude, listaLatitudes, listaLongitudes, 10, 50, 0, 0.0004f);
		pegaPontos(latitude, minLatitude, maxLatitude, longitude, minLongitude, maxLongitude, listaLatitudes, listaLongitudes, 30, 100, 50, 0.0008f);
		pegaPontos(latitude, minLatitude, maxLatitude, longitude, minLongitude, maxLongitude, listaLatitudes, listaLongitudes, 60, 150, 100, 0.0012f);
		pegaPontos(latitude, minLatitude, maxLatitude, longitude, minLongitude, maxLongitude, listaLatitudes, listaLongitudes, 100, 200, 150, 0.0016f);
		
		
//		System.out.println(listaLatitudes);
//		System.out.println(listaLongitudes);
		ArrayList<String> ruas = new ArrayList<String>();
		String Listaruas[]= {"Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil,",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 878-910 - Dois Irm�os, Recife - PE, Brazil",
		        "Rodovia Governador M�rio Covas, 203-401 - Guabiraba, Recife - PE, Brazil",
		        "Rodovia Governador M�rio Covas, 203-401 - Guabiraba, Recife - PE, Brazil",
		        "Rodovia Governador M�rio Covas, 203-401 - Guabiraba, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rodovia Governador M�rio Covas, 203-401 - Guabiraba, Recife - PE, Brazil",
		        "Rodovia Governador M�rio Covas, 203-401 - Guabiraba, Recife - PE, Brazil",
		        "Rodovia Governador M�rio Covas, 203-401 - Guabiraba, Recife - PE, Brazil",
		        "Rodovia Governador M�rio Covas, 203-401 - Guabiraba, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 878 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 878-910 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Avenida da Recupera��o, 957 - Guabiraba, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rodovia Governador M�rio Covas, 203-401 - Guabiraba, Recife - PE, Brazil",
		        "Rodovia Governador M�rio Covas, 203-401 - Guabiraba, Recife - PE, Brazil",
		        "Avenida da Recupera��o, 403 - Guabiraba, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Avenida da Recupera��o, 957 - Guabiraba, Recife - PE, Brazil",
		        "Pra�a Farias Neves, 2-116 - Campo Grande, Recife - PE, Brazil",
		        "Avenida da Recupera��o, 403 - Guabiraba, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rodovia Governador M�rio Covas, 203-401 - Guabiraba, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 878-910 - Dois Irm�os, Recife - PE, Brazil",
		        "Pra�a Farias Neves, 2-116 - Campo Grande, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Pra�a Farias Neves, 2-116 - Campo Grande, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rodovia Governador M�rio Covas, 203-401 - Guabiraba, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rodovia Governador M�rio Covas, 203-401 - Guabiraba, Recife - PE, Brazil",
		        "Avenida da Recupera��o, 957 - Guabiraba, Recife - PE, Brazil",
		        "Rodovia Governador M�rio Covas, 203-401 - Guabiraba, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Pra�a Farias Neves, 2-116 - Campo Grande, Recife - PE, Brazil",
		        "Pra�a Farias Neves, 2-116 - Campo Grande, Recife - PE, Brazil",
		        "Avenida da Recupera��o, 403-451 - Guabiraba, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rodovia Governador M�rio Covas, 203-401 - Guabiraba, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Avenida da Recupera��o, 957 - Guabiraba, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Pra�a Farias Neves, 2-116 - Campo Grande, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Pra�a Farias Neves, 2-116 - Campo Grande, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rodovia Governador M�rio Covas, 203-401 - Guabiraba, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Pra�a Farias Neves, 2-116 - Campo Grande, Recife - PE, Brazil",
		        "Pra�a Farias Neves, 2-116 - Campo Grande, Recife - PE, Brazil",
		        "Avenida da Recupera��o, 957 - Guabiraba, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Pra�a Farias Neves, 2-116 - Campo Grande, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Rodovia Governador M�rio Covas, 203-401 - Guabiraba, Recife - PE, Brazil",
		        "Pra�a Farias Neves, 2-116 - Campo Grande, Recife - PE, Brazil",
		        "Avenida da Recupera��o, 403 - Guabiraba, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 878-910 - Dois Irm�os, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Pra�a Farias Neves, 2-116 - Campo Grande, Recife - PE, Brazil",
		        "Rodovia Governador M�rio Covas, 203-401 - Guabiraba, Recife - PE, Brazil",
		        "Pra�a Farias Neves, 2-116 - Campo Grande, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Avenida da Recupera��o, 403-451 - Guabiraba, Recife - PE, Brazil",
		        "Rua Manuel de Medeiros, 610-876 - Dois Irm�os, Recife - PE, Brazil",
		        "Avenida da Recupera��o, 957 - Guabiraba, Recife - PE, Brazil",
		        "Rodovia Governador M�rio Covas, 203-401 - Guabiraba, Recife - PE, Brazil",
		        "Pra�a Farias Neves, 2-116 - Campo Grande, Recife - PE, Brazil"};
		
		for(int i=0 ; i < listaLatitudes.size(); i++){
//			printaEndereco(listaLatitudes.get(i)*-1,listaLongitudes.get(i)*-1);			
			ruas.add(printaEndereco(listaLatitudes.get(i)*-1,listaLongitudes.get(i)*-1));
		}  
  
		System.out.println(ruas);
		

 }
 

}