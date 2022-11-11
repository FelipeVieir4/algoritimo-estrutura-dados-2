
public class FilaVetor {

	private Inteiro[] fila;
	private int frente;
	private int tras;
	private int capacidade;

	/*----------------------------procedimentos--------------------------*/

	//fun��es: todo procedimento que retorna algo. 
	//m�todos: todo procedimento que n�o retorna nada
	
	
	// Construtor
	public FilaVetor(int capacidade) {
		fila = new Inteiro[capacidade];
		frente = tras = 0;
		this.capacidade = capacidade;
	}

	// Verifiar se a fila est� vazia
	public boolean filaVazia() {
		return frente == tras;
	}

	// verificar se a fila est� cheia
	public boolean filaCheia() {
		return (((tras + 1) % capacidade) == (frente % capacidade));
		/*
		 * O resto da divis�o do contador pelo tamanho do vetor indicar� a posi��o das
		 * vari�veis de controle no vetor. para o vetor estar cheio, a posi��o tr�s
		 * precisa estar ocupando a posi��o vazia antes da frente.
		 */
	}
	
	public void enfileirar(Inteiro novo) throws Exception {
		/*
		 * eu preciso verificar se a fila est� cheia e saber qual posi��o eu devo
		 * enfleirar o item
		 */

		int posicao = tras % capacidade;
		/*
		 * o resto da divis�o do valor da posi��o indicar� o indice do vetor para
		 * enfileirar
		 */

		if (!filaCheia()) {
			fila[posicao] = novo;
			tras++;
			/*
			 * depois de inserir o item no indice indicado pela posi��o, eu movo ela uma
			 * posi��o
			 */
		} else {
			throw new Exception("n�o foi poss�vel enfilerar o novo elemento: a fila est� cheia ");
		}
	}

	public Inteiro desenfileirar() throws Exception {
		Inteiro desenfileirado;// variavel para armazenar o valor a ser desenfileirado
		int posicao;// variavel para calcular indice a ser desenfileirado do vetor

		/*
		 * preciso verificar se a fila n�o est� vazia, n�o � possivel desenfileirar o
		 * "NADA"
		 */
		if(!filaVazia()) {
			posicao = frente % capacidade;
			desenfileirado = fila[posicao];
			frente ++;
			return desenfileirado;
		}else {
			throw new Exception ("N�o foi poss�vel desenfileirar nenhum elemento: A fial est� vazia");
		}
	}
	
	public void imprimir() throws Exception{
		int posicao;
		if(!filaVazia()) {
			System.out.println("Conte�do da Fila");
			for (int i = frente; i<tras; i++) {
				posicao = i%capacidade;
				System.out.print("Posi��o " + posicao + ": ");
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
