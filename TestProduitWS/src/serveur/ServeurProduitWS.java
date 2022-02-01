package serveur;

import javax.xml.ws.Endpoint;

import fr.service.ProduitService;

public class ServeurProduitWS {

	public static void main(String[] args) {
		
		// localhost ==> 127.0.0.1
		
		String url = "http://localhost:8484/";
		
		Endpoint.publish(url, new ProduitService());
		
		System.out.println("Serveur disponible à : " + url);

	}

}
