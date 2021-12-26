package com.jean.search.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jean.search.entities.Site;
import com.jean.search.repositories.SiteRepository;

@Service
public class SiteService {
	
	@Autowired
	private SiteRepository siteRepository;
	
	
	public void salvar(Site site) {
		siteRepository.save(site);
	}
	
	public List<Site> listar(){		
		return siteRepository.findAll();		
	}

}
