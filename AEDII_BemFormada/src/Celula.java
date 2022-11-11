class Celula {

	private char item;
	private Celula proximo;
	
	public Celula(char item) {
		this.item = item;
		proximo = null;
	}
	
	
	public char getItem() {
		return item;
	}
	public void setItem(char item) {
		this.item = item;
	}
	
	public Celula getProximo() {
		return proximo;
	}
	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}
}

