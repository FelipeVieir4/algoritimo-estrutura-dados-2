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
			//vetorSeries[i].imprimir();
		}

		// Entrada Padrão
		String entradaNomeSerie = "";
		HashTable table = new HashTable(31);
		entradaNomeSerie = MyIO.readLine();
		do {

			Serie tempSerie = new Serie();

			try {
				int index;
				index = tempSerie.pesquisarPosicao(entradaNomeSerie, vetorSeries);
				tempSerie = vetorSeries[index].clone();
				table.insert(tempSerie);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			entradaNomeSerie = MyIO.readLine();
		} while (!entradaNomeSerie.equals("FIM"));

		// estrada de busca

		String pubin = "";
		int posicao;
		int comparacoes = 0;
		pubin = MyIO.readLine();
		do {

			posicao = table.hash(pubin);

			try {
				comparacoes += table.searchKey(pubin);
				posicao = table.hash(pubin);
				System.out.println(posicao + " SIM");
			} catch (Exception e) {
				System.out.println("NAO");
			}
			
			pubin = MyIO.readLine();
		} while (!pubin.equals("FIM"));

		long elapsed = System.currentTimeMillis() - start;
		
		//Arquivo log
		ArquivoTextoEscrita log = new ArquivoTextoEscrita("754921_arvoreBinaria.txt");
		log.escrever("Martículas: 754921, 712376, 748873, 756849 " + "\tTempo de execução: " + elapsed + " milissegundos" + 
		"\tComparações: " + comparacoes);
		log.fecharArquivo();
	}
}