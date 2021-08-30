package com.Oglasi.OglasiIMI.entity;

import javax.persistence.*;



@Entity
@Table(name = "prijavaoglas")
public class Prijava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "oglas")
    private int oglasId;

    @Column(name = "radnik")
    private int radnikId;

    public Prijava(){}

    public Prijava(int id, int oglasId, int radnikId) {
        this.id = id;
        this.oglasId = oglasId;
        this.radnikId = radnikId;
    }

    public int getId() {
        return id;
    }

    public int getOglasId() {
        return oglasId;
    }

    public void setOglasId(int oglasId) {
        this.oglasId = oglasId;
    }

    public int getRadnikId() {
        return radnikId;
    }

    public void setRadnikId(int radnikId) {
        this.radnikId = radnikId;
    }

    @Override
    public String toString() {
        return "Prijava{" +
                "id=" + id +
                ", oglasId=" + oglasId +
                ", radnikId=" + radnikId +
                '}';
    }
}
