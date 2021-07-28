package com.one.digitalinnovation.primeiraapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.one.digitalinnovation.primeiraapi.models.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	Produto findByNome(String nome);

}
