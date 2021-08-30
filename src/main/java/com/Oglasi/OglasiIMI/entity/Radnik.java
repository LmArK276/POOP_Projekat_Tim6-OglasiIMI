package com.Oglasi.OglasiIMI.entity;

import javax.persistence.*;

@Entity
@Table(name = "radnik")
public class Radnik {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "imeprez")
    private String imePrezime;

    @Column(name = "kvalifikacije")
    private String kvalifikacije;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Radnik(){};

    public Radnik(int id, String imePrezime, String kvalifikacije, String username,
                  String password) {
        this.id = id;
        this.imePrezime = imePrezime;
        this.kvalifikacije = kvalifikacije;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getKvalifikacije() {
        return kvalifikacije;
    }

    public void setKvalifikacije(String kvalifikacije) {
        this.kvalifikacije = kvalifikacije;
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
