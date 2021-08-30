package com.Oglasi.OglasiIMI.repo;

import com.Oglasi.OglasiIMI.entity.Poslodavac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoslodavacRepo extends JpaRepository<Poslodavac, Integer> {

    public Poslodavac findById(int id);

    public List<Poslodavac> findAll();

    public String deleteById(int id);

    public Poslodavac findByUsernameAndPassword(String username, String password);

}
