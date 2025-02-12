<<<<<<< HEAD
package GroupElite.esprit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import Models.congeDAO;
import Models.conge;
import Util.DBConnection;

public class Main {
    public static void main(String[] args) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = db.getConnection();

        String query = "SELECT * FROM conges";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("Congé ID: " + rs.getInt("id") + " | Type: " + rs.getString("type"));
            }

        } catch (SQLException e) {
            System.out.println("❌ Query execution failed: " + e.getMessage());
        }

        congeDAO congeDAO = new congeDAO();

        conge newConge = new conge(0, 1, new Date(), new Date(), "Annuel", "En attente");
        congeDAO.addConge(newConge);

        List<conge> list = congeDAO.getAllConges();
        for (conge c : list) {
            System.out.println("ID: " + c.getId() + " | Type: " + c.getType() + " | Status: " + c.getValidated());
        }

        if (!list.isEmpty()) {
            conge firstConge = list.get(0);
            firstConge.setValidated("Approuvé");
            congeDAO.updateConge(firstConge);
        }

        if (!list.isEmpty()) {
            congeDAO.deleteConge(list.get(0).getId());
        }

        db.closeConnection();
    }
}
=======
package GroupElite.esprit;

import Service.absenceService;
import Service.penaliteService;
import Util.DBConnection;
import models.absence;
import models.penalite;

import Model.promotion;
import Model.user;

import Service.IService;
import Service.promotionCrud;
import Service.userCrud;
import com.mysql.cj.protocol.x.XProtocol;
import com.mysql.cj.protocol.x.XProtocolDecoder;

import java.sql.Connection;
import java.util.Date;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Vérification de la connexion à la base de données
        Connection connection = DBConnection.getInstance().getConn();
        if (connection != null) {
            System.out.println("Test réussi : connexion établie !");
        } else {
            System.out.println("Échec de la connexion !");
            return;  // Sortir si la connexion échoue
        }

        // Gestion des absences
        absenceService absenceService = new absenceService();
        absence absence1 = new absence(9, new Date(), 10, "jsp");
        absenceService.add(absence1);
        System.out.println("Absence ajoutée avec succès !");

        absence updatedAbsence = new absence(3, new Date(System.currentTimeMillis()), 13, "non justifiee");
        absenceService.update(updatedAbsence);
        System.out.println("Absence mise à jour avec succès !");

        absence absenceToDelete = new absence(9, null, 13, "non justifiee");
        absenceToDelete.setId_abs(5);
        absenceService.delete(absenceToDelete);
        System.out.println("Absence supprimée avec succès !");

        System.out.println("\nListe des absences existantes :");
        for (absence abs : absenceService.getAll()) {
            System.out.println("ID: " + abs.getId_abs() + ", Date: " + abs.getDate() + ", Nombre d'absences: " + abs.getNbr_abs() + ", Type: " + abs.getType());
        }

        // Gestion des pénalités
        penaliteService penaliteService = new penaliteService();
        penalite penalite1 = new penalite(1, "ll", 2);
        penaliteService.add(penalite1);
        System.out.println("Pénalité ajoutée avec succès !");

        penalite updatedPenalite = new penalite(6, "adv_ecrit", 3);
        penaliteService.update(updatedPenalite);
        System.out.println("Pénalité mise à jour avec succès !");

        penalite penaliteToDelete = new penalite(1, null, 0);
        penaliteToDelete.setId_pen(7);
        penaliteService.delete(penaliteToDelete);
        System.out.println("Pénalité supprimée avec succès !");

        System.out.println("\nListe des pénalités existantes :");
        for (penalite pen : penaliteService.getAll()) {
            System.out.println("ID: " + pen.getId_pen() + ", Type: " + pen.getType() + ", Seuil d'absence: " + pen.getSeuil_abs());
        }

        // Ici tu peux ajouter la logique pour gérer les promotions et les utilisateurs
    }
}
>>>>>>> 42e9c0798d0afb05be78fba88231941ec556e699
