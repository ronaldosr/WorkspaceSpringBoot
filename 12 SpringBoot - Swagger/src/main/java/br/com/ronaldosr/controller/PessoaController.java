package br.com.ronaldosr.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Endpoint Pessoa", 
     description = "Permite o cadastramento, consulta, atualização e exclusão de uma Pessoa",
     tags = {"Endpoint Pessoa"})
//     tags = {"Endpoint Pessoa", "Pessoa", "Pessoas"})
@RestController
@RequestMapping(value = "/api/pessoa/v1")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@ApiOperation(value = "Retorna uma lista com todas as pessoas cadastradas na base.")
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<PessoaVO> findAll() {
		List<PessoaVO> pessoas = pessoaService.findAll();
		pessoas
			.stream()
			.forEach(p -> p.add(
						linkTo(methodOn(PessoaController.class).findById(p.getKey())).withSelfRel()
					)
			);
		return pessoas;
	}
	
	@ApiOperation(value = "Retorna os dados de uma pessoa.")
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public PessoaVO findById(@PathVariable("id") Long id) {
		PessoaVO pessoaVO = pessoaService.findById(id);
		pessoaVO.add(linkTo(methodOn(PessoaController.class).findById(id)).withSelfRel());
		return pessoaVO;
	}
	
	@ApiOperation(value = "Retorna os dados de uma pessoa de acordo com o CPF.")
	@GetMapping(value = "/cpf/{cpf}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<PessoaVO> findByCpf(@PathVariable("cpf") String cpf) {
		List<PessoaVO> pessoas = pessoaService.findByCpf(cpf);
		pessoas
			.stream()
			.forEach(p -> p.add(
						linkTo(methodOn(PessoaController.class).findByCpf(p.getCpf())).withSelfRel()
					)
			);
		return pessoas;
	}
	
	@ApiOperation(value = "Retorna os dados de uma pessoa de acordo com o e-mail.")
	@GetMapping(value = "/email/{email}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public PessoaVO findByEmail(@PathVariable("email") String email) {
		PessoaVO pessoaVO = pessoaService.findByEmail(email);
		pessoaVO.add(linkTo(methodOn(PessoaController.class).findByEmail(email)).withSelfRel());
		return pessoaVO;
	}
	
	@ApiOperation(value = "Grava uma nova pessoa na base de dados.")
	@PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
			     consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PessoaVO novaPessoa(@RequestBody PessoaVO pessoa)  {
		PessoaVO pessoaVO = pessoaService.novaPessoa(pessoa);
		pessoaVO.add(linkTo(methodOn(PessoaController.class).findById(pessoaVO.getKey())).withSelfRel());
		return pessoaVO;		
	}
	
	@ApiOperation(value = "Atualiza uma pessoa na base de dados.")
	@PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
			    consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PessoaVO atualizarPessoa(@RequestBody PessoaVO pessoa)  {
		PessoaVO pessoaVO = pessoaService.atualizarPessoa(pessoa);
		pessoaVO.add(linkTo(methodOn(PessoaController.class).findById(pessoaVO.getKey())).withSelfRel());
		return pessoaVO;
	}
	
	@ApiOperation(value = "Exclui uma pessoa da base de dados.")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirPessoa(@PathVariable("id") Long id) {
		pessoaService.excluirPessoa(id);
		return ResponseEntity.ok().build();
	}

}
