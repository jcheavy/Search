package com.jean.search.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jean.search.entities.Site;
import com.jean.search.services.SiteService;

@Controller
@RequestMapping("/sites")
public class SiteController {
		
	Logger log = LoggerFactory.getLogger(Site.class);
	
	@Autowired
	SiteService siteService;
	
	@GetMapping("/add")
	public String initSite() {
		return "pagina-add";
	}

	@PostMapping("/save")
	public ResponseEntity<Site> salvar(Site site){
	    log.info("Site {}", site.toString());
	    siteService.salvar(site);
	    return ResponseEntity.ok().build();
	}
	
	@GetMapping("/list")
	public String ListarPages(ModelMap model) {
		model.addAttribute("sites", siteService.listar());
		return "pagina-list";
	}
}
