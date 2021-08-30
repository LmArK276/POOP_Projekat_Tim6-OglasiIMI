package com.Oglasi.OglasiIMI.controller;

import com.Oglasi.OglasiIMI.entity.Oglas;
import com.Oglasi.OglasiIMI.entity.Poslodavac;
import com.Oglasi.OglasiIMI.entity.Radnik;
import com.Oglasi.OglasiIMI.service.PoslodavacService;
import com.Oglasi.OglasiIMI.service.PrijavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PoslodavacController {

    @Autowired
    private PoslodavacService poslodavacService;

    @Autowired
    private PrijavaService prijavaService;

    @GetMapping("/poslodavac/sviPoslodavci")
    public List<Poslodavac> findAll(){
       return poslodavacService.findAll();
   }

    @GetMapping("/poslodavci/id={id}")
    public Poslodavac findById(@PathVariable int id){
        return poslodavacService.findById(id);
    }

    @PostMapping("/poslodavac/dodaj-oglas")
    public Oglas addOglas(@RequestBody Oglas oglas){
        return poslodavacService.addOglas(oglas);
    }

    @GetMapping("/poslodavac/pregled-oglasa/oglas={id}")
    public ArrayList<Radnik> allRadnikOnOglas(@PathVariable int id){
        return prijavaService.findAllForOglas(id);
    }

    @GetMapping("/poslodavac/login/username={username}&password={password}")
    public Poslodavac login(@PathVariable String username, @PathVariable String password){
        return poslodavacService.login(username, password);
    }

    @PostMapping("poslodavac/register")
    public Poslodavac addPoslodavac(@RequestBody Poslodavac poslodavac){
        return poslodavacService.addPoslodavac(poslodavac);
    }
}
