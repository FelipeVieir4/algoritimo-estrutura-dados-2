public class Hash {

	private ListaEncadeada tabelaHash[];
	private int M;

	Hash(int tamanho) {
		this.M = tamanho;
		tabelaHash = new ListaEncadeada[M];
		for (int i = 0; i < M; i++) {
			tabelaHash[i] = new ListaEncadeada();
		}
	}

	private int funcaoHash(int chave) {
		return (chave % M);
	}

	public void inserir(Inteiro novo) throws Exception {
		int posicao;
		posicao = funcaoHash(novo.getValor());
		tabelaHash[posicao].inserir(novo, 0);
	}

	public Inteiro pesquisar(int chave) throws Exception {
		int posicao;
		posicao = funcaoHash(chave);
		return tabelaHash[posicao].pesquisar(chave);
	}

	public void imprimir() {
		for (int i = 0; i < M; i++) {
			System.out.println("Posicão:" + i);
			try {
				tabelaHash[i].imprimir();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
