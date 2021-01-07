package locacaodeveiculos;

public class Onibus extends Veiculo {

	
	private int assentos;

	public int getAssentos() {
		return assentos;
	}

	public void setAssentos(int assentos) {
		this.assentos = assentos;
	}

	@Override
	public String toString() {
		return super.toString()+ " Onibus [assentos=" + assentos + "]";
	}
	
	

}
