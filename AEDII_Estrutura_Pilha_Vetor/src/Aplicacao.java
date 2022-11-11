
public class Aplicacao {

	public static void main(String[] args) {

		Pilha minhaPilha;
		Inteiro novo;
		Inteiro topo;
		Inteiro desempilhado;

		minhaPilha = new Pilha(4);

		novo = new Inteiro(25);
		try {
			minhaPilha.empilhar(novo);
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		novo = new Inteiro(10);
		try {
			minhaPilha.empilhar(novo);
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		novo = new Inteiro(21);
		try {
			minhaPilha.empilhar(novo);
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		novo = new Inteiro(3);
		try {
			minhaPilha.empilhar(novo);
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		novo = new Inteiro(20);
		try {
			minhaPilha.empilhar(novo);
		} catch (Exception erro) {
			System.out.println(erro.getMessage()); // Essa mensagem deve ser exibida.
		}

		try {
			topo = minhaPilha.consultarTopo();
			System.out.print("Elemento do topo da pilha: ");
			topo.imprimir(); // 3
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		try {
			desempilhado = minhaPilha.desempilhar();
			System.out.print("Elemento desempilhado: ");
			desempilhado.imprimir(); // 3
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		try {
			topo = minhaPilha.consultarTopo();
			System.out.print("Elemento do topo da pilha: ");
			topo.imprimir(); // 21
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
}