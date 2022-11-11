class AVL {

	private No raiz;
	
	public AVL() {
		
		raiz = null;
	}
	
	// chave: 19
	public Inteiro pesquisar(int chave) {
		return pesquisar(this.raiz, chave);
	}
	
	// 1.a execu��o:
	// raizSubarvore: 16
	// chave: 19
	// retorna o resultado da 2.a execu��o do m�todo pesquisar: 19
	// 2.a execu��o:
	// raizSubarvore: 23
	// chave: 19
	// retorna o resultado da 3.a execu��o do m�todo pesquisar: 19
	// 3.a execu��o:
	// raizSubarvore: 19
	// chave: 19
	// retorna: 19
	private Inteiro pesquisar(No raizSubarvore, int chave) {
		
		if (raizSubarvore == null)
			return null;
		else if (chave == raizSubarvore.getItem().getValor())
			return raizSubarvore.getItem();
		else if (chave > raizSubarvore.getItem().getValor())
			return pesquisar(raizSubarvore.getDireita(), chave);
		else
			return pesquisar(raizSubarvore.getEsquerda(), chave);
	}
	
	// novo: 11
	// atribuir � raiz da �rvore o retorno da 1.a execu��o do m�todo inserir: 16
	public void inserir(Inteiro novo) throws Exception {
		this.raiz = inserir(this.raiz, novo);
	}
	
	// 1.a execu��o:
	// raizSubarvore: 16
	// novo: 11
	// atribuir � sub�rvore esquerda do 16 o retorno da 2.a execu��o do m�todo inserir: 8
	// retorno: 16
	// 2.a execu��o:
	// raizSubarvore: 8
	// novo: 11
	// atribuir � sub�rvore direita do 8 o retorno da 3.a execu��o do m�todo inserir: 11
	// retorno: 8
	// 3.a execu��o:
	// raizSubarvore: null
	// novo: 11
	// retorno: 11
	private No inserir(No raizSubarvore, Inteiro novo) throws Exception{
		
		if (raizSubarvore == null)
			raizSubarvore = new No(novo);
		else if (novo.getValor() == raizSubarvore.getItem().getValor())
			throw new Exception("N�o foi poss�vel inserir o item na �rvore: chave j� inseriada anteriormente!");
		else if (novo.getValor() < raizSubarvore.getItem().getValor())
			raizSubarvore.setEsquerda(inserir(raizSubarvore.getEsquerda(), novo));
		else
			raizSubarvore.setDireita(inserir(raizSubarvore.getDireita(), novo));
			
		return balancear(raizSubarvore);
	}
	
	private No balancear(No raizSubarvore) {
		
		int fatorBalanceamento;
		int fatorBalanceamentoFilho;
		
		fatorBalanceamento = raizSubarvore.getFatorBalanceamento();
		
		if (fatorBalanceamento == 2) {
			// �rvore desbalanceada para a esquerda.
			fatorBalanceamentoFilho = raizSubarvore.getEsquerda().getFatorBalanceamento();
			if (fatorBalanceamentoFilho == -1) {
				// rota��o dupla.
				// rota��o do filho � esquerda.
				raizSubarvore.setEsquerda(rotacionarEsquerda(raizSubarvore.getEsquerda()));
			}
			// rota��o � direita.
			raizSubarvore = rotacionarDireita(raizSubarvore);
		} else if (fatorBalanceamento == -2) {
			// �rvore desbalanceada para a direita.
			fatorBalanceamentoFilho = raizSubarvore.getDireita().getFatorBalanceamento();
			if (fatorBalanceamentoFilho == 1) {
				// rota��o dupla.
				// rota��o do filho � direita.
				raizSubarvore.setDireita(rotacionarDireita(raizSubarvore.getDireita()));
			}
			// rota��o � esquerda.
			raizSubarvore = rotacionarEsquerda(raizSubarvore);
		} else
			raizSubarvore.setAltura();
		
		return raizSubarvore;
	}
	
	private No rotacionarDireita(No p) {
		
		No u = p.getEsquerda();
		No filhoEsquerdaDireita = u.getDireita();  // tri�ngulo vermelho
		
		u.setDireita(p);
		p.setEsquerda(filhoEsquerdaDireita);
		
		p.setAltura();
		u.setAltura();
	
		return u;
	}
	
	private No rotacionarEsquerda(No p) {
		
		No z = p.getDireita();
		No filhoDireitaEsquerda = z.getEsquerda();  // tri�ngulo vermelho
		
		z.setEsquerda(p);
		p.setDireita(filhoDireitaEsquerda);
		
		p.setAltura();
		z.setAltura();
		
		return z;
	}
	
	// chaveRemover: 19
	// raiz = retorno da 1.a execu��o do m�todo remover --> 16
	public void remover(int chaveRemover) throws Exception {
		this.raiz = remover(this.raiz, chaveRemover);
	}
	
	// 1.a execu��o:
	// raizSubarvore: 16
	// chaveRemover: 19
	// sub�rvore � direita do 16 = retorno da 2.a execu��o do m�todo remover --> 23
	// retorna: 16
	// 2.a execu��o:
	// raizSubarvore: 23
	// chaveRemover: 19
	// sub�rvore � esquerda do 23 = retorno da 3.a execu��o do m�todo remover --> null
	// retorna: 23
	// 3.a execu��o:
	// raizSubarvore: 19
	// chaveRemover: 19
	// retorna: null
	private No remover(No raizSubarvore, int chaveRemover) throws Exception {
		
		if (raizSubarvore == null)
			throw new Exception("N�o foi poss�vel remover o item da �rvore: chave n�o encontrada!");
		else if (chaveRemover == raizSubarvore.getItem().getValor()) {
			if (raizSubarvore.getEsquerda() == null)
				raizSubarvore = raizSubarvore.getDireita();
			else if (raizSubarvore.getDireita() == null)
				raizSubarvore = raizSubarvore.getEsquerda();
			else
				raizSubarvore.setEsquerda(antecessor(raizSubarvore, raizSubarvore.getEsquerda()));
		} else if (chaveRemover > raizSubarvore.getItem().getValor())
			raizSubarvore.setDireita(remover(raizSubarvore.getDireita(), chaveRemover));
		else
			raizSubarvore.setEsquerda(remover(raizSubarvore.getEsquerda(), chaveRemover));
			
		return balancear(raizSubarvore);
	}
	
	private No antecessor(No noRetirar, No raizSubarvore) {
		
		if (raizSubarvore.getDireita() != null)
			raizSubarvore.setDireita(antecessor(noRetirar, raizSubarvore.getDireita()));
		else {
			noRetirar.setItem(raizSubarvore.getItem());
			raizSubarvore = raizSubarvore.getEsquerda();
		}	
		
		return balancear(raizSubarvore);
	}
	
	public void caminhamentoEmOrdem() {
		caminhamentoEmOrdem(this.raiz);
	}
	
	// 1.a execu��o: raizSubarvore: 16
	// parou imprimindo a sub�rvore esquerda
	// 2.a execu��o: raizSubarvore: 8
	// parou imprimindo a sub�rvore direita
	// 3.a execu��o: raizSubarvore: 4
	// parou imprimindo a sub�rvore direita --> finalizada
	// 4.a execu��o: raizSubarvore: null --> finalizada
	// 5.a execu��o: raizSubarvore: 5
	// parou imprimindo a sub�rvore direita --> finalizada
	// 6.a execu��o: raizSubarvore: null --> finalizada
	// 7.a execu��o: raizSubarvore: null --> finalizada
	// 8.a execu��o: raizSubarvore: 11
	private void caminhamentoEmOrdem(No raizSubarvore) {
		
		if (raizSubarvore != null) {
			caminhamentoEmOrdem(raizSubarvore.getEsquerda());
			raizSubarvore.getItem().imprimir();
			caminhamentoEmOrdem(raizSubarvore.getDireita());
		}
	}
}
