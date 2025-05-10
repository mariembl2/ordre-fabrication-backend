package tn.itbs.erp.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    private String etat; // "Disponible", "En panne", "En maintenance"

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Format JSON pour la date
    private LocalDate derniereMaintenance;

    // Constructeurs
    public Machine() {
    }

    public Machine(String nom, String etat) {
        this.nom = nom;
        this.etat = etat;
    }

    public Machine(String nom, String etat, LocalDate dernièreMaintenance) {
        this.nom = nom;
        this.etat = etat;
        this.derniereMaintenance = dernièreMaintenance;
    }

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public LocalDate getDerniereMaintenance() {
        return derniereMaintenance;
    }

    public void setDerniereMaintenance(LocalDate derniereMaintenance) {
        this.derniereMaintenance = derniereMaintenance;
    }
}