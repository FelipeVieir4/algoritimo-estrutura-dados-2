
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

		ArquivoTextoLeitura arqEntrada;
		String entrada;
		String localizacaoArquivo = "C:/temp/data.txt";
		int totalLinhas = totalDeLinhasNoArquivo(localizacaoArquivo);
		Serie[] vetorSeries = new Serie[totalLinhas - 1];


		arqEntrada = new ArquivoTextoLeitura(localizacaoArquivo);
		arqEntrada.ler();// desprezando a primeira linha

		//Salvando dataBase do arquivo no vetor.
		for (int i = 0; i < (totalLinhas - 1); i++) {
			vetorSeries[i] = new Serie();
			entrada = arqEntrada.ler();
			vetorSeries[i].ler(entrada);
			vetorSeries[i].imprimir();
		}
		
		
		
		/*
		//iniciando pesquisa
		do {
			Serie temSerie = new Serie();
			nomeSeriePesquisa = MyIO.readLine();
			temSerie.pesquisar(nomeSeriePesquisa, vetorSeries);
		} while (!nomeSeriePesquisa.equals("FIM"));*/
	}
}

