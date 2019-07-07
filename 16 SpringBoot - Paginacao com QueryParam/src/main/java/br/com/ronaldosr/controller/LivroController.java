package br.com.ronaldosr.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ronaldosr.data.vo.v1.LivroVO;
import br.com.ronaldosr.services.LivroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Endpoint Livro",
     description = "Permite o cadastramento, consulta, atualização e exclusão de um Livro",
     tags = {"Endpoint Livro"})
@RestController
@RequestMapping(value = "/api/livro/v1")
public class LivroController {

	@Autowired
	private LivroService livroService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "Retorna uma lista com todos os livros cadastrados na base.")
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public ResponseEntity<PagedResources<LivroVO>> findAll(
			@RequestParam(value = "pagina", defaultValue = "0") int pagina,
			@RequestParam(value = "limite", defaultValue = "10") int limite,
			@RequestParam(value = "ordem", defaultValue = "asc") String ordem,
			@SuppressWarnings("rawtypes") PagedResourcesAssembler assembler) {
		
		var sortOrdem = "desc".equalsIgnoreCase(ordem) ? Direction.DESC : Direction.ASC;
		Pageable pageable = PageRequest.of(pagina,  limite, Sort.by(sortOrdem, "autor"));
		
		Page<LivroVO> livros = livroService.findAll(pageable);
		livros
			.stream()
			.forEach(p -> p.add(
						linkTo(methodOn(LivroController.class).findById(p.getKey())).withSelfRel()
					)
			);
		return new ResponseEntity<PagedResources<LivroVO>>(assembler.toResource(livros), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Retorna os dados de um livro.")
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public LivroVO findById(@PathVariable("id") Long id) {
		LivroVO livroVO = livroService.findById(id);
		livroVO.add(linkTo(methodOn(LivroController.class).findById(id)).withSelfRel());
		return livroVO;	
	}
	
	@ApiOperation(value = "Retorna uma lista de livros de acordo com o autor.")
	@GetMapping(value = "/autor/{autor}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<LivroVO> findByAutorContaining(@PathVariable("autor") String autor) {
		List<LivroVO> livros = livroService.findByAutorContaining(autor);
		livros
			.stream()
			.forEach(p -> p.add(
						linkTo(methodOn(LivroController.class).findByAutorContaining(p.getAutor())).withSelfRel()
					)
			);
		return livros;
	}
	
	@ApiOperation(value = "Retorna uma lista de livros de acordo com o Título.")
	@GetMapping(value = "/titulo/{titulo}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<LivroVO> findByTituloContaining(@PathVariable("titulo") String titulo) {
		List<LivroVO> livros = livroService.findByTituloContaining(titulo);
		livros
			.stream()
			.forEach(p -> p.add(
						linkTo(methodOn(LivroController.class).findByTituloContaining(p.getTitulo())).withSelfRel()
					)
			);
		return livros;
	}
	
	@ApiOperation(value = "Grava um novo livro na base de dados.")
	@PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
			     consumes = {"application/json", "application/xml", "application/x-yaml"})
	public LivroVO novoLivro(@RequestBody LivroVO livro) {
		LivroVO livroVO = livroService.novoLivro(livro);
		livroVO.add(linkTo(methodOn(LivroController.class).findById(livroVO.getKey())).withSelfRel());
		return livroVO;
	}
	
	@ApiOperation(value = "Atualiza um livro na base de dados.")
	@PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
		        consumes = {"application/json", "application/xml", "application/x-yaml"})
	public LivroVO atualizarLivro(@RequestBody LivroVO livro) {
		LivroVO livroVO = livroService.atualizarLivro(livro);
		livroVO.add(linkTo(methodOn(LivroController.class).findById(livroVO.getKey())).withSelfRel());
		return livroVO;
	}
	
	@ApiOperation(value = "Exclui um livro da base de dados.")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirLivro(@PathVariable("id") Long id) {
		livroService.excluirLivro(id);
		return ResponseEntity.ok().build();
	}
}
