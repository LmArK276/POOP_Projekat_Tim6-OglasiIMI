package com.Oglasi.OglasiIMI.controller;

import com.Oglasi.OglasiIMI.entity.Oglas;
import com.Oglasi.OglasiIMI.service.OglasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class OglasController {

    @Autowired
    private OglasService oglasService;

    @GetMapping("/sviOglasi")
    public List<Oglas> findAll(){
        return oglasService.findAll();
    }

    @GetMapping("/oglasi/id={id}")
    public List<Oglas> findAllById(@PathVariable int id){
        return oglasService.findAllById(id);
    }

    @GetMapping("/oglasi/idPoslodavca={idPoslodavca}")
    public List<Oglas> findAllByIdPoslodavca(@PathVariable int idPoslodavca){
        return oglasService.findAllByIdPoslodavca(idPoslodavca);
    }

    @GetMapping("/oglasi/kategorija={kategorija}")
    public List<Oglas> findByKategorija(@PathVariable String kategorija){
        return oglasService.findAllByKategorija(kategorija);
    }

}
