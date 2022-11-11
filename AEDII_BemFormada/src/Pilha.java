class Pilha {

	private Celula fundo;
	private Celula topo;
	
	public Pilha() {
		
		Celula sentinela;
		
		sentinela = new Celula('x');
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
	
	public void empilhar(char novo) {
		
		Celula novaCelula;
		
		novaCelula = new Celula(novo);
		novaCelula.setProximo(topo);
		topo = novaCelula;
	}
	
	public char desempilhar() throws Exception {
		
		Celula desempilhado;
		
		if (! pilhaVazia()) {
			desempilhado = topo;
			topo = topo.getProximo();
			desempilhado.setProximo(null);
			return (desempilhado.getItem());
		} else
			throw new Exception("N�o foi poss�vel desempilhar: a pilha est� vazia!");
	}
	
	public char consultarTopo() throws Exception {
		
		if (! pilhaVazia()) {
			return(topo.getItem());
		} else
			throw new Exception("N�o foi poss�vel consultar o topo da pilha: a pilha est� vazia!");
	}
}

