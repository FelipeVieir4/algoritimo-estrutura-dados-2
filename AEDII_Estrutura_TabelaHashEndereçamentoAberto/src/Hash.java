
public class Hash {

	private Inteiro tabelaHash[];
	private int M;

	Hash(int tamanho) {
		this.M = tamanho;
		tabelaHash = new Inteiro[M];

		for (int i = 0; i < M; i++) {
			tabelaHash[i] = null;
		}
	}

	private int funcaoHash(int chave, int tentativas) {
		return (((chave % M) + tentativas) % M);
	}

	public void inserir(Inteiro novo) throws Exception {

		int posicao, tentativas;
		boolean inseriu = false;

		tentativas = 0;

		while (!inseriu && (tentativas < M)) {

			posicao = funcaoHash(novo.getValor(), tentativas);

			if (tabelaHash[posicao] == null) {
				tabelaHash[posicao] = novo;
				inseriu = true;
			} else if (tabelaHash[posicao].getValor() == novo.getValor()) {
				throw new Exception("Não foi possível inserir o elemento: chave duplicada");
			} else {
				tentativas++;
			}

		}
		if (!inseriu) {
			throw new Exception("Não foi possível inserir");
		}
	}

	public Inteiro pesquisar(int chave) throws Exception {

		int posicao, tentativas;

		tentativas = 0;

		posicao = funcaoHash(chave, tentativas);

		while (tentativas < M) {
			if (tabelaHash[posicao] == null) {
				throw new Exception("Pesquisa sem sucesso! Chave não encontrada");
			} else if (tabelaHash[posicao].getValor() == chave) {
				return tabelaHash[posicao];
			} else {
				tentativas++;
			}
		}
		throw new Exception("Pesquisa sem sucesso! Chave não encontrada");
	}
}
