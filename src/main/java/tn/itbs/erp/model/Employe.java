package tn.itbs.erp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    private String poste;

    @ManyToOne(fetch = FetchType.EAGER,  cascade = CascadeType.PERSIST)
    @JoinColumn(name = "machine_id") // Clé étrangère vers Machine
    private Machine machineAssignee;

    // Constructeurs
    public Employe() {
    }

    public Employe(String nom, String poste, Machine machineAssignee) {
        this.nom = nom;
        this.poste = poste;
        this.machineAssignee = machineAssignee;
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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Machine getMachineAssignee() {
        return machineAssignee;
    }

    public void setMachineAssignee(Machine machineAssignee) {
        this.machineAssignee = machineAssignee;
    }
}