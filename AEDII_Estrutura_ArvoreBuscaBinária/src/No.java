
public class No {
	
	//Atributos:
	private Inteiro item;
	private No esquerda;
	private No direita;
	
	//Construtor:
	No (Inteiro dado){
		
		item = dado;
		esquerda = null;
		direita = null;
	}
	
	
	
	
	public Inteiro getItem() {
		return item;
	}
	public void setItem(Inteiro item) {
		this.item = item;
	}
	public No getEsquerda() {
		return esquerda;
	}
	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}
	public No getDireita() {
		return direita;
	}
	public void setDireita(No direita) {
		this.direita = direita;
	}
	
	
}
