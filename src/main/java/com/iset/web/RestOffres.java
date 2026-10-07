package com.iset.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iset.dao.OffreRepository;
import com.iset.entities.Offre;

@RestController
@RequestMapping("/Offres")
public class RestOffres {

    @Autowired
    OffreRepository offreRepository;

    
    @GetMapping
    public List<Offre> getAll() {
        return offreRepository.findAll();
    }

    
    @GetMapping("/{uid}")
    public Offre getbyid(@PathVariable Long uid) {
        return offreRepository.findById(uid).get();
    }

    
    @PostMapping
    public Offre saveoffre(@RequestBody Offre newoffre) {
        return offreRepository.save(newoffre);
    }

    @DeleteMapping("/{id}")
    public void deleteoffre(@PathVariable Long id) {
        offreRepository.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public Offre updateoffre(@PathVariable Long id, @RequestBody Offre newoffre) {
        Offre offre = offreRepository.findById(id).get();
        offre.setIntitule(newoffre.getIntitule());
        offre.setSpecialite(newoffre.getSpecialite());
        offre.setSociete(newoffre.getSociete());
        offre.setNbpostes(newoffre.getNbpostes());
        offre.setPays(newoffre.getPays());
        return offreRepository.save(offre);
    }

    
    
}