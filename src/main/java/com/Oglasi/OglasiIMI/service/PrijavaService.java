package com.Oglasi.OglasiIMI.service;

import com.Oglasi.OglasiIMI.entity.Prijava;
import com.Oglasi.OglasiIMI.entity.Radnik;

import java.util.ArrayList;
import java.util.List;

public interface PrijavaService {

    public ArrayList<Radnik> findAllForOglas(int id);

    public String prijavaNaOglas(int radnikId, int oglasId);

    public List<Prijava> findAllByRadnikId(int radnikId);

}
