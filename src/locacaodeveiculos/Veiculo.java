package locacaodeveiculos;

public abstract class Veiculo {

	private String placa;
	private int ano;
	private String marca;
	private String cor;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "Veiculo [placa=" + placa + ", ano=" + ano + ", marca=" + marca + ", cor=" + cor + "]";
	}

}
