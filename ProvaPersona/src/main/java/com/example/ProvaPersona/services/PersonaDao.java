package com.example.ProvaPersona.services;




import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.example.ProvaPersona.model.Persona;

// autowired della classe personaCrud per poter utilizzare i metodi che ha ereditato dalla JPArepository ed effettuare quindi le operazioni di Dao

@Repository
@Transactional
public class PersonaDao{
	@Autowired
	PersonaCrud personaCrud;

	@PersistenceContext
	EntityManager entity;
	public void inserimento(Persona p) {
		entity.persist(p);
	}
	public Persona ricercaById(int id)
	{
		Persona p = new Persona();
		p=entity.find(Persona.class, id);
		return p;
	}
	
	public Persona modifica(Persona p) {
		return personaCrud.saveAndFlush(p) ;
	}
		
	
	public List<Persona> findAll() {
		return personaCrud.findAll() ;
	}
	
	public Optional<Persona> findById(Integer id) {
		return personaCrud.findById(id);
	}

	public void deleteById(Integer id) {
		personaCrud.deleteById(id);
		return;	
	}
	
}
