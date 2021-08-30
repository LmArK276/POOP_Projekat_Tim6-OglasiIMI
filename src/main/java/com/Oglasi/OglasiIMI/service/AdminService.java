package com.Oglasi.OglasiIMI.service;

import com.Oglasi.OglasiIMI.entity.Admin;
import com.Oglasi.OglasiIMI.entity.Oglas;
import com.Oglasi.OglasiIMI.entity.Poslodavac;
import com.Oglasi.OglasiIMI.entity.Radnik;

public interface AdminService {

    public String deleteOglas(int id);

    public String deletePoslodavac(int id);

    public String deleteRadnik(int id);

    public Admin login(String username, String password);

}
