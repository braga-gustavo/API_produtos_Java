package com.bragagustavo.github.DesafioJava.domains;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produtos")
public class Produto {

    @Id
    private Integer sku;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @JsonIgnore
    @Column(name = "isMarketable")
    private Boolean isMarketable;

    public Produto(int sku, String inventory) {
        this.sku = sku;

    }

    public Produto(int sku, Inventory inventory) {
        this.sku = sku;
        this.inventory = inventory;
    }


    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        inventory.calculaQuantidade();
        if (inventory.getQuantity() > 0){
            setIsMarketable(true);
        }
        this.inventory = inventory;
    }

    public void setInventory() {
        inventory.calculaQuantidade();
        if (inventory.getQuantity() > 0){
            setIsMarketable(true);
        }
        this.inventory = inventory;
    }


}
