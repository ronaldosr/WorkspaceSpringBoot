package br.com.ronaldosr.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.ronaldosr.data.model.Pessoa;
import br.com.ronaldosr.data.vo.PessoaVO;

public class MockPessoa {

	public Pessoa mockEntity() {
		return mockEntity(0);
	}
	
	public PessoaVO mockVO() {
		return mockVO(0);
	}
	
	public List<Pessoa> mockEntityList() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (int i = 0; i < 14; i++) {
			pessoas.add(mockEntity(i));			
		}
		return pessoas;
	}
	
	public List<PessoaVO> mockVOList() {
		List<PessoaVO> pessoas = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			pessoas.add(mockVO(i));
		}
		return pessoas;
	}
	
	private Pessoa mockEntity(Integer number) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(number.longValue());
		pessoa.setEndereco("Endereço de teste " + number);
		pessoa.setPrimeiroNome("Primeiro nome teste " + number);
		pessoa.setSegundoNome("Segundo nome teste " + number);
		pessoa.setSexo(((number % 2) == 0 ) ? "Masculino" : "Feminino");
		pessoa.setEmail("email" + number + "@.dominio.com.br");
		pessoa.setCpf("278.283.578-50");
		return pessoa;
	}
	
	private PessoaVO mockVO(Integer number) {
		PessoaVO pessoa = new PessoaVO();
		pessoa.setId(number.longValue());
		pessoa.setEndereco("Endereço de teste " + number);
		pessoa.setPrimeiroNome("Primeiro nome teste " + number);
		pessoa.setSegundoNome("Segundo nome teste " + number);
		pessoa.setSexo(((number % 2) == 0 ) ? "Masculino" : "Feminino");
		pessoa.setEmail("email" + number + "@.dominio.com.br");
		pessoa.setCpf("278.283.578-50");
		return pessoa;
	}
}
