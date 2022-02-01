package fr.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.model.Produit;

@WebService(name="ProduitWS")
public class ProduitService {
	
	
	List<Produit> produits = new ArrayList<Produit>();
	
	public ProduitService() {
		Produit p1 = new Produit("1", "C'est le produit 1", 1000);
		Produit p2 = new Produit("2", "C'est le produit 2", 20000);
		Produit p3 = new Produit("3", "C'est le produit 3", 3500);
		
		produits.add(p1);
		produits.add(p2);
		produits.add(p3);
	}
	
	@WebMethod
	public List<Produit> getProduits() {
		// pour retourner tous les produits
		
		return produits;
	}
	
	@WebMethod
	public Produit getProduit(@WebParam(name="code") String c) {
		// pour retourner 1 seul produit
		
		return new Produit(c);
	}
	
	@WebMethod
	public void addProduit(@WebParam(name="produit") Produit p) {
		// ajouter 1 produit
		
		produits.add(p);
	}
}
