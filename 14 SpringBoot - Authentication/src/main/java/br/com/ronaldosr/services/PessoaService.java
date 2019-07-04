package br.com.ronaldosr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ronaldosr.converter.DozerConverter;
import br.com.ronaldosr.data.model.Pessoa;
import br.com.ronaldosr.data.vo.v1.PessoaVO;
import br.com.ronaldosr.exception.RecursoNaoDisponivelException;
import br.com.ronaldosr.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	/**
	 * Cria uma nova Pessoa
	 * @param pessoa
	 * @return Pessoa
	 */
	public PessoaVO novaPessoa(PessoaVO pessoa) {
//		Pessoa entity = DozerConverter.parseObject(pessoa, Pessoa.class);
//		PessoaVO vo = DozerConverter.parseObject(pessoaRepository.save(entity), PessoaVO.class);
		var entity = DozerConverter.parseObject(pessoa, Pessoa.class);
		var vo = DozerConverter.parseObject(pessoaRepository.save(entity), PessoaVO.class);				
		return vo;
	}
	
	/**
	 * Listar todas as Pessoas cadastradas
	 * @return Lista<Pessoa>
	 */
	public List<PessoaVO> findAll(){
		return DozerConverter.parseListObjects(pessoaRepository.findAll(), PessoaVO.class);
	}
	
	/**
	 * Encontra uma Pessoa para o ID informado
	 * @param id
	 * @return Pessoa
	 */
	public PessoaVO findById(Long id) {
		var entity = pessoaRepository.findById(id)
			         .orElseThrow(() -> new RecursoNaoDisponivelException("Não há registros para a chave informada!"));
		return DozerConverter.parseObject(entity, PessoaVO.class);
	}
	
	/**
	 * Encontra uma lista de Pessoas de acordo com o CPF
	 * @param cpf
	 * @return Lista<Pessoa>
	 */
	public List<PessoaVO> findByCpf(String cpf) {
		if (pessoaRepository.findByCpf(cpf).isEmpty()) {
			return null;
		}
		
		var entity = pessoaRepository.findByCpf(cpf);
		return DozerConverter.parseListObjects(entity, PessoaVO.class);
	}
	
	/**
	 * Encontra uma lista de Pessoas de acordo com o E-Mail
	 * @param email
	 * @return Lista<Pessoa>
	 */
	public PessoaVO findByEmail(String email) {
		var entity = pessoaRepository.findByEmail(email)
                     .orElseThrow(() -> new RecursoNaoDisponivelException("Não há registros para a chave informada!"));
		return DozerConverter.parseObject(entity, PessoaVO.class);
	}
	
	/**
	 * Atualiza dos dados de uma Pessoa de acordo com o ID informado
	 * @param pessoa
	 * @return Pessoa Atualizada
	 */
	public PessoaVO atualizarPessoa(PessoaVO pessoa) {
		var pessoaAtual = pessoaRepository.findById(pessoa.getKey())
				   .orElseThrow(() -> new RecursoNaoDisponivelException("Não há registros para a chave informada!"));
		pessoaAtual.setPrimeiroNome(pessoa.getPrimeiroNome());
		pessoaAtual.setSegundoNome(pessoa.getSegundoNome());
		pessoaAtual.setEndereco(pessoa.getEndereco());
		pessoaAtual.setSexo(pessoa.getSexo());
		pessoaAtual.setCpf(pessoa.getCpf());
		pessoaAtual.setEmail(pessoa.getEmail());
		var vo = DozerConverter.parseObject(pessoaRepository.save(pessoaAtual), PessoaVO.class);
		return vo;
	}
	
	/**
	 * Excluir uma Pessoa de acordo com o ID informado
	 * @param id
	 */
	public ResponseEntity<?> excluirPessoa(Long id) {
		Pessoa pessoa = pessoaRepository.findById(id)
				   .orElseThrow(() -> new RecursoNaoDisponivelException("Não há registros para a chave informada!"));
		pessoaRepository.delete(pessoa);
		return ResponseEntity.ok().build();
	}

}
