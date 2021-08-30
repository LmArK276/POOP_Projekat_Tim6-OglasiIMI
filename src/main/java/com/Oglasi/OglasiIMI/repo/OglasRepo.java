package com.Oglasi.OglasiIMI.repo;

import com.Oglasi.OglasiIMI.entity.Oglas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OglasRepo extends JpaRepository<Oglas, Integer> {

    public List<Oglas> findAllById(int id);

    public List<Oglas> findAllByIdPoslodavca(int idPoslodavca);

    public List<Oglas> findAll();

    public List<Oglas> findAllByKategorija(String kategorija);

    public List<Oglas> findAllByRadnaPozicijaIsLike(String radnaPozicija);


}
