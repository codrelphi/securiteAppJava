package fr.client.metier;

import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import fr.service.Produit;
import fr.service.ProduitServiceServiceLocator;
import fr.service.ProduitWS;

public class ProduitClient {

	public static void main(String[] args) {
		
		// afficher liste des produits
		
		try {
			ProduitWS stub = new ProduitServiceServiceLocator().getProduitWSPort();
			
			System.out.println("\nLa liste des produits: \n");
			try {
				for (Produit p : stub.getProduits()) {
					System.out.println("Code : " + p.getCode());
					System.out.println("Description : " + p.getDescription());
					System.out.println("Prix : " + p.getPrix());
					System.out.println("-------------------------------");
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		

	}

}
