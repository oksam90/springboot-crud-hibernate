package nn.oksam90.springboothibernatecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nn.oksam90.springboothibernatecrud.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{

}
