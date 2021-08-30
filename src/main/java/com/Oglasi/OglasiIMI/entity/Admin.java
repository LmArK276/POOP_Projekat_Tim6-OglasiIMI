package com.Oglasi.OglasiIMI.entity;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ime")
    private String ime;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Admin(){}

    public Admin(int id, String ime, int idKorisnik, String username, String password) {
        this.id = id;
        this.ime = ime;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
