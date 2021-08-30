package com.Oglasi.OglasiIMI.controller;

import com.Oglasi.OglasiIMI.entity.Oglas;
import com.Oglasi.OglasiIMI.entity.Poslodavac;
import com.Oglasi.OglasiIMI.service.OglasService;
import com.Oglasi.OglasiIMI.service.PoslodavacService;
import com.Oglasi.OglasiIMI.service.PrijavaService;
import com.Oglasi.OglasiIMI.service.RadnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class KontroleriPrikaza {


    @Autowired
    private OglasService oglasService;

    @Autowired
    private PoslodavacService poslodavacService;

    @Autowired
    private RadnikService radnikService;

    @Autowired
    private PrijavaService prijavaService;

    //Pocetna Login Strana
    @RequestMapping("/")
    public String prikazPocetna()
    {
        return "/pocetna";
    }

    //Svi Oglasi
    @RequestMapping("/oglasi")
    public String prikaziSveOglase(Model model)
    {
        model.addAttribute("oglasi",oglasService.findAll());
        return "/oglasi";
    }

    //Dodavanje Oglasa
    @RequestMapping("/dodavanje_oglasa")
    public String prikazForme()
    {
        return "/dodavanje_oglasa";
    }


    //Svi Poslodavci
    @GetMapping("/poslodavci")
    public String sviPoslodavci(Model model)
    {
        model.addAttribute("poslodavci",poslodavacService.findAll());
        return "/poslodavci";
    }

    //Control panel za admina
    @RequestMapping("/control_panel")
    public String adminKontrola(Model model)
    {
        model.addAttribute("oglasi",oglasService.findAll());
        model.addAttribute("radnici",radnikService.findAll());
        model.addAttribute("poslodavci",poslodavacService.findAll());

        return "/control_panel";
    }

    //Pretraga po imenu oglasa
    @GetMapping("/oglasi_pozicija={radnaPozicija}")
    public String findByRadnaPozicija(@PathVariable String radnaPozicija,Model model){
         model.addAttribute("oglasi",oglasService.findAllByRadnaPozicijaIsLike(radnaPozicija));
         return "/pretraga_oglasa";
    }

    //Poslodavac profil
    @GetMapping("/mojProfil={id}")
    public String nadjiPoslodavca(@PathVariable int id,Model model)
    {
        model.addAttribute("poslodavac",poslodavacService.findById(id));
        return "/poslodavac_profil";
    }

    //Svi oglasi odredjenog poslodavca
    @GetMapping("/mojiOglasi={idPoslodavca}")
    public String izlistajOglase(@PathVariable int idPoslodavca,Model model)
    {
        model.addAttribute("mojiOglasi",oglasService.findAllByIdPoslodavca(idPoslodavca));
        return "/mojiOglasi";
    }

    //Svi radnici na jednom oglasu
    @GetMapping("/radniciNaOglasu={id}")
    public String izlistajRadnikeNaOglasu(@PathVariable int id,Model model)
    {
        model.addAttribute("oglas",oglasService.findAllById(id));
        model.addAttribute("radnici",prijavaService.findAllForOglas(id));
        return "/pregledRadnika";
    }
}
