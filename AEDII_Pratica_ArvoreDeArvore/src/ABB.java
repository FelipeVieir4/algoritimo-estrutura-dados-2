public class ABB {

	private Node root;

	ABB() {
		this.root = null;
	}

	// M�todo p�blico para usu�rio
	public Serie search(String nomeSerie) throws Exception {
		return search(this.root, nomeSerie);
	}

	// M�todo privado e recursivo
	private Serie search(Node subTreeRoot, String nomeBusca) throws Exception {

		if (subTreeRoot == null) {
			throw new Exception("S�rie n�o encontrada");
		} else if (nomeBusca.compareTo(subTreeRoot.getItem().getNome()) == 0) {
			return subTreeRoot.getItem();
		} else if (nomeBusca.compareTo(subTreeRoot.getItem().getNome()) < 0) {
			return search(subTreeRoot.getEsquerda(), nomeBusca);
		} else {
			return search(subTreeRoot.getDireita(), nomeBusca);
		}
	}

	// M�todo p�blico para inserir
	public void insert(Serie serie) throws Exception {
		this.root = insert(this.root, serie);
	}

	// M�todo privado para inserir
	private Node insert(Node subTreeRoot, Serie serie) throws Exception {

		if (subTreeRoot == null) {
			subTreeRoot = new Node(serie);
		} else if (serie.getNome().compareTo(subTreeRoot.getItem().getNome()) == 0) {
			throw new Exception("N�o foi poss�vel inserir. S�rie j� est� inserida");
		} else if (serie.getNome().compareTo(subTreeRoot.getItem().getNome()) < 0) {
			subTreeRoot.setEsquerda(insert(subTreeRoot.getEsquerda(), serie));
		} else {
			subTreeRoot.setDireita(insert(subTreeRoot.getDireita(), serie));
			;
		}
		return subTreeRoot;
	}

	// M�todo p�blico para imprimir em ordem
	public void inOrderTraveser() {
		inOrderTraveser(this.root);
	}

	// M�todo privado para imprimir em ordem
	private void inOrderTraveser(Node subTreeRoot) {
		if (subTreeRoot != null) {
			inOrderTraveser(subTreeRoot.getEsquerda());
			subTreeRoot.getItem().imprimir();
			inOrderTraveser(subTreeRoot.getDireita());
		}
	}

	// M�todo p�blico para PUB-OUT
	public int pubOut(String nomeSerie) {
		int comparacoes = 0;
		comparacoes = pubOut(this.root, nomeSerie, comparacoes);
		return comparacoes;
	}

	// M�todo privado para PUB-OUT
	private int pubOut(Node subTreeNode, String nomeSerie, int comp) {

		int comparacoes = comp;

		if (subTreeNode == null) {
			comparacoes += 1;
			System.out.printf("NAO \n");
		} else if (nomeSerie.compareTo(subTreeNode.getItem().getNome()) == 0) {
			comparacoes += 2;
			System.out.printf("[%s] - SIM \n", subTreeNode.getItem().getNome());
		} else if (nomeSerie.compareTo(subTreeNode.getItem().getNome()) < 0) {
			comparacoes += 3;
			System.out.printf("[%s] - ", subTreeNode.getItem().getNome());
			pubOut(subTreeNode.getEsquerda(), nomeSerie, comparacoes);
		} else {
			comparacoes += 3;
			System.out.printf("[%s] - ", subTreeNode.getItem().getNome());
			pubOut(subTreeNode.getDireita(), nomeSerie, comparacoes);
		}
		return comparacoes;
	}

	public void remove(String nome) throws Exception {
		remove(this.root, nome);
	}

	private Node remove(Node subTreeRoot, String nome) throws Exception {

		if (subTreeRoot == null) {
			throw new Exception("A S�rie n�o pode ser encontrada");
		} else if (nome.compareTo(subTreeRoot.getItem().getNome()) == 0) {
			if (subTreeRoot.getEsquerda() == null) {
				/*
				 * O filho toma o lugar do pai e a fun��o retorna para o v� o neto
				 */
				subTreeRoot = subTreeRoot.getDireita();
			} else if (subTreeRoot.getDireita() == null) {
				subTreeRoot = subTreeRoot.getEsquerda();
			} else {
				// nesse caso, o n� � de grau 2
				/*
				 * temos que achar o antecessor mais pr�ximo substituir pela key 
				 * que queremos remover e ent�o apagar o antecessor da posi��o antiga.
				 * Ent�o, vamos settar na esqueda do removido a nova subarvore sem o antecessor.
				 * Deve-se buscar na extrema direita da sub�rvore esqueda o valor,
				 * Settar i item do antecessor no n� a ser removido, settar a 
				 * subarvore esqueda para o antecessor e sair retornando tudo.
				 */

				subTreeRoot.setEsquerda(antecessor(subTreeRoot, subTreeRoot.getEsquerda()));
				
			}
		}else if(nome.compareTo(subTreeRoot.getItem().getNome()) < 0) {
			subTreeRoot.setEsquerda(remove(subTreeRoot.getEsquerda(), nome));
		}else {
			subTreeRoot.setDireita(remove(subTreeRoot.getDireita(), nome));
		}
		
		return subTreeRoot;
	}

	private Node antecessor(Node remover, Node subTreeRoot) {
		
		if(subTreeRoot.getDireita() != null) {
			subTreeRoot.setDireita(antecessor(remover, subTreeRoot.getDireita()));
		}else {
			remover.setItem(subTreeRoot.getItem());
			subTreeRoot = subTreeRoot.getEsquerda();
		}
		
		return subTreeRoot;
	}
	
	
	// Setters & Getters
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

}
