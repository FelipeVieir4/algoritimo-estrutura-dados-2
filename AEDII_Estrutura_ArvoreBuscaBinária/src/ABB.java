public class ABB {

	private No raiz;

	// Construtor:
	ABB() {
		raiz = null;
	}

	// Métodos

	// pesquisar na árvore.
	/*
	 * o Natural é ter um método público para o usuário informar uma chave a ser
	 * buscada na árvore. Então, o método público chama o método recursivo privado
	 * passando a chave informada pelo usuário e a árvore de busca.
	 */

	// BUSCA:
	// Método público não recursivo
	public Inteiro pesquisar(int chave) throws Exception {
		return pesquisar(this.raiz, chave);
	}

	// Método privado recursivo que retorna para o método público.
	private Inteiro pesquisar(No raizSubarvore, int chave) throws Exception {
		/*
		 * Condições 1 Raiz ser nula; 2 Raiz ser igual a chave; 3 Raiz ser maior que a
		 * chave; 4 Raiz ser menor que a chave
		 */
		if (raizSubarvore == null) {
			throw new Exception("Chave não encontrada!");
		} else if (raizSubarvore.getItem().getValor() == chave) {
			return raizSubarvore.getItem();
		} else if (chave > raizSubarvore.getItem().getValor()) {
			return pesquisar(raizSubarvore.getDireita(), chave);
		} else {
			return pesquisar(raizSubarvore.getEsquerda(), chave);
		}
	}

	// INSERÇÃO
	// Método público que o usuário irá utilizar.
	public void inserir(Inteiro dado) throws Exception {
		this.raiz = inserir(this.raiz, dado);
	}

	private No inserir(No raizSubarvore, Inteiro dado) throws Exception {
		/*
		 * Condições: 1 Raiz vazia aponta para a chave; 2 Raiz ser igual a chave, então
		 * a chabe já foi inserida; 3 Raiz ser menor, settar valor na direita; 4 Raiz
		 * ser maior, settar valro na esquerda; TEM QUE RETORNAR A SUBARVORE PARA
		 * COMPLETAR O MÉTODO RECURSIVO
		 */

		if (raizSubarvore == null) {
			raizSubarvore = new No(dado);
		} else if (raizSubarvore.getItem().getValor() == dado.getValor()) {
			throw new Exception("Não foi possível inserir o elemento, valor já está na árvore");
		} else if (dado.getValor() < raizSubarvore.getItem().getValor()) {
			raizSubarvore.setEsquerda(inserir(raizSubarvore.getEsquerda(), dado));
		} else {
			raizSubarvore.setDireita(inserir(raizSubarvore.getDireita(), dado));
		}
		return raizSubarvore;
	}

	public void remover(int chaveRemover) throws Exception {
		this.raiz = remover(this.raiz, chaveRemover);
	}

	// ESTUDAR E REVISAR
	private No remover(No raizSubarvore, int chaveRemover) throws Exception {

		if (raizSubarvore == null) {
			throw new Exception("Não foi possível remover o item da árvore: chave não encontrada!");
		} else if (chaveRemover == raizSubarvore.getItem().getValor()) {
			// Bloco para nós com grau 0 ou 1
			if (raizSubarvore.getEsquerda() == null) // Nó com um filho a direita
				raizSubarvore = raizSubarvore.getDireita(); // raiz recebe o filho e retorna subarvore
			else if (raizSubarvore.getDireita() == null) // Nó com um filho a esqueda
				raizSubarvore = raizSubarvore.getEsquerda(); // raiz recebe o filho e retorna subarvore
			// para as folhas os codigos acima se aplicam também, poís o valor retornado
			// será o null.
			else
				// Bloco para nó de grau 2
				raizSubarvore.setEsquerda(antecessor(raizSubarvore, raizSubarvore.getEsquerda()));
		} else if (chaveRemover > raizSubarvore.getItem().getValor()) // indo para a direita.
			raizSubarvore.setDireita(remover(raizSubarvore.getDireita(), chaveRemover));
		else// indo para a esqueda.
			raizSubarvore.setEsquerda(remover(raizSubarvore.getEsquerda(), chaveRemover));

		return raizSubarvore;
	}

	private No antecessor(No noRetirar, No raizSubarvore) {

		if (raizSubarvore.getDireita() != null)
			// procurando o valor mais a direita na subarvore esqueda.
			raizSubarvore.setDireita(antecessor(noRetirar, raizSubarvore.getDireita()));
		else {
			noRetirar.setItem(raizSubarvore.getItem());
			/*
			 * Caso o valor mais a direita seja grau 1, deve-se retornar o valor para que
			 * onó seja eliminado da posição
			 */
			raizSubarvore = raizSubarvore.getEsquerda();
		}

		return raizSubarvore;
	}

	// IMPRIMIR:
	public void caminhamentoEmOrdem() {
		imprimirEmOrdem(this.raiz);
	}

	// ordem crescente
	private void imprimirEmOrdem(No raizSubarvore) {
		if (raizSubarvore != null) {
			imprimirEmOrdem(raizSubarvore.getEsquerda());
			raizSubarvore.getItem().imprimir();
			imprimirEmOrdem(raizSubarvore.getDireita());
		}
	}

	// Primeiro a raiz depois menor e depois o maior (raiz, esq, dir)
	public void imprimirPreOrdem() {
		imprimirPreOrdem(this.raiz);
	}

	private void imprimirPreOrdem(No raizSubarvore) {
		if (raizSubarvore != null) {
			raizSubarvore.getItem().imprimir();
			imprimirPreOrdem(raizSubarvore.getEsquerda());
			imprimirPreOrdem(raizSubarvore.getDireita());
		}
	}

	// Primeiro a esqueta, direita e depois raiz
	public void imprimirPosOrdem() {
		imprimirPosOrdem(this.raiz);
	}

	private void imprimirPosOrdem(No raizSubarvore) {
		if (raizSubarvore != null) {
			imprimirPosOrdem(raizSubarvore.getEsquerda());
			imprimirPosOrdem(raizSubarvore.getDireita());
			raizSubarvore.getItem().imprimir();
		}
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

}
