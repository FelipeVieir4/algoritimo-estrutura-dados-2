public class Node {

	// Atributos:
	private Serie item;
	private Node esquerda = null;
	private Node direita = null;

	// Construtor:
	Node(Serie dado) {
		this.setItem(dado);
		this.setEsquerda(null);
		this.setDireita(null);
	}
	
	
	// Setters & Getters:
	public Serie getItem() {
		return item;
	}

	public void setItem(Serie item) {
		this.item = item;
	}

	public Node getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Node esquerda) {
		this.esquerda = esquerda;
	}

	public Node getDireita() {
		return direita;
	}

	public void setDireita(Node direita) {
		this.direita = direita;
	}


	
}
