package com.Oglasi.OglasiIMI.controller;

import com.Oglasi.OglasiIMI.entity.Admin;
import com.Oglasi.OglasiIMI.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @DeleteMapping("/admin/oglas={id}")
    public String deleteOglas(@PathVariable int id){
        return adminService.deleteOglas(id);
    }

    @DeleteMapping("/admin/radnik={id}")
    public String deleteRadnik(@PathVariable int id){
        return adminService.deleteRadnik(id);
    }

    @DeleteMapping("/admin/poslodavac={id}")
    public String deletePoslodavac(@PathVariable int id){
        return adminService.deletePoslodavac(id);
    }

    @GetMapping("admin/login/username={username}&password={password}")
    public Admin login(@PathVariable String username, @PathVariable String password){
        return adminService.login(username, password);
    }
}
