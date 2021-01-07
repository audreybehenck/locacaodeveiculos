package locacaodeveiculos;

public class Carro extends Veiculo {
	
	private int portas;
	private String possuiAr;
	private String cambio;
	private String direcao;
	
	public int getPortas() {
		return portas;
	}
	public void setPortas(int porta) {
		this.portas = porta;
	}
	public String getPossuiAr() {
		return possuiAr;
	}
	public void setPossuiAr(String possuiAr) {
		this.possuiAr = possuiAr;
	}
	public String getCambio() {
		return cambio;
	}
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	public String getDirecao() {
		return direcao;
	}
	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}
	
	@Override
	public String toString() {
		return super.toString()+ " Carro [porta=" + portas + ", possuiAr=" + possuiAr + ", cambio=" + cambio + ", direcao=" + direcao + "]";
	}
			

}
