package br.com.ronaldosr.services;

import org.springframework.stereotype.Service;

@Service
public class MathService {

	/**
	 * Somar A+B
	 * @param parametroA
	 * @param parametroB
	 * @return
	 */
	public Double somar(Double parametroA, Double parametroB) {
		Double resultado = parametroA + parametroB;
		return resultado;
	}
	
	/**
	 * Subtrair A-B
	 * @param parametroA
	 * @param parametroB
	 * @return
	 */
	public Double subtrair(Double parametroA, Double parametroB) {
		Double resultado = parametroA - parametroB;
		return resultado;
	}
	
	/**
	 * Multiplicar A*B
	 * @param parametroA
	 * @param parametroB
	 * @return
	 */
	public Double multiplicar(Double parametroA, Double parametroB) {
		Double resultado = parametroA * parametroB;
		return resultado;
	}
	
	/**
	 * Dividir A/B
	 * @param parametroA
	 * @param parametroB
	 * @return
	 */
	public Double dividir(Double parametroA, Double parametroB) {
		Double resultado = parametroA / parametroB;
		return resultado;
	}

	/**
	 * Média (A+B)/2
	 * @param parametroA
	 * @param parametroB
	 * @return
	 */
	public Double media(Double parametroA, Double parametroB) {
		Double resultado = (parametroA + parametroB)/2 ;
		return resultado;
	}

	/**
	 * Expoente A^B
	 * @param parametroA
	 * @param parametroB
	 * @return
	 */
	public Double expoente(Double parametroA, Double parametroB) {
		Double resultado = Math.pow(parametroA, parametroB);
		return resultado;
	}
	
	/**
	 * Raiz quadrada √A
	 * @param parametroA
	 * @return
	 */
	public Double raiz(Double parametroA) {
		Double resultado = Math.sqrt(parametroA);
		return resultado;
	}
}
