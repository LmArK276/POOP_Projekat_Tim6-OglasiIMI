package com.Oglasi.OglasiIMI.repo;

import com.Oglasi.OglasiIMI.entity.Radnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RadnikRepo extends JpaRepository<Radnik, Integer> {

    public List<Radnik> findAll();

    public Radnik findRadnikById(int id);

    public  Radnik findByUsernameAndPassword(String username, String password);



}
