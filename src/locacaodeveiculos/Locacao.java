package locacaodeveiculos;

public class Locacao {
	
	private Locatario locatario;
	private Veiculo veiculo;
	
	public Locatario getLocatario() {
		return locatario;
	}
	public void setLocatario(Locatario locatario) {
		this.locatario = locatario;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	@Override
	public String toString() {
		return "Locacao [locatario=" + locatario + ", veiculo=" + veiculo + "]";
	}

	
	
}
