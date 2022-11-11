
public class Aplicacao {

	public static int totalDeLinhasNoArquivo(String locArq) {

		ArquivoTextoLeitura arqEntrada = new ArquivoTextoLeitura(locArq);// abrindo arquivo
		String entrada;
		int totalLinhas = 0;

		entrada = arqEntrada.ler();// lendo primeira linha
		while (entrada != null) {
			totalLinhas++; // contando
			entrada = arqEntrada.ler();// continua leitura
		}
		arqEntrada.fecharArquivo();// fecha arquivo
		return totalLinhas;
	}

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		int comparacoes = 0;
		int movimentacoes = 0;
		ArquivoTextoLeitura arqEntrada;
		String entrada;
		String localizacaoArquivo = "C:/tmp/data.txt";
		int totalLinhas = totalDeLinhasNoArquivo(localizacaoArquivo);
		Serie[] vetorSeries = new Serie[totalLinhas - 1];

		arqEntrada = new ArquivoTextoLeitura(localizacaoArquivo);

		arqEntrada.ler();// desprezando a primeira linha
		// Salvando dataBase do arquivo no vetor.
		for (int i = 0; i < (totalLinhas - 1); i++) {
			vetorSeries[i] = new Serie();
			entrada = arqEntrada.ler();
			vetorSeries[i].ler(entrada);
			// vetorSeries[i].imprimir();
		}

		// iniciando leitura da entrada padr�o
		int tamNovoVetor = MyIO.readInt(); // pub-in
		Serie[] novoVetor = new Serie[tamNovoVetor];
		for (int i = 0; i < tamNovoVetor; i++) {
			String nomeSerieEntrada = MyIO.readLine();
			Serie tempSerie = new Serie();
			int posicao = tempSerie.pesquisarPosicao(nomeSerieEntrada, vetorSeries);
			novoVetor[i] = vetorSeries[posicao].clone();
			// novoVetor[i].imprimir();
		}

		// inicio ordena��o por Inser��o por nome
		for (int i = 1; i < tamNovoVetor; i++) {
			Serie tmp = novoVetor[i];
			int j = i - 1;

			while ((j >= 0) && (tmp.getNome().compareTo(novoVetor[j].getNome()) < 0)) {
				comparacoes++;
				novoVetor[j + 1] = novoVetor[j];
				movimentacoes++;
				j--;
			}
			novoVetor[j + 1] = tmp;
		}
		
		
		// inicio ordena��o por Inser��o por emissora
		for (int i = 1; i < tamNovoVetor; i++) {
			Serie tmp = novoVetor[i];
			int j = i - 1;

			while ((j >= 0) && (tmp.getEmissoraTvOriginal().compareTo(novoVetor[j].getEmissoraTvOriginal()) < 0)) {
				comparacoes++;
				novoVetor[j + 1] = novoVetor[j];
				movimentacoes++;
				j--;
			}
			novoVetor[j + 1] = tmp;
		}
		

		for (int i = 0; i < tamNovoVetor; i++) {
			novoVetor[i].imprimir();
		}

		long elapsed = System.currentTimeMillis() - start;

		// Gerar arquivo log.
		// System.out.println("Tempo de execu��o:" + elapsed + " milissegundos");
		// System.out.println("Compara��es: " + comparacoes);
		// System.out.println("Movimenta��es: " + movimentacoes);
		ArquivoTextoEscrita log = new ArquivoTextoEscrita("754921_inser��o.txt");
		log.escrever("Mart�cula: 754921 " + "\tTempo de execu��o: " + elapsed + " milissegundos" + "\tCompara��es: "
				+ comparacoes + "\tMovimenta��es: " + movimentacoes);
		log.fecharArquivo();
	}
}
