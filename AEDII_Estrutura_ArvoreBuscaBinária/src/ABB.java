public class ABB {

	private No raiz;

	// Construtor:
	ABB() {
		raiz = null;
	}

	// M�todos

	// pesquisar na �rvore.
	/*
	 * o Natural � ter um m�todo p�blico para o usu�rio informar uma chave a ser
	 * buscada na �rvore. Ent�o, o m�todo p�blico chama o m�todo recursivo privado
	 * passando a chave informada pelo usu�rio e a �rvore de busca.
	 */

	// BUSCA:
	// M�todo p�blico n�o recursivo
	public Inteiro pesquisar(int chave) throws Exception {
		return pesquisar(this.raiz, chave);
	}

	// M�todo privado recursivo que retorna para o m�todo p�blico.
	private Inteiro pesquisar(No raizSubarvore, int chave) throws Exception {
		/*
		 * Condi��es 1 Raiz ser nula; 2 Raiz ser igual a chave; 3 Raiz ser maior que a
		 * chave; 4 Raiz ser menor que a chave
		 */
		if (raizSubarvore == null) {
			throw new Exception("Chave n�o encontrada!");
		} else if (raizSubarvore.getItem().getValor() == chave) {
			return raizSubarvore.getItem();
		} else if (chave > raizSubarvore.getItem().getValor()) {
			return pesquisar(raizSubarvore.getDireita(), chave);
		} else {
			return pesquisar(raizSubarvore.getEsquerda(), chave);
		}
	}

	// INSER��O
	// M�todo p�blico que o usu�rio ir� utilizar.
	public void inserir(Inteiro dado) throws Exception {
		this.raiz = inserir(this.raiz, dado);
	}

	private No inserir(No raizSubarvore, Inteiro dado) throws Exception {
		/*
		 * Condi��es: 1 Raiz vazia aponta para a chave; 2 Raiz ser igual a chave, ent�o
		 * a chabe j� foi inserida; 3 Raiz ser menor, settar valor na direita; 4 Raiz
		 * ser maior, settar valro na esquerda; TEM QUE RETORNAR A SUBARVORE PARA
		 * COMPLETAR O M�TODO RECURSIVO
		 */

		if (raizSubarvore == null) {
			raizSubarvore = new No(dado);
		} else if (raizSubarvore.getItem().getValor() == dado.getValor()) {
			throw new Exception("N�o foi poss�vel inserir o elemento, valor j� est� na �rvore");
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
			throw new Exception("N�o foi poss�vel remover o item da �rvore: chave n�o encontrada!");
		} else if (chaveRemover == raizSubarvore.getItem().getValor()) {
			// Bloco para n�s com grau 0 ou 1
			if (raizSubarvore.getEsquerda() == null) // N� com um filho a direita
				raizSubarvore = raizSubarvore.getDireita(); // raiz recebe o filho e retorna subarvore
			else if (raizSubarvore.getDireita() == null) // N� com um filho a esqueda
				raizSubarvore = raizSubarvore.getEsquerda(); // raiz recebe o filho e retorna subarvore
			// para as folhas os codigos acima se aplicam tamb�m, po�s o valor retornado
			// ser� o null.
			else
				// Bloco para n� de grau 2
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
			 * on� seja eliminado da posi��o
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
