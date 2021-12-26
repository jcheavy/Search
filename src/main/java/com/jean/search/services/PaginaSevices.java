package com.jean.search.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jean.search.entities.Pagina;

@Service
public class PaginaSevices {
	
	private static Logger logger = LoggerFactory.getLogger(Pagina.class);
	
	public Pagina getPagina(String url) {		
		Pagina pagina = null;		
		try {
			 
			Document doc = Jsoup.connect(url).get();
			 pagina = new Pagina(doc.title(), url, doc.head().select("meta[name=description]").attr("content"));			
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getCause());
		}
		
		return pagina;
		
	}

}
