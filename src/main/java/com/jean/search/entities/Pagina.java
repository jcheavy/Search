package com.jean.search.entities;

public class Pagina {
	
	private Integer id;
	private String title;
	private String url;
	private String description;
	
	public Pagina() {
		
	}
	
	public Pagina( String title, String url, String description) {		
		this.title = title;
		this.url = url;
		this.description = description;
	}

	public Pagina(Integer id, String title, String url, String description) {
		this.id = id;
		this.title = title;
		this.url = url;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagina other = (Pagina) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pagina [id=" + id + ", title=" + title + ", url=" + url + ", description=" + description + "]";
	}
   	

}
