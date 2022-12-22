package com.parcauto.ParcAutoApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Cars implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marque;
    private String modele;
    private String locationprice;
    private  String achatprice;
    private  String imageUrl;
    private String status;

    public Cars() {}

    public Cars(Long id, String marque, String modele, String locationprice, String achatprice, String status) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.locationprice = locationprice;
        this.achatprice = achatprice;
        this.status = status;
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

    public String getLocationprice() {
        return locationprice;
    }

    public void setLocationprice(String locationprice) {
        this.locationprice = locationprice;
    }

    public String getAchatprice() {
        return achatprice;
    }

    public void setAchatprice(String achatprice) {
        this.achatprice = achatprice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", locationprice='" + locationprice + '\'' +
                ", achatprice='" + achatprice + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
