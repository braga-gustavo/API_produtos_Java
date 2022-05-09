package com.bragagustavo.github.DesafioJava.controller;

import com.bragagustavo.github.DesafioJava.domains.Inventory;
import com.bragagustavo.github.DesafioJava.domains.Produto;
import com.bragagustavo.github.DesafioJava.domains.Warehouses;
import com.bragagustavo.github.DesafioJava.dto.ProdutoDto;
import com.bragagustavo.github.DesafioJava.repository.ProdutosRepository;
import com.bragagustavo.github.DesafioJava.service.ProdutoService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produto")
public class ProdutosController {

    @Autowired
    private ProdutosRepository produtosRepository;

    static ProdutoService produtoService;



    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertProdutos(@RequestBody Produto produto) {
            produto.setIsMarketable(true);
            produtosRepository.save(produto);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{sku}")
                    .buildAndExpand(produto.getSku()).toUri();
            return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{sku}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateProduto(@PathVariable Integer sku, @Valid @RequestBody ProdutoDto produtoDto){
        Produto produto = produtoService.fromDto(produtoDto);
        produto.setSku(sku);
        produtoService.updateProduto(produto);
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "/{sku}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduto(@PathVariable Integer sku) {
        produtoService.deleteProduto(sku);
        return ResponseEntity.noContent().build();
    }


    //TODO: REFAZER E VERIFICAR O CODIGO ABAIXO CONTROLLER FIND PRODUTO

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> findProdutos(@PathVariable Integer id){
        Produto produto = produtoService.findProduto(id);
        return ResponseEntity.ok().body(produto);
    }

    //TODO: REFAZER E VERIFICAR O CODIGO ABAIXO CONTROLLER FIND ALL

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.FOUND)
    public List<Produto> findAll(){
        return produtoService.findAll();
    }


}
