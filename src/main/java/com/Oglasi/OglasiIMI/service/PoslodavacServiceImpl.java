package com.Oglasi.OglasiIMI.service;

import com.Oglasi.OglasiIMI.entity.Oglas;
import com.Oglasi.OglasiIMI.entity.Poslodavac;
import com.Oglasi.OglasiIMI.repo.OglasRepo;
import com.Oglasi.OglasiIMI.repo.PoslodavacRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoslodavacServiceImpl implements PoslodavacService{

    @Autowired
    private PoslodavacRepo poslodavacRepo;

    @Autowired
    private OglasRepo oglasRepo;

    @Override
    public Poslodavac findById(int id) {
        return poslodavacRepo.findById(id);
    }

    @Override
    public List<Poslodavac> findAll() {
        return poslodavacRepo.findAll();
    }

    @Override
    public Oglas addOglas(Oglas oglas) {
        return oglasRepo.save(oglas);
    }

    @Override
    public Poslodavac login(String username, String password) {
        return poslodavacRepo.findByUsernameAndPassword(username, password);
    }

    @Override
    public Poslodavac addPoslodavac(Poslodavac poslodavac){
        return poslodavacRepo.save(poslodavac);
    }

}
