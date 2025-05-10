package tn.itbs.erp.service;

import tn.itbs.erp.model.Employe;
import tn.itbs.erp.model.Machine;
import tn.itbs.erp.repository.EmployeRepository;
import tn.itbs.erp.repository.MachineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class EmployeService {

    @Autowired
    private final EmployeRepository employeRepository;

    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public List<Employe> getAllEmployes() {
        List<Employe> employes = employeRepository.findAll();
        employes.forEach(employe -> {
            if (employe.getMachineAssignee() == null) {
                employe.setMachineAssignee(new Machine("Aucune machine", "Inconnue"));
            }
        });
        System.out.println("Employés après traitement : " + employes);
        return employes;
    }
    @Autowired
    private MachineRepository machineRepository; 
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Employe createEmploye(Employe employe) {
        if (employe.getMachineAssignee() != null) {
            if (employe.getMachineAssignee().getId() != null) {
                // Récupérez la machine existante à partir du repository
                Machine existingMachine = machineRepository.findById(employe.getMachineAssignee().getId())
                        .orElseThrow(() -> new IllegalArgumentException("Machine non trouvée avec l'ID : " + employe.getMachineAssignee().getId()));
                employe.setMachineAssignee(existingMachine);
            } else {
                // Sauvegardez une nouvelle machine si elle n'a pas d'ID
                Machine savedMachine = machineRepository.save(employe.getMachineAssignee());
                employe.setMachineAssignee(savedMachine);
            }
        }
        return employeRepository.save(employe);
    }
    @Transactional
    public Employe updateEmploye(int id, Employe updatedEmploye) {
        Employe existing = employeRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNom(updatedEmploye.getNom());
            existing.setPoste(updatedEmploye.getPoste());

            if (updatedEmploye.getMachineAssignee() != null) {
                if (updatedEmploye.getMachineAssignee().getId() != null) {
                    // Récupérez la machine existante à partir du repository
                    Machine existingMachine = machineRepository.findById(updatedEmploye.getMachineAssignee().getId())
                            .orElseThrow(() -> new IllegalArgumentException("Machine non trouvée avec l'ID : " + updatedEmploye.getMachineAssignee().getId()));
                    existing.setMachineAssignee(existingMachine);
                } else {
                    // Sauvegardez une nouvelle machine si elle n'a pas d'ID
                    Machine savedMachine = machineRepository.save(updatedEmploye.getMachineAssignee());
                    existing.setMachineAssignee(savedMachine);
                }
            } else {
                existing.setMachineAssignee(null); // Si aucune machine n'est associée
            }

            return employeRepository.save(existing);
        }
        return null;
    }
    public void deleteEmploye(int id) {
        employeRepository.deleteById(id);
    }

    public Employe getEmployeById(int id) {
        return employeRepository.findById(id).orElse(null);
    }
}