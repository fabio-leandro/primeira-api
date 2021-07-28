package com.one.digitalinnovation.primeiraapi.controller;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one.digitalinnovation.primeiraapi.models.Cliente;
import com.one.digitalinnovation.primeiraapi.models.Produto;
import com.one.digitalinnovation.primeiraapi.repository.ClienteRepository;
import com.one.digitalinnovation.primeiraapi.repository.ProdutoRepository;




@RestController
@RequestMapping(value="/api")
public class Controller {
	
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	
	
	@GetMapping("/produtos")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/clientes")
	public List<Cliente> listaClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/produtos/{id}")
	public Optional<Produto> listaUnicoProduto(@PathVariable(value="id") long id) {
		return produtoRepository.findById(id);
	}
	
	@GetMapping("/clientes/{nomeCliente}")
	public Cliente listaUnicoCliente(@PathVariable(value="nomeCliente") String nomeCliente) {
		return clienteRepository.findByNomeCliente(nomeCliente);
	}
	
	@GetMapping("/produtos/nome/{nome}")
	public Produto listaProdutoLetraInicial(@PathVariable(value="nome") String nome) {
		return produtoRepository.findByNome(nome);
	}
	
	
	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	//Deletando usando GetMapping
	@GetMapping("/produtos/delete/{id}")
	public List<Produto> deletarProduto(@PathVariable(value="id") long id) {
		produtoRepository.deleteById(id);
		return produtoRepository.findAll();
	}
	
	//Deletando usando o @DeleteMapping
	@DeleteMapping("/produto")
	public void deleteMapping(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
	
	@PutMapping("/produto")
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

}
