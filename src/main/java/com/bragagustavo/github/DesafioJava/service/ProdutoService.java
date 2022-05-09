package com.bragagustavo.github.DesafioJava.service;

import com.bragagustavo.github.DesafioJava.controller.ProdutosController;
import com.bragagustavo.github.DesafioJava.domains.Produto;
import com.bragagustavo.github.DesafioJava.dto.ProdutoDto;
import com.bragagustavo.github.DesafioJava.exceptions.IllegalArgumentsException;
import com.bragagustavo.github.DesafioJava.exceptions.ObjectNotFoundException;
import com.bragagustavo.github.DesafioJava.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class ProdutoService {

    @Autowired
    private ProdutosRepository produtosRepository;

    @Autowired
    private ProdutosController produtosController;


    @Transactional
    public Produto inserirProduto(Produto produto) {
        produto.setSku(null);
        Produto produtoSalvo = produtosRepository.save(produto);
        return produtoSalvo;
    }

    public Produto updateProduto(Produto produto) {
        try {
            Produto produtoToUpdate = findProduto(produto.getSku());
            return produtosRepository.save(produtoToUpdate);

        } catch (
                DataIntegrityViolationException e) {
            throw new IllegalArgumentsException("Produto já existe");
        }

    }

    public void deleteProduto(Integer sku) {
        findProduto(sku);
        produtosRepository.deleteById(sku);
    }
    //TODO: REFAZER E VERIFICAR O CODIGO ABAIXO SERVICE FIND ALL

    public List<Produto> findAll(){
        return produtosRepository.findAll();
    }
    //TODO: REFAZER E VERIFICAR O CODIGO ABAIXO SERVICE FIND PRODUTO

    public Produto findProduto(Integer id){
        Optional<Produto> produto = produtosRepository.findById(id);
        return produto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontyrado! sku: "+ id +
                "tipo: " + Produto.class.getName()));
    }


    public Produto fromDto(ProdutoDto produtoDto) {
        return new Produto(produtoDto.getSku(),
                produtoDto.getInventory());


    }
}
