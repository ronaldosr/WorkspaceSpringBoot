package br.com.ronaldosr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ronaldosr.data.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	List<Pessoa> findByCpf(String cpf);
	
	Optional<Pessoa> findByEmail(String email);

	@Modifying
	@Query("UPDATE Pessoa p SET p.enabled = false WHERE p.id = :id")
	void desabilitarPessoa(@Param("id") Long id);
	
	@Query("SELECT p FROM Pessoa p WHERE p.primeiroNome LIKE LOWER(CONCAT('%', :primeiroNome, '%'))")
	Page<Pessoa> listarPessoaPorNome(@Param("primeiroNome") String primeiroNome, Pageable pageable);
}