package br.com.testenetshoes.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.testenetshoes.controller.exception.InvalidParameterExeception;
import br.com.testenetshoes.model.to.Endereco;

@Path("/consulta")
//@Consumes(MediaType.APPLICATION_XML)
public class ConsultaCep {

	@GET
	@Path("/{cep}")
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Endereco consultarCep(@PathParam("cep") String cep){
		Endereco end = new Endereco();;
		try {
			validate(cep);
			WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
			for(int index = 0; index < cep.length(); index++){
				String newCep = exchangeDigitByZero(cep, index);
				webServiceCep = WebServiceCep.searchCep(newCep);
				if(webServiceCep.wasSuccessful()){
					end.setCep(newCep);
					end.setRua(webServiceCep.getLogradouro());
					end.setBairro(webServiceCep.getLogradouro());
					end.setCidade(webServiceCep.getCidade());
					end.setEstado(webServiceCep.getUf());
					end.setStatus(0);
					end.setMensagem("CEP encontrado.");
					break;
				}
			}

			//Caso o atributo cep seja nulo significa que nï¿½o encontrou nenhum endereï¿½o
			if(end.getCep() == null){
				end.setStatus(1);
				end.setMensagem("CEP não encontrado.");
			}
			//}

		} catch (InvalidParameterExeception e1) {
			end.setStatus(2);
			end.setMensagem(e1.getMessage());
		}
		
		return end;
	}

	private void validate(String cep) throws InvalidParameterExeception{
		if(cep == null || cep.isEmpty() || cep.length() != 8){
			throw new InvalidParameterExeception("CEP Inválido.");
		}

		char[] array = cep.toCharArray();
		for(char caracter : array){
			if(!Character.isDigit(caracter)){
				throw new InvalidParameterExeception("CEP Inválido.");
			}
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
	private String exchangeDigitByZero(String text, int quantidade) {

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
