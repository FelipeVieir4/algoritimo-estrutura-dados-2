class ListaDuplamenteEncadeada {

	private Celula primeiro;
	private Celula ultimo;
	private int tamanho;

	public ListaDuplamenteEncadeada() {

		Celula sentinela;

		sentinela = new Celula();

		primeiro = sentinela;
		ultimo = sentinela;
		tamanho = 0;
	}

	public boolean listaVazia() {
		return primeiro == ultimo;
	}

	public void inserirInicio(Serie novo) {

		Celula novaCelula = new Celula(novo);

		primeiro.getProximo().setAnterior(novaCelula);
		novaCelula.setProximo(primeiro.getProximo());
		primeiro.setProximo(novaCelula);
		tamanho++;
	}

	public void inserirFinal(Serie novo) {

		Celula novaCelula;

		novaCelula = new Celula(novo);

		ultimo.setProximo(novaCelula);
		novaCelula.setAnterior(ultimo);

		ultimo = novaCelula;

		tamanho++;
		// System.out.println("listar");
	}

	public Serie removerInicio() {
		Celula removida = primeiro.getProximo();
		removida.getProximo().setAnterior(primeiro);
		primeiro.setProximo(removida.getProximo());
		tamanho--;
		return removida.getItem();
	}

	public Serie removerFinal() throws Exception {

		Celula removida, penultima;

		if (!listaVazia()) {

			removida = ultimo;
			penultima = ultimo.getAnterior();
			penultima.setProximo(null);
			removida.setAnterior(null);

			ultimo = penultima;

			tamanho--;

			return (removida.getItem());
		} else
			throw new Exception("Não foi possível remover o último item da lista: a lista está vazia!");
	}

	// TODO

	public void inserirPosicao(Serie novo, int posicao) {

		Celula aux = primeiro.getProximo();
		Celula novaCelula = new Celula(novo);
		int i = 0;

		while (i != posicao) {
			aux = aux.getProximo();
			i++;
		}
		aux.getAnterior().setProximo(novaCelula);
		novaCelula.setAnterior(aux.getAnterior());
		novaCelula.setProximo(aux);
		aux.setAnterior(novaCelula);
		tamanho++;
	}

	public Serie removerPosicao(int posicao) throws Exception {

		Celula removida = primeiro.getProximo();
		int i = 0;
		if (posicao > 0 && posicao <= tamanho) {

			while (i != posicao) {
				removida = removida.getProximo();
				i++;
			}
			removida.getAnterior().setProximo(removida.getProximo());
			removida.getProximo().setAnterior(removida.getAnterior());
			tamanho--;
			return removida.getItem();
		} else {
			throw new Exception("Posição de remoção invalda!!!");
		}

	}

	public Serie buscar(String nome) throws Exception {

		Celula aux;
		boolean achou = false;
		aux = primeiro;

		do {
			aux.getProximo();
			if (aux.getItem().getNome().equals(nome)) {
				achou = true;
				break;
			}

		} while (aux.getProximo() != null);

		if (achou) {
			return aux.getItem();
		} else {
			throw new Exception("A Série não está na lista");
		}
	}

	public void imprimir() throws Exception {

		Celula aux;
		int posicaoLista = 0;

		if (!listaVazia()) {
			// System.out.println("Conteúdo da lista:");
			aux = primeiro.getProximo();
			while (aux != null) {
				System.out.print("[" + posicaoLista + "]");
				aux.getItem().imprimir();
				aux = aux.getProximo();
				posicaoLista++;
			}
		} else
			throw new Exception("Não foi possível imprimir o conteúdo da lista: a lista está vazia!");
	}
}
