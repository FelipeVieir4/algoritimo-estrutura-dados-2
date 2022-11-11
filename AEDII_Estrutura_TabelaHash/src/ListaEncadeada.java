class ListaEncadeada {

	private Celula primeiro;
	private Celula ultimo;
	private int tamanho;

	public ListaEncadeada() {

		Celula sentinela = new Celula();

		primeiro = sentinela;
		ultimo = sentinela;
		tamanho = 0;
	}

	public boolean listaVazia() {

		boolean resp;

		if (primeiro == ultimo)
			resp = true;
		else
			resp = false;

		return resp;
	}

	public void inserir(Inteiro novo, int posicao) throws Exception {

		Celula anterior, novaCelula, proximaCelula;

		if ((posicao >= 0) && (posicao <= tamanho)) {
			anterior = primeiro;
			for (int i = 0; i < posicao; i++)
				anterior = anterior.getProximo();

			novaCelula = new Celula(novo);

			proximaCelula = anterior.getProximo();

			anterior.setProximo(novaCelula);
			novaCelula.setProximo(proximaCelula);

			if (posicao == tamanho) // a inserção ocorreu na última posição da lista
				ultimo = novaCelula;

			tamanho++;

		} else
			throw new Exception("Não foi possível inserir o item na lista: a posição informada é inválida!");
	}

	public Inteiro remover(int posicao) throws Exception {

		Celula anterior, celulaRemovida, proximaCelula;

		if (!listaVazia()) {
			if ((posicao >= 0) && (posicao < tamanho)) {
				anterior = primeiro;
				for (int i = 0; i < posicao; i++)
					anterior = anterior.getProximo();

				celulaRemovida = anterior.getProximo();

				proximaCelula = celulaRemovida.getProximo();

				anterior.setProximo(proximaCelula);
				celulaRemovida.setProximo(null);

				if (celulaRemovida == ultimo)
					ultimo = anterior;

				tamanho--;

				return (celulaRemovida.getItem());
			} else
				throw new Exception("Não foi possível remover o item da lista: a posição informada é inválida!");
		} else
			throw new Exception("Não foi possível remover o item da lista: a lista está vazia!");
	}

	public void imprimir() throws Exception {

		Celula aux;

		if (!listaVazia()) {
			System.out.println("Conteúdo da lista:");

			aux = primeiro.getProximo();
			while (aux != null) {
				aux.getItem().imprimir();
				aux = aux.getProximo();
			}
		} else
			throw new Exception("Não foi possível imprimir o conteúdo da lista: a lista está vazia!");
	}

	public Inteiro pesquisar(int chave) throws Exception {
		Celula aux;
		if (listaVazia()) {
			throw new Exception("A lista está vaxia");
		} else {
			aux = primeiro.getProximo();
			while (aux != null) {
				if (aux.getItem().getValor() == chave) {
					return aux.getItem();
				}
				aux = aux.getProximo();
			}
			throw new Exception("Chave não encontrada");
		}
	}
}
