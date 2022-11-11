
public class FilaVetor {

	private Inteiro[] fila;
	private int frente;
	private int tras;
	private int capacidade;

	/*----------------------------procedimentos--------------------------*/

	//funções: todo procedimento que retorna algo. 
	//métodos: todo procedimento que não retorna nada
	
	
	// Construtor
	public FilaVetor(int capacidade) {
		fila = new Inteiro[capacidade];
		frente = tras = 0;
		this.capacidade = capacidade;
	}

	// Verifiar se a fila está vazia
	public boolean filaVazia() {
		return frente == tras;
	}

	// verificar se a fila está cheia
	public boolean filaCheia() {
		return (((tras + 1) % capacidade) == (frente % capacidade));
		/*
		 * O resto da divisão do contador pelo tamanho do vetor indicará a posição das
		 * variáveis de controle no vetor. para o vetor estar cheio, a posição trás
		 * precisa estar ocupando a posição vazia antes da frente.
		 */
	}
	
	public void enfileirar(Inteiro novo) throws Exception {
		/*
		 * eu preciso verificar se a fila está cheia e saber qual posição eu devo
		 * enfleirar o item
		 */

		int posicao = tras % capacidade;
		/*
		 * o resto da divisão do valor da posição indicará o indice do vetor para
		 * enfileirar
		 */

		if (!filaCheia()) {
			fila[posicao] = novo;
			tras++;
			/*
			 * depois de inserir o item no indice indicado pela posição, eu movo ela uma
			 * posição
			 */
		} else {
			throw new Exception("não foi possível enfilerar o novo elemento: a fila está cheia ");
		}
	}

	public Inteiro desenfileirar() throws Exception {
		Inteiro desenfileirado;// variavel para armazenar o valor a ser desenfileirado
		int posicao;// variavel para calcular indice a ser desenfileirado do vetor

		/*
		 * preciso verificar se a fila não está vazia, não é possivel desenfileirar o
		 * "NADA"
		 */
		if(!filaVazia()) {
			posicao = frente % capacidade;
			desenfileirado = fila[posicao];
			frente ++;
			return desenfileirado;
		}else {
			throw new Exception ("Não foi possível desenfileirar nenhum elemento: A fial está vazia");
		}
	}
	
	public void imprimir() throws Exception{
		int posicao;
		if(!filaVazia()) {
			System.out.println("Conteúdo da Fila");
			for (int i = frente; i<tras; i++) {
				posicao = i%capacidade;
				System.out.print("Posição " + posicao + ": ");
				fila[posicao].imprimir();
			}
		}
	}

	/*------------------Sets and Gets----------------*/
	public int getFrente() {
		return frente;
	}

	public void setFrente(int frente) {
		this.frente = frente;
	}

	public Inteiro[] getFila() {
		return fila;
	}

	public void setFila(Inteiro[] fila) {
		this.fila = fila;
	}

	public int getTras() {
		return tras;
	}

	public void setTras(int tras) {
		this.tras = tras;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

}
