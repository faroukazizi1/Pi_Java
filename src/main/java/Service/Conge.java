package models;

import java.util.Date;

public class Conge {
    private int id;
    private int userId;
    private Date dateDebut;
    private Date dateFin;
    private String type;
    private String validated;

    public Conge(int id, int userId, Date dateDebut, Date dateFin, String type, String validated) {
        this.id = id;
        this.userId = userId;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.type = type;
        this.validated = validated;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public Date getDateDebut() { return dateDebut; }
    public void setDateDebut(Date dateDebut) { this.dateDebut = dateDebut; }

    public Date getDateFin() { return dateFin; }
    public void setDateFin(Date dateFin) { this.dateFin = dateFin; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getValidated() { return validated; }
    public void setValidated(String validated) { this.validated = validated; }
}
