package br.com.ronaldosr.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ronaldosr.exception.OperacaoNaoSuportada;
import br.com.ronaldosr.utils.Conversor;

@RestController
public class MathController {
	
	/**
	 * Soma entre dois números
	 * 
	 * @param parametroA
	 * @param parametroB
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/somar/{parametroA}/{parametroB}", method = RequestMethod.GET)
	public Double somar(@PathVariable("parametroA") String parametroA, 
			           @PathVariable("parametroB") String parametroB) throws Exception {
		if (!Conversor.isNumeric(parametroA) || !Conversor.isNumeric(parametroB)) {
			throw new OperacaoNaoSuportada("Por favor, informe um valor numérico!");
		}
		Double resultado = Conversor.convertToDouble(parametroA) + Conversor.convertToDouble(parametroB);
		return resultado;		
	}
	
	/**
	 * Subtração entre dois números
	 * 
	 * @param parametroA
	 * @param parametroB
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/subtrair/{parametroA}/{parametroB}", method = RequestMethod.GET)
	public Double subtrair(@PathVariable("parametroA") String parametroA, 
			                @PathVariable("parametroB") String parametroB) throws Exception {
		if (!Conversor.isNumeric(parametroA) || !Conversor.isNumeric(parametroB)) {
			throw new OperacaoNaoSuportada("Por favor, informe um valor numérico!");
		}
		Double resultado = Conversor.convertToDouble(parametroA) - Conversor.convertToDouble(parametroB);
		return resultado;		
	}
	
	/**
	 * Multiplicação entre dois números
	 * 	
	 * @param parametroA
	 * @param parametroB
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/multiplicar/{parametroA}/{parametroB}", method = RequestMethod.GET)
	public Double multiplicar(@PathVariable("parametroA") String parametroA, 
			                  @PathVariable("parametroB") String parametroB) throws Exception {
		if (!Conversor.isNumeric(parametroA) || !Conversor.isNumeric(parametroB)) {
			throw new OperacaoNaoSuportada("Por favor, informe um valor numérico!");
		}
		Double resultado = Conversor.convertToDouble(parametroA) * Conversor.convertToDouble(parametroB);
		return resultado;		
	}
	
	/**
	 * Divisão entre dois números
	 * @param parametroA
	 * @param parametroB
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/dividir/{parametroA}/{parametroB}", method = RequestMethod.GET)
	public Double dividir(@PathVariable("parametroA") String parametroA, 
			              @PathVariable("parametroB") String parametroB) throws Exception {
		if (!Conversor.isNumeric(parametroA) || !Conversor.isNumeric(parametroB)) {
			throw new OperacaoNaoSuportada("Por favor, informe um valor numérico!");
		}
		if (Conversor.convertToDouble(parametroB) == 0D) {
			throw new OperacaoNaoSuportada("Não é possível dividir por zero!");
		}
		Double resultado = Conversor.convertToDouble(parametroA) / Conversor.convertToDouble(parametroB);
		return resultado;		
	}
	
	/**
	 * Média entre dois números
	 * @param parametroA
	 * @param parametroB
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/media/{parametroA}/{parametroB}", method = RequestMethod.GET)
	public Double media(@PathVariable("parametroA") String parametroA, 
			            @PathVariable("parametroB") String parametroB) throws Exception {
		if (!Conversor.isNumeric(parametroA) || !Conversor.isNumeric(parametroB)) {
			throw new OperacaoNaoSuportada("Por favor, informe um valor numérico!");
		}
		Double resultado = (Conversor.convertToDouble(parametroA) + Conversor.convertToDouble(parametroB))/2;
		return resultado;		
	}
	
	/**
	 * Expoente entre dois números 
	 * @param parametroA
	 * @param parametroB
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/expoente/{parametroA}/{parametroB}", method = RequestMethod.GET)
	public Double expoente(@PathVariable("parametroA") String parametroA, 
			           @PathVariable("parametroB") String parametroB) throws Exception {
		if (!Conversor.isNumeric(parametroA) || !Conversor.isNumeric(parametroB)) {
			throw new OperacaoNaoSuportada("Por favor, informe um valor numérico!");
		}
		Double resultado = Math.pow(Conversor.convertToDouble(parametroA), Conversor.convertToDouble(parametroB));
		return resultado;		
	}
	
	/**
	 * Raiz quadrada de um número
	 * @param parametroA
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/raiz/{parametroA}", method = RequestMethod.GET)
	public Double raiz(@PathVariable("parametroA") String parametroA) throws Exception {
		if (!Conversor.isNumeric(parametroA)) {
			throw new OperacaoNaoSuportada("Por favor, informe um valor numérico!");
		}
		Double resultado = Math.sqrt(Conversor.convertToDouble(parametroA));
		return resultado;		
	}
	
}
