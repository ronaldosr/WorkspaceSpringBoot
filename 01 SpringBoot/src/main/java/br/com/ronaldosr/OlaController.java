package br.com.ronaldosr;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlaController {

	private static final String template = "Olá %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/ola")
	public Ola ola(@RequestParam(value="name", defaultValue = "pessoal") String name) {
		return new Ola(counter.incrementAndGet(), String.format(template, name));		
	}
}
