package tn.itbs.erp.controller;

import org.springframework.web.bind.annotation.*;
import tn.itbs.erp.model.Machine;
import tn.itbs.erp.service.*;

import java.util.List;

@RestController
@RequestMapping("/api/machines")
@CrossOrigin(origins = "http://localhost:4200") // Front Angular
public class MachineController {

    private final MachineService machineService;

    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    @GetMapping
    public List<Machine> getAllMachines() {
        return machineService.getAllMachines();
    }

    @GetMapping("/{id}")
    public Machine getMachineById(@PathVariable int id) {
        return machineService.getMachineById(id);
    }

    @PostMapping
    public Machine createMachine(@RequestBody Machine machine) {
        return machineService.createMachine(machine);
    }

    @PutMapping("/{id}")
    public Machine updateMachine(@PathVariable int id, @RequestBody Machine machine) {
        return machineService.updateMachine(id, machine);
    }

    @DeleteMapping("/{id}")
    public void deleteMachine(@PathVariable int id) {
        machineService.deleteMachine(id);
    }
}
