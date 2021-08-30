package com.Oglasi.OglasiIMI.controller;

import com.Oglasi.OglasiIMI.entity.Prijava;
import com.Oglasi.OglasiIMI.entity.Radnik;
import com.Oglasi.OglasiIMI.service.PrijavaService;
import com.Oglasi.OglasiIMI.service.RadnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class RadnikController {

    @Autowired
    private RadnikService radnikService;

    @Autowired
    private PrijavaService prijavaService;

    @GetMapping("/radnik/sviRadnici")
    public List<Radnik> findAll(){
        return radnikService.findAll();
    }

    @GetMapping("/radnik/id={id}")
    public Radnik findById(@PathVariable int id){
        return radnikService.findRadnikById(id);
    }

    @GetMapping("radnik/oglas={oglasId}&radnik={radnikId}")
    public String prijavaNaOglas(@PathVariable int oglasId, @PathVariable int radnikId){
        return prijavaService.prijavaNaOglas(radnikId, oglasId);
    }

    @GetMapping("radnik/login/username={username}&password={password}")
    public Radnik login(@PathVariable String username, @PathVariable String password){
        return radnikService.login(username, password);
    }

    @GetMapping("/oglasiZaRadnika={radnikId}")
    public List<Prijava> oglasiZaRadnik(@PathVariable int radnikId)
    {
        return prijavaService.findAllByRadnikId(radnikId);
    }

    @PostMapping("/radnik/registracija")
    public Radnik addRadnik(@RequestBody Radnik radnik)
    {
        return radnikService.addRadnik(radnik);
    }

}
