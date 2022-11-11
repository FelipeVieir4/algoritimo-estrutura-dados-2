class Inteiro {

	private int valor;

	public Inteiro() {
		valor = 0;
	}
	
	public Inteiro(int i) {
		valor = i;
	} 
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public void imprimir() {
		System.out.println("Valor: " + this.valor);
	}
}

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
			
			if (posicao == tamanho)  // a inserção ocorreu na última posição da lista
				ultimo = novaCelula;
			
			tamanho++;
			
		} else
			throw new Exception("Não foi possível inserir o item na lista: a posição informada é inválida!");
	}
	
	public Inteiro remover(int posicao) throws Exception {
		
		Celula anterior, celulaRemovida, proximaCelula;
		
		if (! listaVazia()) {
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
		
		if (! listaVazia()) {
			System.out.println("Conteúdo da lista:");
			
			aux = primeiro.getProximo();
			while (aux != null) {
				aux.getItem().imprimir();
				aux = aux.getProximo();
			}
		} else
			throw new Exception("Não foi possível imprimir o conteúdo da lista: a lista está vazia!");
	}
}

class Main {
  public static void main(String[] args) {

    ListaEncadeada minhaLista;
		Inteiro novo, removido;
		
		minhaLista = new ListaEncadeada();
		
		novo = new Inteiro(1);
		try {
			minhaLista.inserir(novo, 0);  // 1
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		novo = new Inteiro(11);
		try {
			minhaLista.inserir(novo, 0);  // 11 - 1
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		novo = new Inteiro(21);
		try {
			minhaLista.inserir(novo, 3);  // 11 - 1
		} catch (Exception erro) {
			System.out.println(erro.getMessage());  // Essa mensagem de erro deve ser exibida.
		}
		
		novo = new Inteiro(21);
		try {
			minhaLista.inserir(novo, 2);  // 11 - 1 - 21
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		novo = new Inteiro(4);
		try {
			minhaLista.inserir(novo, 2);  // 11 - 1 - 4 - 21
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		try {
			minhaLista.imprimir();  // 11 - 1 - 4 - 21
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		try {
			removido = minhaLista.remover(1);
			System.out.print("Item removido: ");  // 1
			removido.imprimir();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		try {
			minhaLista.imprimir();  // 11 - 4 - 21
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		try {
			removido = minhaLista.remover(3);
			System.out.print("Item removido: ");
			removido.imprimir();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());  // Essa mensagem deve ser exibida.
		}
		
		try {
			removido = minhaLista.remover(1);
			System.out.print("Item removido: ");  // 4
			removido.imprimir();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		try {
			minhaLista.imprimir();  // 11 - 21
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
  }
}