package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Produit implements Serializable {

	private String code;
	private String description;
	private double prix;
	
	public Produit() {}

	public Produit(String code) {
		this.code = code;
		this.description = "Pas de description !";
		this.prix = 5;
	}

	public Produit(String code, String description) {
		this(code);
		this.description = description;
	}

	public Produit(String code, String description, double prix) {
		this(code, description);
		this.prix = prix;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Produit [code=" + code + ", description=" + description + ", prix=" + prix + "]";
	}
	
	
}
