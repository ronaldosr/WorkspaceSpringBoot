package br.com.ronaldosr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ronaldosr.exception.OperacaoNaoSuportada;
import br.com.ronaldosr.services.ConversorService;
import br.com.ronaldosr.services.MathService;

@RestController
public class MathController {
	
	@Autowired
	private MathService mathOper;
	
	@Autowired
	private ConversorService conversor;
	
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
		if (!conversor.isNumeric(parametroA) || !conversor.isNumeric(parametroB)) {
			throw new OperacaoNaoSuportada("Por favor, informe um valor numérico!");
		}
		return mathOper.somar(conversor.convertToDouble(parametroA), conversor.convertToDouble(parametroB));
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
		if (!conversor.isNumeric(parametroA) || !conversor.isNumeric(parametroB)) {
			throw new OperacaoNaoSuportada("Por favor, informe um valor numérico!");
		}
		return mathOper.subtrair(conversor.convertToDouble(parametroA), conversor.convertToDouble(parametroB));		
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
		if (!conversor.isNumeric(parametroA) || !conversor.isNumeric(parametroB)) {
			throw new OperacaoNaoSuportada("Por favor, informe um valor numérico!");
		}
		return mathOper.multiplicar(conversor.convertToDouble(parametroA), conversor.convertToDouble(parametroB));
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
		if (!conversor.isNumeric(parametroA) || !conversor.isNumeric(parametroB)) {
			throw new OperacaoNaoSuportada("Por favor, informe um valor numérico!");
		}
		if (conversor.convertToDouble(parametroB) == 0D) {
			throw new OperacaoNaoSuportada("Não é possível dividir por zero!");
		}
		return mathOper.dividir(conversor.convertToDouble(parametroA), conversor.convertToDouble(parametroB));
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
		if (!conversor.isNumeric(parametroA) || !conversor.isNumeric(parametroB)) {
			throw new OperacaoNaoSuportada("Por favor, informe um valor numérico!");
		}
		return mathOper.media(conversor.convertToDouble(parametroA), conversor.convertToDouble(parametroB));
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
		if (!conversor.isNumeric(parametroA) || !conversor.isNumeric(parametroB)) {
			throw new OperacaoNaoSuportada("Por favor, informe um valor numérico!");
		}	
		return mathOper.expoente(conversor.convertToDouble(parametroA), conversor.convertToDouble(parametroB));
	}
	
	/**
	 * Raiz quadrada de um número
	 * @param parametroA
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/raiz/{parametroA}", method = RequestMethod.GET)
	public Double raiz(@PathVariable("parametroA") String parametroA) throws Exception {
		if (!conversor.isNumeric(parametroA)) {
			throw new OperacaoNaoSuportada("Por favor, informe um valor numérico!");
		}
		return mathOper.raiz(conversor.convertToDouble(parametroA));
	}
	
}
