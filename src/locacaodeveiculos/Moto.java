package locacaodeveiculos;

public class Moto extends Veiculo {
	
	private int cilindradas;

	public int getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(int cilindradas) {
		this.cilindradas = cilindradas;
	}

	@Override
	public String toString() {
		return super.toString()+ " Moto [cilindradas=" + cilindradas + "]";
	}
	
	

}
