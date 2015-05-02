package br.com.testenetshoes.model.to;



public class Endereco {
	
	private String rua;
	
	private String cep;
	
	private String bairro;

	private String cidade;
	
	private String estado;
	
	private int status;
	
	private String mensagem;


	/**
	 * Recupera o(a) rua.
	 * @return o(a) rua.
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * Configura o(a) rua.
	 * @param rua o(a) rua que será configurado(a).
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}


	/**
	 * Recupera o(a) cep.
	 * @return o(a) cep.
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Configura o(a) cep.
	 * @param cep o(a) cep que será configurado(a).
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * Recupera o(a) bairro.
	 * @return o(a) bairro.
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Configura o(a) bairro.
	 * @param bairro o(a) bairro que será configurado(a).
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * Recupera o(a) cidade.
	 * @return o(a) cidade.
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Configura o(a) cidade.
	 * @param cidade o(a) cidade que será configurado(a).
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * Recupera o(a) estado.
	 * @return o(a) estado.
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Configura o(a) estado.
	 * @param estado o(a) estado que será configurado(a).
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status Informa status da busca podendo assumir os seguites valores
	 * 0 - sucesso na busca
	 * 1 - CEP n�o encontrado
	 * 2 - Paramatro inv�lido. 
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * @param mensagem Configura a mesagem de retornada na busca.
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	
}
