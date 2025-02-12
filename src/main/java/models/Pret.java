package models;

import java.sql.Date;

public class Pret {
    private int id_pret;
    private Date date_pret;
    private float montant_pret;  // ✅ Utilisation cohérente de float

    // ✅ Constructeur principal
    public Pret(int id_pret, Date date_pret, float montant_pret) {
        this.id_pret = id_pret;
        this.date_pret = date_pret;
        this.montant_pret = montant_pret;
    }

    // ✅ Getters
    public int getId_pret() {
        return id_pret;
    }

    public Date getDate_pret() {
        return date_pret;
    }

    public float getMontant_pret() {
        return montant_pret;
    }

    // ✅ Setters
    public void setId_pret(int id_pret) {
        this.id_pret = id_pret;
    }

    public void setDate_pret(Date date_pret) {
        this.date_pret = date_pret;
    }

    public void setMontant_pret(float montant_pret) {
        this.montant_pret = montant_pret;
    }

    // ✅ Méthode toString
    @Override
    public String toString() {
        return "Pret{" +
                "id_pret=" + id_pret +
                ", date_pret=" + date_pret +
                ", montant_pret=" + montant_pret +
                '}';
    }

    // ✅ Correction de la méthode pour retourner l'ID du prêt
    public int getID_pret() {
        return id_pret;  // Retourne l'attribut id_pret
    }

    // ✅ Correction de la méthode pour retourner le montant
    public float getMontant() {
        return montant_pret;  // Retourne l'attribut montant_pret
    }

    public void setID_pret(int i) {
    }
}
