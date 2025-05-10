package tn.itbs.erp.service;
import org.springframework.stereotype.Service;
import tn.itbs.erp.model.Produit;
import tn.itbs.erp.repository.ProduitRepository;

import java.util.List;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit getProduitById(int id) {
        return produitRepository.findById(id).orElse(null);
        
    }


    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public void deleteProduit(int id) {
        produitRepository.deleteById(id);
    }

    public Produit updateProduit(int id, Produit updatedProduit) {
        Produit existing = produitRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNom(updatedProduit.getNom());
            existing.setType(updatedProduit.getType());
            existing.setStock(updatedProduit.getStock());
            existing.setFournisseur(updatedProduit.getFournisseur());
            return produitRepository.save(existing);
        }
        return null;
    }
}