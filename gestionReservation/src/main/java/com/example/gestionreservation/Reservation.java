package com.example.gestionreservation;

import jakarta.persistence.*;


import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
@Entity
public class Reservation implements Serializable {
    @Serial
    private static final long serialVersionUID = 6;

    @Id
    @GeneratedValue
    private int id;
    private Date datedebut;
    private Date datefin;
    private int idchambre;

    private Boolean statut;

    public Reservation(Date datedebut, Date datefin, int idchambre, Boolean statut) {
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.idchambre = idchambre;
        this.statut = statut;
    }

    public Reservation() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public int getIdchambre() {
        return idchambre;
    }

    public void setIdchambre(int idchambre) {
        this.idchambre = idchambre;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    public boolean isStatut() {
        return statut;
    }
}
