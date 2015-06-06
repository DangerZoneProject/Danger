package dominio;


public class Rua {
	private int Pontuacao;
	private float Latitude;
	private float Longitude;
	

	public int getPontuacao(){
		return Pontuacao;
	}
	
	public float getLatitude(){
		return Latitude;
	}
	
	public float getLongitude(){
		return Longitude;
	}
	
	public void setPontuacao(int pontuacao){
		this.Pontuacao = pontuacao;
	}
	
	public void setLatitude(float f){
		this.Latitude = f;
	}
	
	public void setLongitude(float longitude){
		this.Longitude = longitude;
	}

}
