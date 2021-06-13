package br.com.ecommerce.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ecommerce.domain.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String>{

}
