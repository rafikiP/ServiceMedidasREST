package servico.medidas;

public class Link {
  private String titulo;
  public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getLink() {
	return link;
}

public void setLink(String link) {
	this.link = link;
}

private String link;
  
  public Link(String titulo, String link)
  {
	  this.titulo=titulo;
	  this.link=link;
  }
}
