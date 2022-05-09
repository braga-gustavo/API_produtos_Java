package com.bragagustavo.github.DesafioJava.repository;

import com.bragagustavo.github.DesafioJava.domains.Warehouses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface WarehousesRepository extends JpaRepository<Warehouses, Integer> {

}
