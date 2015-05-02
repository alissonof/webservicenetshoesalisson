package br.com.testenetshoes.controller.utils;


public class Utils {

	/**
	 * Verifica se o valor passado cont�m somente n�meros
	 * @param param String  com a ser an�lisada.
	 * @return true se for um numero. False se n�o for.
	 */
	public static boolean isNumber(String param){

		if(isNotNull(param)){
			char[] array = param.toCharArray();
			for(char caracter : array){
				if(!Character.isDigit(caracter)){
					return false;
				}
			}

			return true;
		}else{
			return false;
		}
	}

	/**
	 * Verifica se String passada � nula ou esta vazia.
	 * @param param String a ser an�lizada.
	 * @return true se n�o estiver nulo. false caso esteja nulo ou vazio.
	 */
	public static boolean isNotNull(String param){
		if(param == null || param.isEmpty()){
			return false;
		}

		return true;
	}
	
	/**
	 * Verica se o tamanho da string esta certo
	 * @param param String a ser validada
	 * @param size tamanho certo da String
	 * @return true se o tamanho esta certo. false se o tamanho n�o estiver certo
	 */
	public static boolean isValidSize(String param, int size){
		
		if(isNotNull(param)){
			if(param.length() != size){
				return false;
			}else{
				return true;
			}
			
		}else{
			return false;
		}
	}
	
	/**
	 * Troca o digito por zero. A partir da direita troca a quantidade de passado 
	 * pelo parametro "quantidade" por zero. Exemplo text = 33333333 e quantidade = 2,
	 * o resulta ser� 33333300 
	 * 
	 * @param text
	 *            texto que o digito ser� trocado.
	 * @param quantidade
	 *            quantidade de d�gitos que ser�o trocados. A troca se inicia pela direita.
	 * 
	 * @return string com os digitos trocados.
	 * 
	 * @throws IllegalArgumentException caso algum par�metro seja inv�lido.
	 * */
	public static String exchangeDigitByZero(String text, int quantidade) {

		if(text == null || text.isEmpty()){
			throw new IllegalArgumentException("Parametro texto inv�lito.");
		}

		if(quantidade < 0 || quantidade > text.length()){
			throw new IllegalArgumentException("Parametro quantidade inv�lito.");
		}

		StringBuilder sb = new StringBuilder();

		char[] array = text.toCharArray();
		int prevSize = array.length - quantidade;
		for(int index = 0; index < array.length; index++){

			if(index < prevSize){
				sb.append(array[index]);
			}else{
				sb.append('0');
			}

		}

		return sb.toString();
	}
}
