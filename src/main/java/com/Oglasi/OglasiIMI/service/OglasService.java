package com.Oglasi.OglasiIMI.service;

import com.Oglasi.OglasiIMI.entity.Oglas;

import java.util.List;

public interface OglasService {

    public List<Oglas> findAllById(int id);

    public List<Oglas> findAllByIdPoslodavca(int idPoslodavca);

    public List<Oglas> findAll();

    public List<Oglas> findAllByKategorija(String kategorija);

    public List<Oglas> findAllByRadnaPozicijaIsLike(String radnaPozicija);

}
