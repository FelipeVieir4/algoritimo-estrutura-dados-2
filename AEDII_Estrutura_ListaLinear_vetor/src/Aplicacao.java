public class Aplicacao {
  public static void main(String[] args) {

    ListaLinear minhaLista;
		Inteiro novo, removido;
		
		minhaLista = new ListaLinear(4);
		
		novo = new Inteiro(1);
		try {
			minhaLista.inserir(novo, 0);  // 1
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		novo = new Inteiro(11);
		try {
			minhaLista.inserir(novo, 0);  // 11 - 1
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		novo = new Inteiro(21);
		try {
			minhaLista.inserir(novo, 3);  // 11 - 1
		} catch (Exception erro) {
			System.out.println(erro.getMessage());  // Essa mensagem de erro deve ser exibida.
		}
		
		novo = new Inteiro(21);
		try {
			minhaLista.inserir(novo, 2);  // 11 - 1 - 21
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		novo = new Inteiro(4);
		try {
			minhaLista.inserir(novo, 2);  // 11 - 1 - 4 - 21
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		novo = new Inteiro(20);
		try {
			minhaLista.inserir(novo, 3);  // 11 - 1 - 4 - 21
		} catch (Exception erro) {
			System.out.println(erro.getMessage());  // Essa mensagem de erro deve ser exibida.
		}
		
		try {
			minhaLista.imprimir();  // 11 - 1 - 4 - 21
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		try {
			removido = minhaLista.remover(1);
			System.out.print("Item removido: ");  // 1
			removido.imprimir();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		try {
			minhaLista.imprimir();  // 11 - 4 - 21
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		try {
			removido = minhaLista.remover(3);
			System.out.print("Item removido: ");
			removido.imprimir();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());  // Essa mensagem deve ser exibida.
		}
		
		try {
			removido = minhaLista.remover(1);
			System.out.print("Item removido: ");  // 4
			removido.imprimir();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		try {
			minhaLista.imprimir();  // 11 - 21
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
  }
}