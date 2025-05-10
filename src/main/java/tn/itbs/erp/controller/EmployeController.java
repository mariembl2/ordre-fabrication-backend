package tn.itbs.erp.controller;

import tn.itbs.erp.model.Employe;
import tn.itbs.erp.service.EmployeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @GetMapping
    public List<Employe> getAllEmployes() {
        List<Employe> employes = employeService.getAllEmployes();
        System.out.println("Employés récupérés : " + employes);
        return employes;
    }

    @GetMapping("/{id}")
    public Employe getEmployeById(@PathVariable int id) {
        return employeService.getEmployeById(id);
    }

    @PostMapping
    public Employe createEmploye(@RequestBody Employe employe) {
        return employeService.createEmploye(employe);
    }

    @PutMapping("/{id}")
    public Employe updateEmploye(@PathVariable int id, @RequestBody Employe employe) {
        return employeService.updateEmploye(id, employe);
    }
    
    @DeleteMapping("/{id}")
    public void deleteEmploye(@PathVariable int id) {
        employeService.deleteEmploye(id);
    }
}