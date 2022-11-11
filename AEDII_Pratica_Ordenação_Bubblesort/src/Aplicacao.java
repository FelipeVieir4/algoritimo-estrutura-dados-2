
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
		String localizacaoArquivo = "C:/temp/data.txt";
		int totalLinhas = totalDeLinhasNoArquivo(localizacaoArquivo);
		Serie[] vetorSeries = new Serie[totalLinhas - 1];

		arqEntrada = new ArquivoTextoLeitura(localizacaoArquivo);
		
		arqEntrada.ler();// desprezando a primeira linha
		// Salvando dataBase do arquivo no vetor.
		for (int i = 0; i < (totalLinhas - 1); i++) {
			vetorSeries[i] = new Serie();
			entrada = arqEntrada.ler();
			vetorSeries[i].ler(entrada);
			//vetorSeries[i].imprimir();
		}

		// iniciando leitura da entrada padrão
		int tamNovoVetor = MyIO.readInt(); //pub-in = 35
		Serie[] novoVetor = new Serie[tamNovoVetor];
		for (int i=0 ; i<tamNovoVetor; i++) {
			String nomeSerieEntrada = MyIO.readLine();
			Serie tempSerie = new Serie();
			int posicao = tempSerie.pesquisarPosicao(nomeSerieEntrada, vetorSeries);
			novoVetor[i] = vetorSeries[posicao].clone();
			//novoVetor[i].imprimir();
		}
		
		// Inicio do Bubblesort:
		// System.out.println("!!!Bubble!!!");
		for (int i = (tamNovoVetor - 1); i > 0; i--) {
			for (int j = 1; j <= i; j++) {
				// Selecionando o atributo duração
				String A1 = novoVetor[j - 1].getDuracao();
				String B1 = novoVetor[j].getDuracao();
				// Testando lexograficamente
				int compareToDuracao = A1.compareTo(B1);
				comparacoes++;
				// Se as durações forem iguais, vou testar o nome
				if (compareToDuracao == 0) {
					A1 = novoVetor[j - 1].getNome();
					B1 = novoVetor[j].getNome();
					int compareToNome = A1.compareTo(B1);
					comparacoes++;
					// ordenando pelo nome
					if (compareToNome > 0) {
						movimentacoes++;
						Serie temp = novoVetor[j - 1];
						novoVetor[j - 1] = novoVetor[j];
						novoVetor[j] = temp;
					}
					// durações forem diferentes, vou ordenar o vetor.
				} else if (compareToDuracao > 0) {
					movimentacoes++;
					Serie temp = novoVetor[j - 1];
					novoVetor[j - 1] = novoVetor[j];
					novoVetor[j] = temp;
				}
			}
		}
		for (int i = 0; i < tamNovoVetor; i++) {
			novoVetor[i].imprimir();
		}
		long elapsed = System.currentTimeMillis() - start;
		
		//Gerar arquivo log.
		//System.out.println("Tempo de execução:" + elapsed + " milissegundos");
		//System.out.println("Comparações: " + comparacoes);
		//System.out.println("Movimentações: " + movimentacoes);
		ArquivoTextoEscrita log = new ArquivoTextoEscrita("754921_bolha.txt");
		log.escrever("Martícula: 754921 " + "\tTempo de execução: " + elapsed + " milissegundos" + 
		"\tComparações: " + comparacoes + "\tMovimentações: " + movimentacoes);
		log.fecharArquivo();
	}
}
