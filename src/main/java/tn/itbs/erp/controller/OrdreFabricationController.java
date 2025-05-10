package tn.itbs.erp.controller;

import tn.itbs.erp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.itbs.erp.service.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/api/ordres")
public class OrdreFabricationController {

    @Autowired
    private OrdreFabricationService ordreService;

    @GetMapping
    public List<OrdreFabrication> getAllOrdres() {
        return ordreService.getAllOrdres();
    }

    @GetMapping("/{id}")
    public OrdreFabrication getOrdreById(@PathVariable int id) {
        return ordreService.getOrdreById(id);
    }

    @PostMapping
    public OrdreFabrication createOrdre(@RequestBody OrdreFabrication ordre) {
        return ordreService.createOrdre(ordre);
    }

    @PutMapping("/{id}")
    public OrdreFabrication updateOrdre(@PathVariable int id, @RequestBody OrdreFabrication ordre) {
        return ordreService.updateOrdre(id, ordre);
    }

    @DeleteMapping("/{id}")
    public void deleteOrdre(@PathVariable int id) {
        ordreService.deleteOrdre(id);
    }
}
