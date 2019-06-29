package br.com.ronaldosr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ronaldosr.model.Pessoa;
import br.com.ronaldosr.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService servico;
	
	@RequestMapping(method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pessoa> findAll() {
		return servico.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET,
			        produces = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa findById(@PathVariable("id") Long id) {
		return servico.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,
			        consumes = MediaType.APPLICATION_JSON_VALUE,
			        produces  = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa novaPessoa(@RequestBody Pessoa pessoa)  {
		return servico.novaPessoa(pessoa);
	}
	
	@RequestMapping(method = RequestMethod.PUT,
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces  = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa atualizarPessoa(@RequestBody Pessoa pessoa)  {
		return servico.atualizarPessoa(pessoa);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void excluirPessoa(@PathVariable("id") Long id) {
		servico.excluirPessoa(id);
	}

}
