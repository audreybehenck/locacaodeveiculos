package locacaodeveiculos;

public class Locatario {
	
	private char categoriaCnh;
	private int numWpp;
	public char getCategoriaCnh() {
		return categoriaCnh;
	}
	public void setCategoriaCnh(char categoriaCnh) {
		this.categoriaCnh = categoriaCnh;
	}
	public int getNumWpp() {
		return numWpp;
	}
	public void setNumWpp(int numWpp) {
		this.numWpp = numWpp;
	}
	@Override
	public String toString() {
		return "Locatario [categoriaCnh=" + categoriaCnh + ", numWpp=" + numWpp + "]";
	}
	
	

}
