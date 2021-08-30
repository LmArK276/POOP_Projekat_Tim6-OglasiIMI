package com.Oglasi.OglasiIMI.service;

import com.Oglasi.OglasiIMI.entity.Oglas;
import com.Oglasi.OglasiIMI.entity.Poslodavac;

import java.util.List;

public interface PoslodavacService {

    public Poslodavac findById(int id);

    public List<Poslodavac> findAll();

    public Oglas addOglas(Oglas oglas);

    public Poslodavac login(String username, String password);

    public Poslodavac addPoslodavac(Poslodavac poslodavac);

}
