package com.parcauto.ParcAutoApp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Ventes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marque;
    private String modele;
    private String prix;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private String date;
    @Column(nullable = false, updatable = false)
    private String codeVente;

    public Ventes() {}

    public Ventes(Long id, String marque, String modele, String prix, String nom, String prenom, String email, String phone, String date, String codeVente) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.prix = prix;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
        this.date = date;
        this.codeVente = codeVente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCodeVente() {
        return codeVente;
    }

    public void setCodeVente(String codeVente) {
        this.codeVente = codeVente;
    }

    @Override
    public String toString() {
        return "Ventes{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", prix='" + prix + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", date='" + date + '\'' +
                ", codeVente='" + codeVente + '\'' +
                '}';
    }
}
