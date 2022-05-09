package com.bragagustavo.github.DesafioJava.repository;

import com.bragagustavo.github.DesafioJava.domains.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produto, Integer> {

}
