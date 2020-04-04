package nn.oksam90.springboothibernatecrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nn.oksam90.springboothibernatecrud.entity.Produit;
import nn.oksam90.springboothibernatecrud.service.ProduitService;

@RestController
public class ProduitController {
	
	@Autowired
    private ProduitService produitService;

    @GetMapping("/produits")
    public ResponseEntity<List<Produit>> getAllProduit() {
        return ResponseEntity.ok().body(produitService.getAllProduit());
    }

    @GetMapping("/produits/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable long id) {
        return ResponseEntity.ok().body(produitService.getProduitById(id));
    }

    @PostMapping("/produits")
    public ResponseEntity<Produit> createProduit(@RequestBody Produit produit) {
        return ResponseEntity.ok().body(this.produitService.createProduit(produit));
    }

    @PutMapping("/produits/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable long id, @RequestBody Produit produit) {
        produit.setId(id);
        return ResponseEntity.ok().body(this.produitService.updateProduit(produit));
    }

    @DeleteMapping("/produits/{id}")
    public HttpStatus deleteProduit(@PathVariable long id) {
        this.produitService.deleteProduit(id);
        return HttpStatus.OK;
    }

}
