package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	/*@GET
	@Path("/produits")
	@Produces(value= {MediaType.APPLICATION_JSON})
	public List<Produit> getProduits() {
		
		List<Produit> tempProduits = new ArrayList<>(produits.values());
		return tempProduits;
	}*/
	
	@GET
	@Path("/produits")
	@Produces(value= {MediaType.APPLICATION_JSON})
	public Response getProduits() {
		
		List<Produit> tempProduits = new ArrayList<>(produits.values());
		return Response.ok(tempProduits).header("Access-Control-Allow-Origin", "*").build();
	}
	
	// avoir un produit en se basant sur son code
	// http://localhost:8080/ProduitWS/produits/2
	@GET
	@Path("/produits/{code}")
	@Produces(value= {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Produit getProduit(@PathParam(value="code") String code) {
		return produits.get(code);
	}
	
	// juste pour tester
	@GET
	@Path("/hello")
	@Produces({MediaType.TEXT_PLAIN, MediaType.TEXT_HTML})
	public String helloWorld() {
		return "<h1 style=\"color:red\">Hello World</h1>";
	}
	
	// ajouter un produit
	@POST
	@Path("/produits")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	/*@Produces({MediaType.TEXT_PLAIN})*/
	public Produit addProduit(Produit p) {
		
		String c = p.getCode();
		Produit newP = null;
		if (c == null) {
			// si on fournit un produit n'ayant pas un code
			// alors le code est généré avec un algorithme pseudo-aléatoire (voir le modèle Produit)
			// Exemple:
			/* {
		        "description": "Produit 4",
		        "prix": 1000.0
			} */
			
			newP = new Produit(p.getDescription(), p.getPrix());
			produits.put(newP.getCode(), newP);
			return produits.get(newP.getCode());
		}
	
		// si on fournit un produit avec code, 
		// alors l'ajout se fait directement
		// Exemple: 
		/* {
		        "code": "4",
		        "description": "Produit 4",
		        "prix": 1000.0
				} */
			
		// on pouvait utiliser la variable c directement
		produits.put(p.getCode(), p);
		return produits.get(p.getCode());

	}
	
	// modifier un produit via son code
	@PUT
	@Path("/produits/{code}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public boolean updateProduit(@PathParam(value="code") String code, Produit p) {
		//p.setCode(code);
		
		if (code.equals(p.getCode())) {
			produits.put(code, p);
			return true;
		}
		else {
			return false;
		}
		//return produits.get(p.getCode());
	}
	
	// supprimer
	@DELETE
	@Path("/produits/{code}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public boolean deleteProduit(@PathParam(value="code") String code) {
		
		if (produits.get(code) != null) {
			// le produit avec code <code> existe
			produits.remove(code);
			return true;
		}
		else {
			// ce produit n'existe pas
			return false;
		}
	}
	
}
