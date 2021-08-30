package com.Oglasi.OglasiIMI.repo;

import com.Oglasi.OglasiIMI.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {

    public Admin findById(int id);

    public Admin findByUsernameAndPassword(String username, String password);



}
