package com.dev.cartorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.cartorio.model.Cartorio;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Long>{

}
