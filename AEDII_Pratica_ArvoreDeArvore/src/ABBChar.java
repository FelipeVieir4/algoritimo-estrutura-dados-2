public class ABBChar {

	private NodeABB root;

	ABBChar() {
		this.root = null;
	}

	// M�todo p�blico para usu�rio
	public char search(char nomeSerie) throws Exception {
		return search(this.root, nomeSerie);
	}

	// M�todo privado e recursivo
	private char search(NodeABB subTreeRoot, char nomeBusca) throws Exception {

		if (subTreeRoot == null) {
			throw new Exception("S�rie n�o encontrada");
		} else if (nomeBusca == subTreeRoot.getKey()) {
			return subTreeRoot.getKey();
		} else if (nomeBusca < subTreeRoot.getKey()) {
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
	private NodeABB insert(NodeABB subTreeRoot, Serie serie) throws Exception {
		
		char caractere = serie.getNome().charAt(0);
		
		if (subTreeRoot == null) {
			subTreeRoot = new NodeABB(caractere);
			subTreeRoot = insert(subTreeRoot, serie);
		} else if (caractere == subTreeRoot.getKey()) {
			subTreeRoot.getArvore().insert(serie);
		} else if (caractere < subTreeRoot.getKey()) {
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
	private void inOrderTraveser(NodeABB subTreeRoot) {
		if (subTreeRoot != null) {
			inOrderTraveser(subTreeRoot.getEsquerda());
			System.out.print(subTreeRoot.getKey());
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
	private int pubOut(NodeABB subTreeNode, String nomeSerie, int comp) {

		char caractere = nomeSerie.charAt(0);
		int comparacoes = comp;

		if (subTreeNode == null) {
			comparacoes += 1;
			System.out.printf("NAO \n");
		} else if (caractere == subTreeNode.getKey()) {
			comparacoes += 2;
			System.out.printf("%c ", subTreeNode.getKey());
			subTreeNode.getArvore().pubOut(nomeSerie);
		} else if (caractere < subTreeNode.getKey()) {
			comparacoes += 3;
			System.out.printf("%c ", subTreeNode.getKey());
			pubOut(subTreeNode.getEsquerda(), nomeSerie, comparacoes);
		} else {
			comparacoes += 3;
			System.out.printf("%c ", subTreeNode.getKey());
			pubOut(subTreeNode.getDireita(), nomeSerie, comparacoes);
		}
		return comparacoes;
	}

	public void remove(char nome) throws Exception {
		remove(this.root, nome);
	}

	private NodeABB remove(NodeABB subTreeRoot, char nome) throws Exception {

		if (subTreeRoot == null) {
			throw new Exception("A S�rie n�o pode ser encontrada");
		} else if (nome == subTreeRoot.getKey()) {
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
		}else if(nome < subTreeRoot.getKey()) {
			subTreeRoot.setEsquerda(remove(subTreeRoot.getEsquerda(), nome));
		}else {
			subTreeRoot.setDireita(remove(subTreeRoot.getDireita(), nome));
		}
		
		return subTreeRoot;
	}

	private NodeABB antecessor(NodeABB remover, NodeABB subTreeRoot) {
		
		if(subTreeRoot.getDireita() != null) {
			subTreeRoot.setDireita(antecessor(remover, subTreeRoot.getDireita()));
		}else {
			remover.setKey(subTreeRoot.getKey());
			subTreeRoot = subTreeRoot.getEsquerda();
		}
		
		return subTreeRoot;
	}
	
	// Setters & Getters
	public NodeABB getRoot() {
		return root;
	}

	public void setRoot(NodeABB root) {
		this.root = root;
	}

}
