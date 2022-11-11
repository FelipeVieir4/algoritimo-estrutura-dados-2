class Inteiro {

	private int valor;

	public Inteiro() {
		valor = 0;
	}
	
	public Inteiro(int i) {
		valor = i;
	} 
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public void imprimir() {
		System.out.println("Valor: " + this.valor);
	}
}

