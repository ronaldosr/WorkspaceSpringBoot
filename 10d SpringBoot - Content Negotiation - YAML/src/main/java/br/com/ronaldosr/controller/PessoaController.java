package br.com.ronaldosr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ronaldosr.data.vo.v1.PessoaVO;
import br.com.ronaldosr.services.PessoaService;

@RestController
@RequestMapping(value = "/api/pessoa/v1")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<PessoaVO> findAll() {
		return pessoaService.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public PessoaVO findById(@PathVariable("id") Long id) {
		return pessoaService.findById(id);
	}
	
	@GetMapping(value = "/cpf/{cpf}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<PessoaVO> findByCpf(@PathVariable("cpf") String cpf) {
		return pessoaService.findByCpf(cpf);
	}
	
	@GetMapping(value = "/email/{email}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public PessoaVO findByEmail(@PathVariable("email") String email) {
		return pessoaService.findByEmail(email);
	}
	
	@PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
			     consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PessoaVO novaPessoa(@RequestBody PessoaVO pessoa)  {
		return pessoaService.novaPessoa(pessoa);
	}
	
	@PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
			    consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PessoaVO atualizarPessoa(@RequestBody PessoaVO pessoa)  {
		return pessoaService.atualizarPessoa(pessoa);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirPessoa(@PathVariable("id") Long id) {
		pessoaService.excluirPessoa(id);
		return ResponseEntity.ok().build();
	}

}
