package br.com.ronaldosr.services;

import org.springframework.stereotype.Service;

@Service
public class ConversorService {
	
	/**
	 * Converte string representando número para Double
	 * @param strNumero
	 * @return
	 */
	public Double convertToDouble(String strNumero) {
		if (strNumero == null) return 0D;
		String numero = strNumero.replaceAll(",", ".");
		if (isNumeric(numero)) return Double.parseDouble(numero);
		return 0D;
	}
	
	/**
	 * Verifica se string representando número é Numérico
	 * @param strNumero
	 * @return
	 */
	public boolean isNumeric(String strNumero) {
		if (strNumero == null) return false;
		String numero = strNumero.replaceAll(",", ".");
		return numero.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
