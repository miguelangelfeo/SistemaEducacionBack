package com.example.sistemaEducativo.bd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteJPA extends JpaRepository<EstudianteORM, Long> {

}
