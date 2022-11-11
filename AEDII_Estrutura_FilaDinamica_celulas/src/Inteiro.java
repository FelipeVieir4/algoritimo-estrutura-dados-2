
public class Inteiro {

	private int valor;
	
	//Construtor com parametro
	public Inteiro (int valor) {
		this.setValor(valor);
	}
	//Construtor sem parametro
	public Inteiro () {
		this.setValor(0);
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public void imprimir() {
		System.out.println("Valor ->" + valor);
	}
	
}
