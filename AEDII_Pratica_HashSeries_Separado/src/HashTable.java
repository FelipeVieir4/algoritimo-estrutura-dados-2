import java.util.ArrayList;
import java.util.List;

class HashTable {
	private ListaDuplamenteEncadeada[] table;
	private int tableLength;
	List<Integer> keys = new ArrayList<Integer>();

	HashTable(int len) {
		this.tableLength = len;
		table = new ListaDuplamenteEncadeada[len];
		for (int i = 0; i < tableLength; i++) {
			table[i] = new ListaDuplamenteEncadeada();
		}
	}

	
	public int hash(String key) {
		int hashKey = this.getKey(key);
		return hashKey % tableLength;
	}

	public void insert(Serie newSerie) {
		int pos = hash(newSerie.getNome());
		table[pos].inserirFinal(newSerie);

	}
	
	public int searchKey(String key) throws Exception {
		int pos = hash(key);
		int comparacoes = 0;
		try {
			comparacoes += table[pos].buscar(key);
			 return comparacoes;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	private int getKey(String nome) {
		String trim = nome;
		int total = 0;
		for (int i = 0; i < trim.length(); i++) {
			int ascii = (int) trim.charAt(i);
			total += ascii;
		}
		return total % tableLength;
	}

	public void printTable() {
		for (ListaDuplamenteEncadeada lista : this.table) {
			try {
				lista.imprimir();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}