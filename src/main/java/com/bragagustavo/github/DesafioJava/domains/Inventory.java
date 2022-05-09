package com.bragagustavo.github.DesafioJava.domains;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @Column(name = "quantity")
    private Integer quantity = 0;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "warehouses_id")
    private List<Warehouses> warehouses = new ArrayList<>();

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



    public int calculaQuantidade(){
        Warehouses total = warehouses.get(quantity);
        this.quantity += total.getQuantity();
        return total.getQuantity().intValue();
    }

}
