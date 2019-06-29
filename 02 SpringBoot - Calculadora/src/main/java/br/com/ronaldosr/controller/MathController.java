package br.com.ronaldosr.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ronaldosr.exception.OperacaoNaoSuportada;
import br.com.ronaldosr.math.MathOper;
import br.com.ronaldosr.utils.Conversor;

@RestController
public class MathController {
	
	/**
	 * Criar instância de MathOper
	 */
	private MathOper mathOper = new MathOper();
	
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
		return mathOper.somar(Conversor.convertToDouble(parametroA), Conversor.convertToDouble(parametroB));
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
		return mathOper.subtrair(Conversor.convertToDouble(parametroA), Conversor.convertToDouble(parametroB));		
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
		return mathOper.multiplicar(Conversor.convertToDouble(parametroA), Conversor.convertToDouble(parametroB));
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
		return mathOper.dividir(Conversor.convertToDouble(parametroA), Conversor.convertToDouble(parametroB));
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
		return mathOper.media(Conversor.convertToDouble(parametroA), Conversor.convertToDouble(parametroB));
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
		return mathOper.expoente(Conversor.convertToDouble(parametroA), Conversor.convertToDouble(parametroB));
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
		return mathOper.raiz(Conversor.convertToDouble(parametroA));
	}
	
}
