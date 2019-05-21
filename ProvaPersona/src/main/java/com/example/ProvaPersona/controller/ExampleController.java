package com.example.ProvaPersona.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.example.ProvaPersona.model.Persona;
import com.example.ProvaPersona.services.PersonaCrud;
import com.example.ProvaPersona.services.PersonaDao;



@Controller
@RequestMapping("/index")
public class ExampleController {
	
	@Autowired
	PersonaDao pd;

	@Bean // bean per il collegamento con la cartella jsp e la lettura dei file jsp che contiene
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    bean.setViewClass(JstlView.class);
	    bean.setPrefix("/jsp/");
	    bean.setSuffix(".jsp");
	    return bean;
	}
	
	@RequestMapping( value="/FormPersona" , method=RequestMethod.POST) // metodo per inserimento a db della persona
	public String inserisci(@RequestParam String nome,
							@RequestParam String cognome,
							@RequestParam String eta,
							ModelMap model, HttpServletRequest request) 
	{	
		Persona p = new Persona();
		p.setNome(nome);
		p.setCognome(cognome);
		p.setEta(Integer.parseInt(eta));
		System.out.println(p);
		pd.inserimento(p);
		model.addAttribute("p",p);
		model.addAttribute("nome",nome);
		model.addAttribute("cognome",cognome);
		return "inserito2";	
	}
		
	@RequestMapping( value="/ListaPersona" , method=RequestMethod.GET) // metodo per la stampa della lista completa di tutte le persone presenti a db
	public String stampa(//@ModelAttribute Persona p,
							ModelMap model, HttpServletRequest request) 
	{	
		List<Persona> persone =(List<Persona>) pd.findAll();
		model.addAttribute("persone",persone);
		return "lista";
	}
	
	
	@RequestMapping( value="/cercaPersona" , method=RequestMethod.GET)// metodo per la ricerca di una persona tramite id
	public String cerca(@RequestParam String id,
						ModelMap model, HttpServletRequest request) 
	{	
		int flagId = Integer.parseInt(request.getParameter("id"));
		Persona p = pd.ricercaById(flagId);
		model.addAttribute("p",p);
		return "trovato";	
	}
	
	@RequestMapping( value="/elimina" , method=RequestMethod.POST)//metodo per eliminare una persona trovata tramite id
	public String elimina(@RequestParam String id,
						ModelMap model, HttpServletRequest request) 
	{	int flagId = Integer.parseInt(request.getParameter("id"));
		Persona p = pd.ricercaById(flagId);
		pd.deleteById(flagId);
		return "eliminato";	
	}
	
	@RequestMapping( value="/modificaId" , method=RequestMethod.POST) //metodo per ricercare la persona da modificare tramite id e stampare i campi da modificare
	public String modifica(@RequestParam String id,
						ModelMap model, HttpServletRequest request) 
	{	int flagId = Integer.parseInt(request.getParameter("id"));
		Persona p = pd.ricercaById(flagId);
		model.addAttribute("p",p);
		return "modifica";	
	}
	
	@RequestMapping( value="/modifica" , method=RequestMethod.POST)// metodo per effettuare effettivamente la modifica dei dati modificati con il metodo "modificaID" 
	public String modificato(
							@RequestParam String id,
							@RequestParam String nome,
							@RequestParam String cognome,
							@RequestParam String eta,
							ModelMap model, HttpServletRequest request) 
	{	
		Persona p = new Persona();
		int flagId = Integer.parseInt(request.getParameter("id"));
		p.setId(flagId);
		p.setNome(nome);
		p.setCognome(cognome);
		p.setEta(Integer.parseInt(eta));
		System.out.println(p);
		pd.modifica(p);
		model.addAttribute("p",p);
		
		return "modificato";	
	}
	
	@RequestMapping( value="/scheda" , method=RequestMethod.POST) // metodo per stampare la scheda anagrafica della persona selezionata tramite id
	public String scheda(@RequestParam String id,
						ModelMap model, HttpServletRequest request) 
	{	int flagId = Integer.parseInt(request.getParameter("id"));
		Persona p = pd.ricercaById(flagId);
		model.addAttribute("p",p);
		return "scheda";	
	}
	
}
