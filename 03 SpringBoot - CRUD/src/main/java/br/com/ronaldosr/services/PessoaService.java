package br.com.ronaldosr.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.ronaldosr.model.Pessoa;

@Service
public class PessoaService {

	private final AtomicLong counter = new AtomicLong();
	
	public Pessoa novaPessoa(Pessoa pessoa) {
		return pessoa;
	}
	
	public Pessoa atualizarPessoa(Pessoa pessoa) {
		return pessoa;
	}
	
	public void excluirPessoa(String id) {
	}
	
	public Pessoa findById(String id) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(counter.incrementAndGet());
		pessoa.setPrimeiroNome("Ronaldo");
		pessoa.setSegundoNome("Rodrigues");
		pessoa.setEndereco("São Paulo - São Paulo - Brasil");
		pessoa.setSexo("Masculino");
		
		return pessoa ;
	}
	
	public List<Pessoa> findAll(){
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (int i = 0; i < 8; i++) {
			Pessoa pessoa = mockPessoa(i);
			pessoas.add(pessoa);
		}
		return pessoas;		
	}

	private Pessoa mockPessoa(int i) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(counter.incrementAndGet());
		pessoa.setPrimeiroNome("Primeiro nome " + i);
		pessoa.setSegundoNome("Segundo nome " + i);
		pessoa.setEndereco("São Paulo - São Paulo - Brasil " + i);
		pessoa.setSexo("Masculino " + i);
		
		return pessoa ;
	}
}
