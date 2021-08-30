package com.Oglasi.OglasiIMI.entity;

import javax.persistence.*;

@Entity
@Table(name = "poslodavac")
public class Poslodavac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "opis")
    private String opis;

    @Column(name = "delatnost")
    private String delatnost;

    @Column(name = "sediste")
    private String sediste;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;


    public Poslodavac(){}

    public Poslodavac(int id, String naziv, String opis, String delatnost, String sediste,
                      String username, String password) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.delatnost = delatnost;
        this.sediste = sediste;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getDelatnost() {
        return delatnost;
    }

    public void setDelatnost(String delatnost) {
        this.delatnost = delatnost;
    }

    public String getSediste() {
        return sediste;
    }

    public void setSediste(String sediste) {
        this.sediste = sediste;
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
