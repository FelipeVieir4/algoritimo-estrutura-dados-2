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
		private Celula anterior;
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

		public Celula getAnterior() {
			return anterior;
		}
		public void setAnterior(Celula anterior) {
			this.anterior = anterior;
		}
}

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
		
		boolean resp;
		
		if (primeiro == ultimo)
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public void inserirFinal(Inteiro novo) {
		
		Celula novaCelula;
		
		novaCelula = new Celula(novo);
		
		ultimo.setProximo(novaCelula);
		novaCelula.setAnterior(ultimo);
		
		ultimo = novaCelula;
		
		tamanho++;
		
	}
	
	public Inteiro removerFinal() throws Exception {
		
		Celula removida, penultima;
		
		if (! listaVazia()) {
			
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
    
    Inteiro novo, removido;
		ListaDuplamenteEncadeada minhaLista;
		
		minhaLista = new ListaDuplamenteEncadeada();
		
		novo = new Inteiro(4);
		minhaLista.inserirFinal(novo);
		
		novo = new Inteiro(11);
		minhaLista.inserirFinal(novo);
		
		novo = new Inteiro(21);
		minhaLista.inserirFinal(novo);
		
		novo = new Inteiro(5);
		minhaLista.inserirFinal(novo);
		
		try {
			minhaLista.imprimir();  // 4 - 11 - 21 - 5
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		try {
			removido = minhaLista.removerFinal();
			System.out.print("Removido: ");
			removido.imprimir();  // 5
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		try {
			removido = minhaLista.removerFinal();
			System.out.print("Removido: ");
			removido.imprimir();  // 21
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		try {
			minhaLista.imprimir();  // 4 - 11
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
  }
}