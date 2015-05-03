package br.com.testenetshoes.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.testenetshoes.controller.exception.InvalidParameterExeception;
import br.com.testenetshoes.controller.utils.Utils;
import br.com.testenetshoes.model.to.Endereco;

@Path("/consulta")
public class ConsultaCep {

	@GET
	@Path("/{cep}")
	@Produces(MediaType.APPLICATION_JSON)
	public Endereco consultarCep(@PathParam("cep") String cep){
		Endereco end = new Endereco();;
		try {
			validate(cep);
			WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
			for(int index = 0; index < cep.length(); index++){
				String newCep = Utils.exchangeDigitByZero(cep, index);
				webServiceCep = WebServiceCep.searchCep(newCep);
				if(webServiceCep.wasSuccessful()){
					end.setCep(newCep);
					end.setRua(webServiceCep.getLogradouro());
					end.setBairro(webServiceCep.getBairro());
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
		if(!Utils.isValidSize(cep, 8)){
			throw new InvalidParameterExeception("CEP Inválido.");
		}

		if(!Utils.isNumber(cep)){
			throw new InvalidParameterExeception("CEP Inválido.");
		}
	}

	
}
