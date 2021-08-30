package com.Oglasi.OglasiIMI.repo;

import com.Oglasi.OglasiIMI.entity.Prijava;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PrijavaRepo extends JpaRepository<Prijava, Integer> {

    public ArrayList<Prijava> findAllByOglasId(int id);

    public Prijava findByOglasIdAndRadnikId(int oglasId, int radnikId);

    public List<Prijava> findAllByRadnikId(int radnikId);

}
