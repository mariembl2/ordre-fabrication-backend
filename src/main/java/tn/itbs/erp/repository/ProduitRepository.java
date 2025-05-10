package tn.itbs.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.itbs.erp.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

}
