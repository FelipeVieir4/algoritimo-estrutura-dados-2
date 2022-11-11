
public class Aplicacao {

	public static void main(String[] args) {

		/* Atividade bem formada */

		Pilha minhaPilha = new Pilha();
		String entrada = MyIO.readLine();
		char topo;
		int erro = 0;

		do {

			int tamanhoString = entrada.length();
			char[] vetorChar = new char[tamanhoString];

			for (int i = 0; i < tamanhoString; i++) {
				vetorChar[i] = entrada.charAt(i);
				// System.out.println(vetorChar[i]);

				switch (vetorChar[i]) {
				case '(':
					minhaPilha.empilhar(vetorChar[i]);
					break;
				case '[':
					minhaPilha.empilhar(vetorChar[i]);
					break;
				case ')':

					try {
						topo = minhaPilha.consultarTopo();
						if (topo == '(') {
							minhaPilha.desempilhar();
						}
					} catch (Exception e) {
						// System.out.println("incorreto");
						erro++;
					}
					;
					break;

				case ']':

					try {
						topo = minhaPilha.consultarTopo();
						if (topo == '[') {
							minhaPilha.desempilhar();
						}
					} catch (Exception e) {
						// System.out.println("incorreto");
						erro++;
					}
					;
					break;

				}
			}
			try {
				topo = minhaPilha.consultarTopo();
				System.out.println("incorreto");
			} catch (Exception e) {
				if (erro == 0) {
					System.out.println("correto");
				} else {
					System.out.println("incorreto");
				}

			}
			
			try {
				while(! minhaPilha.pilhaVazia()) {
					minhaPilha.desempilhar();
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			erro = 0;
			entrada = MyIO.readLine();
		} while (!entrada.equals("FIM"));

	}
}