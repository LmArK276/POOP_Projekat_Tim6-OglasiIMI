package com.Oglasi.OglasiIMI.service;

import com.Oglasi.OglasiIMI.entity.Oglas;
import com.Oglasi.OglasiIMI.repo.OglasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OglasServiceImpl implements OglasService{

    @Autowired
    private OglasRepo oglasRepo;

    @Override
    public List<Oglas> findAllById(int id) {
        return oglasRepo.findAllById(id);
    }

    @Override
    public List<Oglas> findAllByIdPoslodavca(int idPoslodavca){
        return oglasRepo.findAllByIdPoslodavca(idPoslodavca);
    }

    @Override
    public List<Oglas> findAll() {
        return oglasRepo.findAll();
    }

    @Override
    public List<Oglas> findAllByKategorija(String kategorija) {
        return oglasRepo.findAllByKategorija(kategorija);
    }

    @Override
    public List<Oglas> findAllByRadnaPozicijaIsLike(String radnaPozicija) {
        radnaPozicija = "%" + radnaPozicija + "%";
        return oglasRepo.findAllByRadnaPozicijaIsLike(radnaPozicija);
    }
}
