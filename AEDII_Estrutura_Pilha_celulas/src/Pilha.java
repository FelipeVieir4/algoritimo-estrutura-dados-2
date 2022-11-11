class Pilha {

	private Celula fundo;
	private Celula topo;
	
	public Pilha() {
		
		Celula sentinela;
		
		sentinela = new Celula();
		fundo = sentinela;
		topo = sentinela;
	}
	
	public boolean pilhaVazia() {
	
		boolean resp;
		
		if (topo == fundo)
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public void empilhar(Inteiro novo) {
		
		Celula novaCelula;
		
		novaCelula = new Celula(novo);
		novaCelula.setProximo(topo);
		topo = novaCelula;
	}
	
	public Inteiro desempilhar() throws Exception {
		
		Celula desempilhado;
		
		if (! pilhaVazia()) {
			desempilhado = topo;
			topo = topo.getProximo();
			desempilhado.setProximo(null);
			return (desempilhado.getItem());
		} else
			throw new Exception("Não foi possível desempilhar: a pilha está vazia!");
	}
	
	public Inteiro consultarTopo() throws Exception {
		
		if (! pilhaVazia()) {
			return(topo.getItem());
		} else
			throw new Exception("Não foi possível consultar o topo da pilha: a pilha está vazia!");
	}
}

