package com.Oglasi.OglasiIMI.service;

import com.Oglasi.OglasiIMI.entity.Radnik;
import com.Oglasi.OglasiIMI.repo.RadnikRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class RadnikServiceImpl implements RadnikService{

    @Autowired
    private RadnikRepo radnikRepo;

    @Override
    public List<Radnik> findAll(){
        return radnikRepo.findAll();
    }

    @Override
    public Radnik findRadnikById(int id) {
        return radnikRepo.findRadnikById(id);
    }

    @Override
    public Radnik login(String username, String password) {
        return radnikRepo.findByUsernameAndPassword(username, password);
    }

    @Override
    public Radnik addRadnik(Radnik radnik)
    {
        return radnikRepo.save(radnik);
    }

}
