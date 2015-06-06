package dominio;

public class Ocorrencia {
	private String ruaDaOcorrencia;
	private String tipo;
	private String horario;
	private int pontuacao;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	public String getRuaDaOcorrencia() {
		return ruaDaOcorrencia;
	}
	public void setRuaDaOcorrencia(String ruaDaOcorrencia) {
		this.ruaDaOcorrencia = ruaDaOcorrencia;
	}
	
}
