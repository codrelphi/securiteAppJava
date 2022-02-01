/**
 * ProduitWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.service;

public interface ProduitWS extends java.rmi.Remote {
    public void addProduit(fr.service.Produit produit) throws java.rmi.RemoteException;
    public fr.service.Produit[] getProduits() throws java.rmi.RemoteException;
    public fr.service.Produit getProduit(java.lang.String code) throws java.rmi.RemoteException;
}
