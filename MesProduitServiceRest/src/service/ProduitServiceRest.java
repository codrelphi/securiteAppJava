package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Produit;

@Path("/produitWS")
public class ProduitServiceRest {

	// List: [p1(code), p2, p1(code)]
	// Map<k, v> => k=code, v= produit(code, des, prix)
	
	private static Map<String, Produit> produits = new HashMap<String, Produit>(); // variable de classe = une instance pour tout le monde
	
	public ProduitServiceRest() {
		
		Produit p1 = new Produit("1", "Produit 1", 1000);
		Produit p2 = new Produit("2", "Produit 2", 2000);
		Produit p3 = new Produit("3", "Produit 3", 3000);
		
		produits.put(p1.getCode(), p1);
		produits.put(p2.getCode(), p2);
		produits.put(p3.getCode(), p3);
		
	}
	
	// lister tous nos produits
	@GET
	@Path("/produits")
	@Produces(value= {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Produit> getProduits() {
		
		List<Produit> tempProduits = new ArrayList<>(produits.values());
		return tempProduits;
	}
	
	// avoir un produit en se basant sur son code
	// http://localhost:8080/ProduitWS/produits/2
	@GET
	@Path("/produits/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Produit getProduit(@PathParam(value="code") String code) {
		return produits.get(code);
	}
	
	// juste pour tester
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_HTML)
	public String helloWorld() {
		return "<h1 style=\"color:red\">Hello World</h1>";
	}
	
	// ajouter un produit
	// mise à jour
	// supprimer
	
	
}
