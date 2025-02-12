package models;

public class Reponse {
    // Attributs
    private int id_reponse;
    private String date_reponse;
    private String decision;
    private double montant;
    private double amortissement;
    private double interet;

    // Constructeur
    public Reponse(int id_reponse, String date_reponse, String decision, double montant, double amortissement, double interet) {
        this.id_reponse = id_reponse;
        this.date_reponse = date_reponse;
        this.decision = decision;
        this.montant = montant;
        this.amortissement = amortissement;
        this.interet = interet;
    }

    // Getters
    public int getId_reponse() {
        return id_reponse;
    }

    public String getDate_reponse() {
        return date_reponse;
    }

    public String getDecision() {
        return decision;
    }

    public double getMontant() {
        return montant;
    }

    public double getAmortissement() {
        return amortissement;
    }

    public double getInteret() {
        return interet;
    }

    // Setters
    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public void setDate_reponse(String date_reponse) {
        this.date_reponse = date_reponse;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setAmortissement(double amortissement) {
        this.amortissement = amortissement;
    }

    public void setInteret(double interet) {
        this.interet = interet;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Reponse {" +
                "ID_reponse=" + id_reponse +
                ", Date_reponse='" + date_reponse + '\'' +
                ", Decision='" + decision + '\'' +
                ", Montant=" + montant +
                ", Amortissement=" + amortissement +
                ", Interet=" + interet +
                '}';
    }
}

