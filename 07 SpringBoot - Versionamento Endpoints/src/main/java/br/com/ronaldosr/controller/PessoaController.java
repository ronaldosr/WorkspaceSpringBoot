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

import br.com.ronaldosr.data.vo.PessoaVO;
import br.com.ronaldosr.data.vo.v2.PessoaVOV2;
import br.com.ronaldosr.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public List<PessoaVO> findAll() {
		return pessoaService.findAll();
	}
	
	@GetMapping("/{id}")
	public PessoaVO findById(@PathVariable("id") Long id) {
		return pessoaService.findById(id);
	}
	
	@GetMapping("/cpf/{cpf}")
	public List<PessoaVO> findByCpf(@PathVariable("cpf") String cpf) {
		return pessoaService.findByCpf(cpf);
	}
	
	@GetMapping("/email/{email}")
	public PessoaVO findByEmail(@PathVariable("email") String email) {
		return pessoaService.findByEmail(email);
	}
	
	@PostMapping
	public PessoaVO novaPessoa(@RequestBody PessoaVO pessoa)  {
		return pessoaService.novaPessoa(pessoa);
	}
	
	@PostMapping("/v2")
	public PessoaVOV2 novaPessoaV2(@RequestBody PessoaVOV2 pessoa)  {
		return pessoaService.novaPessoaV2(pessoa);
	}
	
	@PutMapping
	public PessoaVO atualizarPessoa(@RequestBody PessoaVO pessoa)  {
		return pessoaService.atualizarPessoa(pessoa);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirPessoa(@PathVariable("id") Long id) {
		pessoaService.excluirPessoa(id);
		return ResponseEntity.ok().build();
	}

}
