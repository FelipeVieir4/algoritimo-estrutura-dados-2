
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

		try {

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

			// leitura do PUB-IN
			ListaDuplamenteEncadeada minhaLista = new ListaDuplamenteEncadeada();
			String entradaLista = MyIO.readLine();
			while (!entradaLista.equals("FIM")) {
				// System.out.println(entradaLista);
				Serie tempSerie = new Serie();
				int index = tempSerie.pesquisarPosicao(entradaLista, vetorSeries);
				// System.out.println(index);
				tempSerie = vetorSeries[index].clone();
				minhaLista.inserirFinal(tempSerie);
				entradaLista = MyIO.readLine();
			}

			// Tratamento das entradas.

			int tamanhoOperacoes = MyIO.readInt();
			for (int i = 0; i < tamanhoOperacoes; i++) {
				String operacaoLista = MyIO.readString();
				switch (operacaoLista) {
				case "II":
				// operação inserir no inicio
				{
					entradaLista = MyIO.readLine();
					Serie tempSerie = new Serie();
					int index = tempSerie.pesquisarPosicao(entradaLista, vetorSeries);
					tempSerie = vetorSeries[index].clone();

					minhaLista.inserirInicio(tempSerie);
				}
					break;
				case "I*":
				// operação inserir em determinada posição
				{
					int entradaPosicao = MyIO.readInt();
					entradaLista = MyIO.readLine();
					Serie tempSerie = new Serie();
					int index = tempSerie.pesquisarPosicao(entradaLista, vetorSeries);
					tempSerie = vetorSeries[index].clone();

					minhaLista.inserirPosicao(tempSerie, entradaPosicao);
				}
					break;
				case "IF": {
					entradaLista = MyIO.readLine();
					Serie tempSerie = new Serie();
					int index = tempSerie.pesquisarPosicao(entradaLista, vetorSeries);
					tempSerie = vetorSeries[index].clone();

					minhaLista.inserirFinal(tempSerie);
				}
					break;
				case "RI":
					// operação remover do inicio
					Serie removidoInicio = minhaLista.removerInicio();
					System.out.println("(R) " + removidoInicio.getNome());
					break;
				case "R*":
					// operação remover em determinada posição
					int removerIndex = MyIO.readInt();
					Serie removidoPosicao = minhaLista.removerPosicao(removerIndex);
					System.out.println("(R) " + removidoPosicao.getNome());
					break;
				case "RF":
					// remover do final
					Serie removidoFinal = minhaLista.removerFinal();
					System.out.println("(R) " + removidoFinal.getNome());
					break;
				}
			}

			minhaLista.imprimir();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}
}
