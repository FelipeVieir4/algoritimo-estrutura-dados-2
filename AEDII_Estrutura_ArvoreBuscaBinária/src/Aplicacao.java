class Aplicacao {
	public static void main(String[] args) {
		ABB minhaArvore = new ABB();
		Inteiro novo, pesquisado;

		novo = new Inteiro(26);
		try {
			minhaArvore.inserir(novo);
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		novo = new Inteiro(11);
		try {
			minhaArvore.inserir(novo);
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		novo = new Inteiro(21);
		try {
			minhaArvore.inserir(novo);
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		novo = new Inteiro(50);
		try {
			minhaArvore.inserir(novo);
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		novo = new Inteiro(4);
		try {
			minhaArvore.inserir(novo);
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		System.out.println("Caminhamento central na �rvore:");
		minhaArvore.caminhamentoEmOrdem(); // 4 - 11 - 21 - 26 - 50

		try {
			pesquisado = minhaArvore.pesquisar(11);
			if (pesquisado != null) {
				System.out.print("Elemento pesquisado: "); // 11
				pesquisado.imprimir();
			} else
				System.out.println("O elemento n�o foi encontrado na �rvore!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			minhaArvore.remover(11);
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		System.out.println("Caminhamento central na �rvore:");
		minhaArvore.caminhamentoEmOrdem(); // 4 - 21 - 26 - 50

		try {
			pesquisado = minhaArvore.pesquisar(11);
			if (pesquisado != null) {
				System.out.print("Elemento pesquisado: ");
				pesquisado.imprimir();
			} else
				System.out.println("O elemento pesquisado n�o foi encontrado na �rvore!"); // Essa mensagem deve ser
																							// exibida.
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}