package com.example.ProvaPersona.services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.example.ProvaPersona.model.Persona;

// creazione dell interfaccia che estende la jparepository per utilizzare i metodi che possiede
public interface PersonaCrud extends JpaRepository<Persona,Integer> {

}
