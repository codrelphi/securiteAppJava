package fr.service;

public class ProduitWSProxy implements fr.service.ProduitWS {
  private String _endpoint = null;
  private fr.service.ProduitWS produitWS = null;
  
  public ProduitWSProxy() {
    _initProduitWSProxy();
  }
  
  public ProduitWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initProduitWSProxy();
  }
  
  private void _initProduitWSProxy() {
    try {
      produitWS = (new fr.service.ProduitServiceServiceLocator()).getProduitWSPort();
      if (produitWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)produitWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)produitWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (produitWS != null)
      ((javax.xml.rpc.Stub)produitWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.service.ProduitWS getProduitWS() {
    if (produitWS == null)
      _initProduitWSProxy();
    return produitWS;
  }
  
  public void addProduit(fr.service.Produit produit) throws java.rmi.RemoteException{
    if (produitWS == null)
      _initProduitWSProxy();
    produitWS.addProduit(produit);
  }
  
  public fr.service.Produit[] getProduits() throws java.rmi.RemoteException{
    if (produitWS == null)
      _initProduitWSProxy();
    return produitWS.getProduits();
  }
  
  public fr.service.Produit getProduit(java.lang.String code) throws java.rmi.RemoteException{
    if (produitWS == null)
      _initProduitWSProxy();
    return produitWS.getProduit(code);
  }
  
  
}