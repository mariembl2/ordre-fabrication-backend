package tn.itbs.erp.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class OrdreFabrication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String projet;

    @ManyToOne
    @JoinColumn(name = "produit_id") // clé étrangère
    private Produit produit;
    
    private int quantite;

    private LocalDate date;

    private String etat; //  "En cours", "Terminé", "Annulé"

    // Constructeurs
    public OrdreFabrication() {
    }

    public OrdreFabrication(String projet, Produit produit, int quantite, LocalDate date, String etat) {
        this.projet = projet;
        this.produit = produit;
        this.quantite = quantite;
        this.date = date;
        this.etat = etat;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite= quantite;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
