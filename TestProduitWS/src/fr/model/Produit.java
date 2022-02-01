package fr.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Produit {

	private String code;
	private String description;
	private double prix;
	
	public Produit() {}

	public Produit(String code) {
		super();
		this.code = code;
		this.description = "Pas de description !";
		this.prix = 5;
	}

	public Produit(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public Produit(String code, String description, double prix) {
		super();
		this.code = code;
		this.description = description;
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
	
	
	
	
	
}
