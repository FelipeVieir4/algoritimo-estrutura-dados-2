class Pilha {

	private Inteiro pilha[];
	private int topo;
	
	public Pilha(int tamanho) {
		
		pilha = new Inteiro[tamanho];
		topo = 0;
	}
	
	public boolean pilhaCheia() {
	
		boolean resp;
		
		if (topo == pilha.length)
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public boolean pilhaVazia() {
		
		boolean resp;
		
		if (topo == 0)
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public Inteiro desempilhar() throws Exception {
	
		Inteiro desempilhado;
		
		if (! pilhaVazia()) {
			topo--;
			desempilhado = pilha[topo];
			return desempilhado;
		} else
			throw new Exception("Não foi possível desempilhar: a pilha está vazia!");
	}
	
	public void empilhar(Inteiro novo) throws Exception {
		
		if (! pilhaCheia()) {
			pilha[topo] = novo;
			topo++;
		} else
			throw new Exception("Não foi possível empilhar: a pilha está cheia!");
	}
	
	public Inteiro consultarTopo() throws Exception {
		
		if (! pilhaVazia()) {
			return (pilha[topo-1]);
		} else
			throw new Exception("Não foi possível consultar o elemento do topo da pilha: a pilha está vazia!");
	}
}