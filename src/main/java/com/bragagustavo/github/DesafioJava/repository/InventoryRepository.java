package com.bragagustavo.github.DesafioJava.repository;

import com.bragagustavo.github.DesafioJava.domains.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {



}
