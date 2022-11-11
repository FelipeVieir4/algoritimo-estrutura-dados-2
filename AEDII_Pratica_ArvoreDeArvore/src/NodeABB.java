public class NodeABB {

	// Atributos:
	private ABB arvore;
	private char key; 
	private NodeABB esquerda = null;
	private NodeABB direita = null;

	// Construtor:
	NodeABB(char caractere) {
		this.key = caractere;
		this.setEsquerda(null);
		this.setDireita(null);
		this.setArvore(new ABB());
	}

	
	// Setters & Getters:
	


	public char getKey() {
		return key;
	}

	public void setKey(char key) {
		this.key = key;
	}

	public NodeABB getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NodeABB esquerda) {
		this.esquerda = esquerda;
	}

	public NodeABB getDireita() {
		return direita;
	}

	public void setDireita(NodeABB direita) {
		this.direita = direita;
	}


	public ABB getArvore() {
		return arvore;
	}


	public void setArvore(ABB arvore) {
		this.arvore = arvore;
	}
}
