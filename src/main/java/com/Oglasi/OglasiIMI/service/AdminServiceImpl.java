package com.Oglasi.OglasiIMI.service;

import com.Oglasi.OglasiIMI.entity.Admin;
import com.Oglasi.OglasiIMI.entity.Oglas;
import com.Oglasi.OglasiIMI.entity.Poslodavac;
import com.Oglasi.OglasiIMI.entity.Radnik;
import com.Oglasi.OglasiIMI.repo.AdminRepo;
import com.Oglasi.OglasiIMI.repo.OglasRepo;
import com.Oglasi.OglasiIMI.repo.PoslodavacRepo;
import com.Oglasi.OglasiIMI.repo.RadnikRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    OglasRepo oglasRepo;

    @Autowired
    PoslodavacRepo poslodavacRepo;

    @Autowired
    RadnikRepo radnikRepo;

    @Autowired
    AdminRepo adminRepo;


    @Override
    public String deleteOglas(int id) {
        int oglasId = id;
        oglasRepo.deleteById(id);
        return "Oglas [" + oglasId + "] je obrisan";
    }

    @Override
    public String deletePoslodavac(int id) {
        int poslodavacId = id;
        poslodavacRepo.deleteById(id);
        return "Poslodavac [" + poslodavacId + "] je obrisan";
    }

    @Override
    public String deleteRadnik(int id) {
        int radnikId = id;
        radnikRepo.deleteById(id);
        return "Radnik [" + radnikId + "] je obrisan";
    }

    @Override
    public Admin login(String username, String password) {
        return adminRepo.findByUsernameAndPassword(username, password);
    }
}
