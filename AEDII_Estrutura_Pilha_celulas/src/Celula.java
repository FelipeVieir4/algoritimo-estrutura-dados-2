class Celula {

	private Inteiro item;
	private Celula proximo;
	
	public Celula(Inteiro novo) {
		item = novo;
		proximo = null;
	}
	
	public Celula() {
		
		item = new Inteiro();
		proximo = null;
	}
	
	public Inteiro getItem() {
		return item;
	}
	public void setItem(Inteiro item) {
		this.item = item;
	}
	
	public Celula getProximo() {
		return proximo;
	}
	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}
}

