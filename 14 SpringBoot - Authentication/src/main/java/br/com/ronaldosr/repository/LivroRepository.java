package br.com.ronaldosr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ronaldosr.data.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

//	@Query("SELECT A FROM Livro A WHERE A.autor LIKE CONCAT('%', :autor, '%')")
//	List<Livro> findByAutorLike(@Param("autor") String autor);
	List<Livro> findByAutorContaining(String autor);
	
	List<Livro> findByTituloContaining(String titulo);
}
