package nn.oksam90.springboothibernatecrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nn.oksam90.springboothibernatecrud.entity.Produit;
import nn.oksam90.springboothibernatecrud.exception.ResourceNotFoundException;
import nn.oksam90.springboothibernatecrud.repository.ProduitRepository;

@Service
@Transactional
public class ProduitServiceImpl implements ProduitService{
	
	@Autowired
    private ProduitRepository produitRepository;
	
	@Override
    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }
	
	@Override
    public Produit updateProduit(Produit produit) {
        Optional<Produit> produitDb = this.produitRepository.findById(produit.getId());

        if (produitDb.isPresent()) {
            Produit produitUpdate = produitDb.get();
            produitUpdate.setId(produit.getId());
            produitUpdate.setName(produit.getName());
            produitUpdate.setDescription(produit.getDescription());
            produitRepository.save(produitUpdate);
            return produitUpdate;
        } else {
            throw new ResourceNotFoundException("Enregistrement introuvable avec l'identifiant : " + produit.getId());
        }
    }
	
	@Override
    public List<Produit>getAllProduit() {
        return this.produitRepository.findAll();
    }
	
	@Override
    public Produit getProduitById(long produitId) {

        Optional<Produit>produitDb = this.produitRepository.findById(produitId);

        if (produitDb.isPresent()) {
            return produitDb.get();
        } else {
            throw new ResourceNotFoundException("Enregistrement introuvable avec l'identifiant : " + produitId);
        }
    }
	
	@Override
    public void deleteProduit(long produitId) {
        Optional<Produit> produitDb = this.produitRepository.findById(produitId);

        if (produitDb.isPresent()) {
            this.produitRepository.delete(produitDb.get());
        } else {
            throw new ResourceNotFoundException("Enregistrement introuvable avec l'identifiant : " + produitId);
        }

    }

}
