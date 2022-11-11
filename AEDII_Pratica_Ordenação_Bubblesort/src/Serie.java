class Serie {

	private String nome;
	private String formato;
	private String duracao;
	private String paisOrigem;
	private String idiomaOrigem;
	private String emissoraTvOriginal;
	private String inicioTransmissaoOriginal;
	private int numeroTemporadas;
	private int numeroEpisodios;

	Serie() {
		nome = "";
		formato = "";
		duracao = "";
		paisOrigem = "";
		idiomaOrigem = "";
		emissoraTvOriginal = "";
		inicioTransmissaoOriginal = "";
		numeroTemporadas = 0;
		numeroEpisodios = 0;
	}

	Serie(String nome, String formato, String duracao, String paisOrigem, String idiomaOrigem,
			String emissoraTvOriginal, String inicioTransmissaoOriginal, int numeroTemporadas, int numeroEpisodios) {
		this.nome = nome;
		this.formato = formato;
		this.duracao = duracao;
		this.paisOrigem = paisOrigem;
		this.idiomaOrigem = idiomaOrigem;
		this.emissoraTvOriginal = emissoraTvOriginal;
		this.inicioTransmissaoOriginal = inicioTransmissaoOriginal;
		this.numeroTemporadas = numeroTemporadas;
		this.numeroEpisodios = numeroEpisodios;
	}

	public Serie clone() {

		Serie clone;
		clone = new Serie(this.nome, this.formato, this.duracao, this.paisOrigem, this.idiomaOrigem,
				this.emissoraTvOriginal, this.inicioTransmissaoOriginal, this.numeroTemporadas, this.numeroEpisodios);
		return clone;
	}

	public void ler() {
		String fullInfo = MyIO.readLine();
		String[] splitInfo = fullInfo.split(";");

		this.setNome(splitInfo[0]);
		this.setFormato(splitInfo[1]);
		this.setDuracao(splitInfo[2]);
		this.setPaisOrigem(splitInfo[3]);
		this.setIdiomaOrigem(splitInfo[4]);
		this.setEmissoraTvOriginal(splitInfo[5]);
		this.setInicioTransmissaoOriginal(splitInfo[6]);
		this.setNumeroTemporadas(Integer.parseInt(splitInfo[7]));
		this.setNumeroEpisodios(Integer.parseInt(splitInfo[8]));

	}

	public void ler(String fullSerie) {
		String fullInfo = fullSerie;
		String[] splitInfo = fullInfo.split(";");

		this.setNome(splitInfo[0]);
		this.setFormato(splitInfo[1]);
		this.setDuracao(splitInfo[2]);
		this.setPaisOrigem(splitInfo[3]);
		this.setIdiomaOrigem(splitInfo[4]);
		this.setEmissoraTvOriginal(splitInfo[5]);
		this.setInicioTransmissaoOriginal(splitInfo[6]);
		this.setNumeroTemporadas(Integer.parseInt(splitInfo[7]));
		this.setNumeroEpisodios(Integer.parseInt(splitInfo[8]));

	}

	public void imprimir() {
		System.out.print(getNome());
		System.out.print(" ## ");
		System.out.print(getFormato());
		System.out.print(" ## ");
		System.out.print(getDuracao());
		System.out.print(" ## ");
		System.out.print(getPaisOrigem());
		System.out.print(" ## ");
		System.out.print(getIdiomaOrigem());
		System.out.print(" ## ");
		System.out.print(getEmissoraTvOriginal());
		System.out.print(" ## ");
		System.out.print(getInicioTransmissaoOriginal());
		System.out.print(" ## ");
		System.out.print(getNumeroTemporadas());
		System.out.print(" ## ");
		System.out.print(getNumeroEpisodios());
		System.out.print("\n");

	}

	public void pesquisar(String nomePesquisa, Serie vetor[]) {

		for (int i = 0; i < vetor.length; i++) {
			if (nomePesquisa.equals(vetor[i].getNome())) {
				vetor[i].imprimir();
			}
		}
	}

	public int pesquisarPosicao(String nomePesquisa, Serie vetor[]) {
		int posicao = 0;
		for (int i = 0; i < vetor.length; i++) {
			if (nomePesquisa.equals(vetor[i].getNome())) {
				posicao = i;
			}
		}
		return posicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public String getIdiomaOrigem() {
		return idiomaOrigem;
	}

	public void setIdiomaOrigem(String idiomaOrigem) {
		this.idiomaOrigem = idiomaOrigem;
	}

	public String getEmissoraTvOriginal() {
		return emissoraTvOriginal;
	}

	public void setEmissoraTvOriginal(String emissoraTvOriginal) {
		this.emissoraTvOriginal = emissoraTvOriginal;
	}

	public String getInicioTransmissaoOriginal() {
		return inicioTransmissaoOriginal;
	}

	public void setInicioTransmissaoOriginal(String inicioTransmissaoOriginal) {
		this.inicioTransmissaoOriginal = inicioTransmissaoOriginal;
	}

	public int getNumeroTemporadas() {
		return numeroTemporadas;
	}

	public void setNumeroTemporadas(int numeroTemporadas) {
		this.numeroTemporadas = numeroTemporadas;
	}

	public int getNumeroEpisodios() {
		return numeroEpisodios;
	}

	public void setNumeroEpisodios(int numeroEpisodios) {
		this.numeroEpisodios = numeroEpisodios;
	}

}