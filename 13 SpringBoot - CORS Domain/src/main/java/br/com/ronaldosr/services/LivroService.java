package br.com.ronaldosr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ronaldosr.converter.DozerConverter;
import br.com.ronaldosr.data.model.Livro;
import br.com.ronaldosr.data.vo.v1.LivroVO;
import br.com.ronaldosr.exception.RecursoNaoDisponivelException;
import br.com.ronaldosr.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;
	
	public LivroVO novoLivro(LivroVO livro) {
		var entity = DozerConverter.parseObject(livro, Livro.class);
		var vo = DozerConverter.parseObject(livroRepository.save(entity), LivroVO.class);
		return vo;
	}
	
	public List<LivroVO> findAll(){
		return DozerConverter.parseListObjects(livroRepository.findAll(), LivroVO.class);
	}
	
	public LivroVO findById(Long id) {
		var entity = livroRepository.findById(id)
				     .orElseThrow(() -> new RecursoNaoDisponivelException("Não há registros para a chave informada"));
		return DozerConverter.parseObject(entity, LivroVO.class);
	}
	
	public List<LivroVO> findByAutorContaining(String autor){
		if (livroRepository.findByAutorContaining(autor).isEmpty()) {
			return null;
		}
		var entity = livroRepository.findByAutorContaining(autor);
		return DozerConverter.parseListObjects(entity, LivroVO.class);
	}
	
	public List<LivroVO> findByTituloContaining(String titulo) {
		if (livroRepository.findByTituloContaining(titulo).isEmpty()) {
			return null;
		}
		var entity = livroRepository.findByTituloContaining(titulo);
		return DozerConverter.parseListObjects(entity, LivroVO.class);
	}
	
	public LivroVO atualizarLivro(LivroVO livro) {
		var livroAtual = livroRepository.findById(livro.getKey())
						 .orElseThrow(() -> new RecursoNaoDisponivelException("Não há registros para a chave informada!"));
		livroAtual.setAutor(livro.getAutor());
		livroAtual.setDataPublicacao(livro.getDataPublicacao());
		livroAtual.setPreco(livro.getPreco());
		livroAtual.setTitulo(livro.getTitulo());
		var vo = DozerConverter.parseObject(livroRepository.save(livroAtual), LivroVO.class);
		return vo;
	}
	
	public ResponseEntity<?> excluirLivro(Long id) {
		Livro livro = livroRepository.findById(id)
				      .orElseThrow(() -> new RecursoNaoDisponivelException("Não há registros para a chave informada!"));
		livroRepository.delete(livro);
		return ResponseEntity.ok().build(); 
	}
}
