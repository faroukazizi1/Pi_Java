package models;

import models.Conge;
import Util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CongeDAO {

    private Connection conn;

    public CongeDAO() {
        conn = DBConnection.getInstance().getConnection();
    }

    // 1️⃣ CREATE: Add a new leave request
    public void addConge(Conge conge) {
        String sql = "INSERT INTO conges (user_id, date_debut, date_fin, type, validated) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, conge.getUserId());
            pstmt.setDate(2, new java.sql.Date(conge.getDateDebut().getTime()));
            pstmt.setDate(3, new java.sql.Date(conge.getDateFin().getTime()));
            pstmt.setString(4, conge.getType());
            pstmt.setString(5, conge.getValidated());

            pstmt.executeUpdate();
            System.out.println(" Congé ajouté avec succès!");
        } catch (SQLException e) {
            System.out.println(" Erreur lors de l'ajout du congé: " + e.getMessage());
        }
    }

    // 2️⃣ READ: Get all leave requests
    public List<Conge> getAllConges() {
        List<Conge> list = new ArrayList<>();
        String sql = "SELECT * FROM conges";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Conge conge = new Conge(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getDate("date_debut"),
                        rs.getDate("date_fin"),
                        rs.getString("type"),
                        rs.getString("validated")
                );
                list.add(conge);
            }
        } catch (SQLException e) {
            System.out.println(" Erreur lors de la récupération des congés: " + e.getMessage());
        }
        return list;
    }

    // 3️⃣ UPDATE: Modify an existing leave request
    public void updateConge(Conge conge) {
        String sql = "UPDATE conges SET date_debut = ?, date_fin = ?, type = ?, validated = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, new java.sql.Date(conge.getDateDebut().getTime()));
            pstmt.setDate(2, new java.sql.Date(conge.getDateFin().getTime()));
            pstmt.setString(3, conge.getType());
            pstmt.setString(4, conge.getValidated());
            pstmt.setInt(5, conge.getId());

            pstmt.executeUpdate();
            System.out.println(" Congé mis à jour avec succès!");
        } catch (SQLException e) {
            System.out.println(" Erreur lors de la mise à jour du congé: " + e.getMessage());
        }
    }

    // 4️⃣ DELETE: Remove a leave request
    public void deleteConge(int id) {
        String sql = "DELETE FROM conges WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println(" Congé supprimé avec succès!");
        } catch (SQLException e) {
            System.out.println(" Erreur lors de la suppression du congé: " + e.getMessage());
        }
    }
}
