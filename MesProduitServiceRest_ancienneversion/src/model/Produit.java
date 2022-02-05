package model;

import java.io.Serializable;

//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
/*@XmlAccessorType(XmlAccessType.FIELD)*/
public class Produit implements Serializable {

	private String code;
	private String description;
	
	/*@XmlTransient*/
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
	
	public Produit(String description, double prix) {
		String alphabet = "abcdefghijklmnopqrstxyuvwz";
		int random100 = (int) (Math.random() * 100);
		int random100Modulo26 = random100 % 26;
		char leChar = alphabet.charAt(random100Modulo26);
		int isLowerOrUpper = (int) Math.random();
		if (isLowerOrUpper == 1) Character.toUpperCase(leChar);
	
		
		this.code = String.valueOf(leChar) + random100; // pseudo-random string
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

	@Override
	public String toString() {
		return "Produit [code=" + code + ", description=" + description + ", prix=" + prix + "]";
	}
	
	
}
