package tn.itbs.erp.service;

import org.springframework.stereotype.Service;
import tn.itbs.erp.model.Machine;
import tn.itbs.erp.repository.MachineRepository;

import java.util.List;

@Service
public class MachineService {

    private final MachineRepository machineRepository;

    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    public List<Machine> getAllMachines() {
        return machineRepository.findAll();
    }

    public Machine getMachineById(int id) {
        return machineRepository.findById(id).orElse(null);
    }

    public Machine createMachine(Machine machine) {
        return machineRepository.save(machine);
    }

    public void deleteMachine(int id) {
        machineRepository.deleteById(id);
    }

    public Machine updateMachine(int id, Machine updatedMachine) {
        Machine existing = machineRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNom(updatedMachine.getNom());
            existing.setEtat(updatedMachine.getEtat());
            existing.setDerniereMaintenance(updatedMachine.getDerniereMaintenance());
            return machineRepository.save(existing);
        }
        return null;
    }
}
