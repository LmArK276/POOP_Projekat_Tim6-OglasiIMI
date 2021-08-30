package com.Oglasi.OglasiIMI.service;

import com.Oglasi.OglasiIMI.entity.Poslodavac;
import com.Oglasi.OglasiIMI.entity.Radnik;

import java.util.List;

public interface RadnikService {

    public List<Radnik> findAll();

    public Radnik findRadnikById(int id);

    public Radnik login(String username, String password);

    public Radnik addRadnik(Radnik radnik);

}
