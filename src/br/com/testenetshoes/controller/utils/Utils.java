package br.com.testenetshoes.controller.utils;


public class Utils {

	/**
	 * Verifica se o valor passado contém somente números
	 * @param param String  com a ser análisada.
	 * @return true se for um numero. False se não for.
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
	 * Verifica se String passada é nula ou esta vazia.
	 * @param param String a ser análizada.
	 * @return true se não estiver nulo. false caso esteja nulo ou vazio.
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
	 * @return true se o tamanho esta certo. false se o tamanho não estiver certo
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
	 * o resulta serï¿½ 33333300 
	 * 
	 * @param text
	 *            texto que o digito serï¿½ trocado.
	 * @param quantidade
	 *            quantidade de dï¿½gitos que serï¿½o trocados. A troca se inicia pela direita.
	 * 
	 * @return string com os digitos trocados.
	 * 
	 * @throws IllegalArgumentException caso algum parï¿½metro seja invï¿½lido.
	 * */
	public static String exchangeDigitByZero(String text, int quantidade) {

		if(text == null || text.isEmpty()){
			throw new IllegalArgumentException("Parametro texto inválito.");
		}

		if(quantidade < 0 || quantidade > text.length()){
			throw new IllegalArgumentException("Parametro quantidade inválito.");
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
