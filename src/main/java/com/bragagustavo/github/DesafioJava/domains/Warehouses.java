package com.bragagustavo.github.DesafioJava.domains;
import com.bragagustavo.github.DesafioJava.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "warehouses")
public class Warehouses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "locality")
    private String locality;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "type")
    private Type type;

    public Integer getId() {
        return id;
    }

    public String getLocality() {
        return locality;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Type getType() {
        return type;
    }
}
