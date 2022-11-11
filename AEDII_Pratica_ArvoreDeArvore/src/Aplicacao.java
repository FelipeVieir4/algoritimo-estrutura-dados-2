public class Aplicacao {

	/*------Método para contar quantidade de linhas da base de dados-------------*/
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

	/*------Método para encontrar uma posição de uma série no vetor-------------*/
	public static int pesquisarPosicao(String nomePesquisa, Serie vetor[]) throws Exception {

		for (int i = 0; i < vetor.length; i++) {
			if (nomePesquisa.equals(vetor[i].getNome())) {
				return i;
			}
		}
		throw new Exception("Posição não encontrada: A Série não está na base de dados");
	}

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		ArquivoTextoLeitura arqEntrada;
		String entrada;
		String localizacaoArquivo = "C:/tmp/data.txt";
		int totalLinhas = totalDeLinhasNoArquivo(localizacaoArquivo);
		Serie[] vetorSeries = new Serie[totalLinhas - 1];

		arqEntrada = new ArquivoTextoLeitura(localizacaoArquivo);// Abrindo o arquivo

		arqEntrada.ler();// desprezando a primeira linha
		// Salvando dataBase do arquivo no vetor.
		for (int i = 0; i < (totalLinhas - 1); i++) {
			vetorSeries[i] = new Serie();
			entrada = arqEntrada.ler();
			vetorSeries[i].ler(entrada);
			// vetorSeries[i].imprimir();
		}
		arqEntrada.fecharArquivo();// Fechando o arquivo

		
		//Tratamento do PUB-IN
		String nomeSerieEntrada = "";

		int posicaoSerieVetor = 0;
		ABBChar minhaArvoreSeries = new ABBChar();
		int comparacoes = 0;
		nomeSerieEntrada = MyIO.readLine();
		do {
				try {
					posicaoSerieVetor = pesquisarPosicao(nomeSerieEntrada, vetorSeries);
					minhaArvoreSeries.insert(vetorSeries[posicaoSerieVetor]);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				nomeSerieEntrada = MyIO.readLine();
		} while (!nomeSerieEntrada.equals("FIM"));
		
	
		
		//Tratamento para PUB-OUT
		String nomeSeriePesquisa = "";
		
		nomeSeriePesquisa = MyIO.readLine();
		do {
			comparacoes = comparacoes + minhaArvoreSeries.pubOut(nomeSeriePesquisa);
			nomeSeriePesquisa = MyIO.readLine();
		}while(!nomeSeriePesquisa.equals("FIM"));
		
		

		/*
		//Estudo do método para remover
		
		String nomeSerieRemover = "";
		
		nomeSerieRemover = MyIO.readLine();
		do {
			try {
				minhaArvoreSeries.remove(nomeSerieRemover);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			nomeSerieRemover = MyIO.readLine();
		}while(!nomeSerieRemover.equals("FIM"));
		
		System.out.println("Depois que removi");
		minhaArvoreSeries.inOrderTraveser();
		*/
		
		
		long elapsed = System.currentTimeMillis() - start;
		
		//Arquivo log
		ArquivoTextoEscrita log = new ArquivoTextoEscrita("754921_arvoreArvore.txt");
		log.escrever("Martículas: 754921, 712376, 748873, 756849 " + "\tTempo de execução: " + elapsed + " milissegundos" + 
		"\tComparações: " + comparacoes);
		log.fecharArquivo();
	}
}
