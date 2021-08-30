package com.Oglasi.OglasiIMI.service;

import com.Oglasi.OglasiIMI.entity.Prijava;
import com.Oglasi.OglasiIMI.entity.Radnik;
import com.Oglasi.OglasiIMI.repo.PrijavaRepo;
import com.Oglasi.OglasiIMI.repo.RadnikRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrijavaServiceImpl implements PrijavaService{

    @Autowired
    private PrijavaRepo prijavaRepo;

    @Autowired
    private RadnikRepo radnikRepo;

    @Override
    public ArrayList<Radnik> findAllForOglas(int id) {
        ArrayList<Prijava> prijave = prijavaRepo.findAllByOglasId(id);
        ArrayList<Radnik> radnici = new ArrayList<Radnik>();
        for(Prijava prijava : prijave){
            int radnikId = prijava.getRadnikId();
            Radnik noviRadnik = radnikRepo.findRadnikById(radnikId);
            radnici.add(noviRadnik);
        }
        return radnici;
    }

    @Override
    public String prijavaNaOglas(int radnikId, int oglasId){
        Prijava isPrijava = prijavaRepo.findByOglasIdAndRadnikId(oglasId, radnikId);
        if(isPrijava == null) {
            Prijava prijava = new Prijava();
            prijava.setOglasId(oglasId);
            prijava.setRadnikId(radnikId);
            prijavaRepo.save(prijava);
            return "Uspesna prijava";
        }
        return "Neuspesna prijava";
    }

    @Override
    public List<Prijava> findAllByRadnikId(int radnikId){return prijavaRepo.findAllByRadnikId(radnikId);};
}
