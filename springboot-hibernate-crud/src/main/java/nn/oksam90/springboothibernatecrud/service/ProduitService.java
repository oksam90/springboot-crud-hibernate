package nn.oksam90.springboothibernatecrud.service;

import java.util.List;

import nn.oksam90.springboothibernatecrud.entity.Produit;

public interface ProduitService {
	
	Produit createProduit(Produit produit);

	Produit updateProduit(Produit produit);

    List<Produit>getAllProduit();

    Produit getProduitById(long produitId);

    void deleteProduit(long id);

}
