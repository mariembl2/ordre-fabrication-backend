package tn.itbs.erp.model;

import java.util.List;


import jakarta.persistence.*;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    private String type;

    private int stock;

    private String fournisseur;
    
    @OneToMany(mappedBy = "produit")
    private List<OrdreFabrication> ordresFabrication;

    // Constructeurs
    public Produit() {
    }

    public Produit(String nom, String type, int stock, String fournisseur) {
        this.nom = nom;
        this.type = type;
        this.stock = stock;
        this.fournisseur = fournisseur;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }
}
