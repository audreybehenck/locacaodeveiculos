package locacaodeveiculos;

public class Caminhao extends Veiculo {
	
	private double toneladas;

	public double getToneladas() {
		return toneladas;
	}

	public void setToneladas(double toneladas) {
		this.toneladas = toneladas;
	}

	@Override
	public String toString() {
		return super.toString()+ " Caminhao [toneladas=" + toneladas + "]";
	}
	
	

}
