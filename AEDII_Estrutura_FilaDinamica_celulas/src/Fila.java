class Fila {

	private Celula frente;
	private Celula tras;

	public Fila() {

		Celula sentinela;

		sentinela = new Celula();
		frente = sentinela;
		tras = sentinela;
	}

	public boolean filaVazia() {
		return (frente == tras);
	}

	public void enfileirar(Inteiro novo) {

		Celula novaCelula;

		novaCelula = new Celula(novo);

		tras.setProximo(novaCelula);
		tras = novaCelula;
		// tras = tras.getProximo();
	}

	public Inteiro desenfileirar() throws Exception {

		Celula celulaDesenfileirada;
		Celula proximaCelula;

		if (!filaVazia()) {

			celulaDesenfileirada = frente.getProximo();
			proximaCelula = celulaDesenfileirada.getProximo();
			frente.setProximo(proximaCelula);

			if (celulaDesenfileirada == tras) // se a c�lula retirada for a �ltima c�lula da fila
				tras = frente;

			return (celulaDesenfileirada.getItem());
		} else
			throw new Exception("N�o foi poss�vel desenfileirar nenhum item: a fila est� vazia!");
	}

	public void imprimir() throws Exception {

		Celula aux;

		if (!filaVazia()) {
			System.out.println("Conte�do da fila:");

			aux = frente.getProximo();

			while (aux != null) {
				aux.getItem().imprimir();
				aux = aux.getProximo();
			}
		} else
			throw new Exception("N�o foi poss�vel imprimir o conte�do da fila: a fila est� vazia!");
	}
}