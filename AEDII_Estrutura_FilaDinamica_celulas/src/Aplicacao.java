public class Aplicacao {
  public static void main(String[] args) {
    Fila minhaFila;
		Inteiro novo;
		Inteiro desenfileirado;
		
		minhaFila = new Fila();
		
		novo = new Inteiro(14);
		minhaFila.enfileirar(novo);
		
		novo = new Inteiro(10);
		minhaFila.enfileirar(novo);
		
		novo = new Inteiro(21);
		minhaFila.enfileirar(novo);
		
		try {
			minhaFila.imprimir();    // 14 - 10 - 21
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			desenfileirado = minhaFila.desenfileirar();
			System.out.print("Desenfileirado: ");
			desenfileirado.imprimir();    // 14
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		
		try {
			desenfileirado = minhaFila.desenfileirar();
			System.out.print("Desenfileirado: ");
			desenfileirado.imprimir();    // 10
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		
		novo = new Inteiro(3);
		minhaFila.enfileirar(novo);
		
		novo = new Inteiro(20);
		minhaFila.enfileirar(novo);
		
		try {
			minhaFila.imprimir();    // 21 - 3 - 20
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
  }
}