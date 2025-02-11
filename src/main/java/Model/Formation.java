package Model;

import java.sql.Date;

public class Formation {
    int id_form,Duree, id_Formateur;
    String Titre,Description,Image;
    Date Date_D,Date_F;

    public Formation(){}
    public Formation(int id_form, String Titre, String Description, Date Date_D,  Date Date_F, int Duree, String Image, int id_Formateur) {
        this.id_form = id_form;
        this.Titre = Titre;
        this.Description = Description;
        this.Date_D = Date_D;
        this.Date_F = Date_F;
        this.Duree = Duree;
        this.Image = Image;
        this.id_Formateur = id_Formateur;
}
    public Formation(String Titre, String Description, Date Date_D, Date Date_F, int Duree, String Image, int id_Formateur) {
        this.Titre = Titre;
        this.Description = Description;
        this.Date_D = Date_D;
        this.Date_F = Date_F;
        this.Duree = Duree;
        this.Image = Image;
        this.id_Formateur = id_Formateur;

    }


    public int getId_form() {
        return id_form;
    }

    public void setId_form(int id_form) {
        this.id_form = id_form;
    }

    public int getDuree() {
        return Duree;
    }

    public void setDuree(int duree) {
        Duree = duree;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Date getDate_D() {
        return Date_D;
    }

    public void setDate_D(Date date_D) {
        Date_D = date_D;
    }

    public Date getDate_F() {
        return Date_F;
    }

    public void setDate_F(Date date_F) {
        Date_F = date_F;
    }
    public int getId_Formateur() {
        return id_Formateur;
    }

    public void setId_Formateur(int id_Formateur) {
        this.id_Formateur = id_Formateur;
    }

    @Override
    public String toString() {
        return "Formation{" +
                "id_form=" + id_form +
                ", Duree=" + Duree +
                ", Titre='" + Titre + '\'' +
                ", Description='" + Description + '\'' +
                ", Image='" + Image + '\'' +
                ", Date_D=" + Date_D +
                ", Date_F=" + Date_F +
                ", id_Formateur=" + id_Formateur +
                '}';
    }
}
