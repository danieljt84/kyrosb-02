package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Cliente;

@Repository

public interface ClienteRepository<T extends Cliente>  extends JpaRepository<T, Long> {

}
