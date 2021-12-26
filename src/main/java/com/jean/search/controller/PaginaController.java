package com.jean.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jean.search.entities.Pagina;
import com.jean.search.services.PaginaSevices;

@Controller
@RequestMapping("/meta")
public class PaginaController {

	@Autowired
	private PaginaSevices service;
	
	@PostMapping("/info")
	public ResponseEntity<Pagina> getPaginaDados(@RequestParam("url")String url){
		
		Pagina pagina = service.getPagina(url);
		return pagina != null ? ResponseEntity.ok(pagina) : ResponseEntity.notFound().build();
		
	}
}
