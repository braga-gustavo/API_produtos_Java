package com.bragagustavo.github.DesafioJava.dto;

import com.bragagustavo.github.DesafioJava.domains.Inventory;
import com.bragagustavo.github.DesafioJava.domains.Produto;

import javax.validation.constraints.NotEmpty;

public class ProdutoDto {

    private int sku;


    @NotEmpty(message = "Inventario nao pode ser vazio")
    private Inventory inventory;

    @NotEmpty(message = "Marquetavel nao pode ser vazio")
    private boolean isMarketable;


    public ProdutoDto(int sku, Inventory inventory, boolean isMarketable) {

        this.sku = sku;
        this.inventory = inventory;
        this.isMarketable = isMarketable;
    }

    public ProdutoDto(Produto produto){
        this.sku = produto.getSku();
        this.inventory = produto.getInventory();
        this.isMarketable = produto.getIsMarketable();

    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean isMarketable() {
        return isMarketable;
    }

    public void setMarketable(boolean marketable) {
        isMarketable = marketable;
    }
}
