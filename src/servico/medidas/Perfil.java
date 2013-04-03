package servico.medidas;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Perfil {
	private String perfil;
	private String texto;
	private List<Link> links;
	
	public Perfil(){
		super();
	}

	public Perfil(String perfil, String texto, List<Link> links) {
		super();
		this.perfil = perfil;
		this.texto = texto;
		this.links = links;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

}
