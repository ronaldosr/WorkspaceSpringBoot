package br.com.ronaldosr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ronaldosr.exception.RecursoNaoDisponivelException;
import br.com.ronaldosr.model.Pessoa;
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
	public Pessoa novaPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	/**
	 * Listar todas as Pessoas cadastradas
	 * @return Lista<Pessoa>
	 */
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll();
	}
	
	/**
	 * Encontra uma Pessoa para o ID informado
	 * @param id
	 * @return Pessoa
	 */
	public Pessoa findById(Long id) {
		return pessoaRepository.findById(id)
			   .orElseThrow(() -> new RecursoNaoDisponivelException("Não há registros para a chave informada!"));
	}
	
	/**
	 * Encontra uma lista de Pessoas de acordo com o CPF
	 * @param cpf
	 * @return Lista<Pessoa>
	 */
	public List<Pessoa> findByCpf(String cpf) {
		return pessoaRepository.findByCpf(cpf);
	}
	
	/**
	 * Encontra uma lista de Pessoas de acordo com o E-Mail
	 * @param email
	 * @return Lista<Pessoa>
	 */
	public Pessoa findByEmail(String email) {
		return pessoaRepository.findByEmail(email)
			   .orElseThrow(() -> new RecursoNaoDisponivelException("Não há registros para a chave informada!"));
	}
	
	/**
	 * Atualiza dos dados de uma Pessoa de acordo com o ID informado
	 * @param pessoa
	 * @return Pessoa Atualizada
	 */
	public Pessoa atualizarPessoa(Pessoa pessoa) {
		Pessoa pessoaAtual = pessoaRepository.findById(pessoa.getId())
				   .orElseThrow(() -> new RecursoNaoDisponivelException("Não há registros para a chave informada!"));
		pessoaAtual.setPrimeiroNome(pessoa.getPrimeiroNome());
		pessoaAtual.setSegundoNome(pessoa.getSegundoNome());
		pessoaAtual.setEndereco(pessoa.getEndereco());
		pessoaAtual.setSexo(pessoa.getSexo());
		pessoaAtual.setCpf(pessoa.getCpf());
		pessoaAtual.setEmail(pessoa.getEmail());
		return pessoaRepository.save(pessoaAtual);
	}
	
	/**
	 * Excluir uma Pessoa de acordo com o ID informado
	 * @param id
	 */
	public void excluirPessoa(Long id) {
		Pessoa pessoa = pessoaRepository.findById(id)
				   .orElseThrow(() -> new RecursoNaoDisponivelException("Não há registros para a chave informada!"));
		pessoaRepository.delete(pessoa);
	}

}
