package br.com.ronaldosr.converter.custom;

import org.springframework.stereotype.Service;

import br.com.ronaldosr.data.model.Pessoa;
import br.com.ronaldosr.data.vo.v2.PessoaVOV2;

@Service
public class PessoaConverter {

	public PessoaVOV2 converterEntidadeVo(Pessoa pessoa) {
		PessoaVOV2 vo = new PessoaVOV2();
		vo.setId(pessoa.getId());
		vo.setCpf(pessoa.getCpf());
		vo.setDataNascimento(pessoa.getDataNascimento());
		vo.setEmail(pessoa.getEmail());
		vo.setEndereco(pessoa.getEndereco());
		vo.setPrimeiroNome(pessoa.getPrimeiroNome());
		vo.setSegundoNome(pessoa.getSegundoNome());
		vo.setSexo(pessoa.getSexo());
		return vo ;
	}
	
	public Pessoa converterVoEntidade(PessoaVOV2 pessoa) {
		Pessoa entidade = new Pessoa();
		entidade.setId(pessoa.getId());
		entidade.setCpf(pessoa.getCpf());
		entidade.setEmail(pessoa.getEmail());
		entidade.setEndereco(pessoa.getEndereco());
		entidade.setPrimeiroNome(pessoa.getPrimeiroNome());
		entidade.setSegundoNome(pessoa.getSegundoNome());
		entidade.setSexo(pessoa.getSexo());
		entidade.setDataNascimento(pessoa.getDataNascimento());
		return entidade ;
	}	
	
}
