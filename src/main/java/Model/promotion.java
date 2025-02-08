package Model;

import java.util.Date;



public class promotion {

    private int id;
    private String type_promo;
    private String raison;
    private String poste_promo;
    private String date_prom;
    private Double nouv_sal;
    private String avs;

    public promotion() {
    }

    public promotion(int id, String type_promo, String raison, String poste_promo, Double nouv_sal, String date_prom, String avs) {
        this.id = id;
        this.type_promo = type_promo;
        this.raison = raison;
        this.poste_promo = poste_promo;
        this.date_prom = date_prom;
        this.nouv_sal = nouv_sal;
        this.avs = avs;
    }

    public promotion(String type_promo, String raison, String poste_promo, Double nouv_sal, String date_prom, String avs) {
        this.type_promo = type_promo;
        this.raison = raison;
        this.poste_promo = poste_promo;
        this.nouv_sal = nouv_sal;
        this.date_prom = date_prom;
        this.avs = avs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType_promo() {
        return type_promo;
    }

    public void setType_promo(String type_promo) {
        this.type_promo = type_promo;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public String getPoste_promo() {
        return poste_promo;
    }

    public void setPoste_promo(String poste_promo) {
        this.poste_promo = poste_promo;
    }

    public String getDate_prom() {
        return date_prom;
    }

    public void setDate_prom(String date_prom) {
        this.date_prom = date_prom;
    }

    public Double getNouv_sal() {
        return nouv_sal;
    }

    public void setNouv_sal(Double nouv_sal) {
        this.nouv_sal = nouv_sal;
    }

    public String getAvs() {
        return avs;
    }

    public void setAvs(String avs) {
        this.avs = avs;
    }

    @Override
    public String toString() {
        return "promotion{" +
                "id=" + id +
                ", type_promo='" + type_promo + '\'' +
                ", raison='" + raison + '\'' +
                ", poste_promo='" + poste_promo + '\'' +
                ", date_prom=" + date_prom +
                ", nouv_sal=" + nouv_sal +
                ", avs='" + avs + '\'' +
                '}';
    }
}
