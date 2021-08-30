package com.Oglasi.OglasiIMI.entity;

import javax.persistence.*;

@Entity
@Table(name = "oglas")
public class Oglas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "radna_pozicija")
    private String radnaPozicija;

    @Column(name = "opis")
    private String opis;

    @Column(name = "id_poslodavca")
    private int idPoslodavca;

    @Column(name = "kategorija")
    private String kategorija;

    @Column(name = "podkategorija")
    private String podkategorija;

    public Oglas(){}

    public Oglas(int id, String radnaPozicija, String opis, int idPoslodavca, String kategorija, String podkategorija) {
        this.id = id;
        this.radnaPozicija = radnaPozicija;
        this.opis = opis;
        this.idPoslodavca = idPoslodavca;
        this.kategorija = kategorija;
        this.podkategorija = podkategorija;
    }

    public int getId() {
        return id;
    }

    public String getRadnaPozicija() {
        return radnaPozicija;
    }

    public void setRadnaPozicija(String radnaPozicija) {
        this.radnaPozicija = radnaPozicija;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getIdPoslodavca() {
        return idPoslodavca;
    }

    public void setIdPoslodavca(int idPoslodavca) {
        this.idPoslodavca = idPoslodavca;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getPodkategorija() {
        return podkategorija;
    }

    public void setPodkategorija(String podkategorija) {
        this.podkategorija = podkategorija;
    }
}
