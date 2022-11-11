
public class Aplicacao {

	public static void main(String[] args) {
		
		FilaVetor minhaFilaVetor;
		Inteiro novo;
		Inteiro desenfileirado;

		minhaFilaVetor = new FilaVetor(4);

		novo = new Inteiro(14);
		try {
			minhaFilaVetor.enfileirar(novo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		novo = new Inteiro(10);
		try {
			minhaFilaVetor.enfileirar(novo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		novo = new Inteiro(21);
		try {
			minhaFilaVetor.enfileirar(novo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		novo = new Inteiro(3);
		try {
			minhaFilaVetor.enfileirar(novo);
		} catch (Exception e) {
			System.out.println(e.getMessage()); // Exibe essa mensagem
		}

		try {
			minhaFilaVetor.imprimir(); // 14 - 10 - 21
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			desenfileirado = minhaFilaVetor.desenfileirar();
			System.out.print("Desenfileirado: ");
			desenfileirado.imprimir(); // 14
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			desenfileirado = minhaFilaVetor.desenfileirar();
			System.out.print("Desenfileirado: ");
			desenfileirado.imprimir(); // 10
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		novo = new Inteiro(3);
		try {
			minhaFilaVetor.enfileirar(novo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		novo = new Inteiro(20);
		try {
			minhaFilaVetor.enfileirar(novo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			minhaFilaVetor.imprimir(); // 21 - 3 - 20
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
