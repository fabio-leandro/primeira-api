package com.one.digitalinnovation.primeiraapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.one.digitalinnovation.primeiraapi.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findByNomeCliente(String nomeCliente);
	

}
