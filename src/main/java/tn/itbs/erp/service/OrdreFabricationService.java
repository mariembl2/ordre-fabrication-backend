package tn.itbs.erp.service;

import org.springframework.stereotype.Service;

import tn.itbs.erp.model.OrdreFabrication;
import tn.itbs.erp.model.Produit;
import tn.itbs.erp.repository.ProduitRepository;
import tn.itbs.erp.repository.OrdreFabricationRepository;

import java.util.List;

@Service
public class OrdreFabricationService {
	private final ProduitRepository produitRepository;

    private final OrdreFabricationRepository ordreFabricationRepository;

    public OrdreFabricationService(OrdreFabricationRepository ordreFabricationRepository,
            ProduitRepository produitRepository) {
    	this.ordreFabricationRepository = ordreFabricationRepository;
    	this.produitRepository = produitRepository;
}

    public List<OrdreFabrication> getAllOrdres() {
        return ordreFabricationRepository.findAll();
    }

    public OrdreFabrication getOrdreById(int id) {
        return ordreFabricationRepository.findById(id).orElse(null);
    }

    public OrdreFabrication createOrdre(OrdreFabrication ordre) {
        int produitId = ordre.getProduit().getId();
        System.out.println("Produit ID reçu : " + produitId); // Log ici
        Produit produitComplet = produitRepository.findById(produitId)
            .orElseThrow(() -> new RuntimeException("Produit avec ID " + produitId + " non trouvé"));

        ordre.setProduit(produitComplet);
        return ordreFabricationRepository.save(ordre);
    }

    public void deleteOrdre(int id) {
        ordreFabricationRepository.deleteById(id);
    }

    public OrdreFabrication updateOrdre(int id, OrdreFabrication updatedOrdre) {
        OrdreFabrication existing = ordreFabricationRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setProjet(updatedOrdre.getProjet());
            int produitId = updatedOrdre.getProduit().getId();
            Produit produitComplet = produitRepository.findById(produitId)
                .orElseThrow(() -> new RuntimeException("Produit avec ID " + produitId + " non trouvé"));
            existing.setProduit(produitComplet);
            existing.setQuantite(updatedOrdre.getQuantite());
            existing.setDate(updatedOrdre.getDate());
            existing.setEtat(updatedOrdre.getEtat());
            return ordreFabricationRepository.save(existing);
        }
        return null;
    }
}