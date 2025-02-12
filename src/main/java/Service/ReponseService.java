package Service;

import Util.DBConnection;
import models.Pret;
import models.Reponse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReponseService implements IService<Reponse> {
    private Connection conn;

    public ReponseService() {
        this.conn = DBConnection.getInstance().getConn();
    }

    @Override
    public void add(Reponse reponse) {
        String SQL = "INSERT INTO reponse (date_reponse, decision, montant, amortissement, interet) VALUES (?, ?, ?, ?, ?)";

        try {
            if (conn == null || conn.isClosed()) {
                throw new SQLException("La connexion à la base de données est fermée.");
            }

            conn.setAutoCommit(false); // Début de la transaction

            try (PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, reponse.getDate_reponse());
                pstmt.setString(2, reponse.getDecision());
                pstmt.setDouble(3, reponse.getMontant());
                pstmt.setDouble(4, reponse.getAmortissement());
                pstmt.setDouble(5, reponse.getInteret());

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Échec de l'insertion, aucune ligne affectée.");
                }

                //  Récupération de l'ID généré automatiquement
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        reponse.setId_reponse(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Échec de la récupération de l'ID généré.");
                    }
                }

                conn.commit(); // Validation de la transaction
                System.out.println(" Réponse ajoutée à la base de données : " + reponse);
            } catch (SQLException e) {
                conn.rollback(); // Annulation en cas d'erreur
                System.out.println(" Erreur lors de l'ajout, rollback effectué : " + e.getMessage());
            } finally {
                conn.setAutoCommit(true); // Retour au mode auto-commit
            }

        } catch (SQLException e) {
            System.out.println(" Erreur de connexion à la base de données : " + e.getMessage());
        }
    }

    @Override
    public void update(Reponse reponse, int ancienID) {
        String SQL = "UPDATE reponse SET date_reponse = ?, decision = ?, montant = ?, amortissement = ?, interet = ? WHERE id_reponse = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, reponse.getDate_reponse());
            pstmt.setString(2, reponse.getDecision());
            pstmt.setDouble(3, reponse.getMontant());
            pstmt.setDouble(4, reponse.getAmortissement());
            pstmt.setDouble(5, reponse.getInteret());
            pstmt.setInt(6, ancienID);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println(" Réponse mise à jour avec succès : " + reponse);
            } else {
                System.out.println(" Aucune réponse trouvée avec l'ID : " + ancienID);
            }
        } catch (SQLException e) {
            System.out.println(" Erreur lors de la mise à jour : " + e.getMessage());
        }
    }

    @Override
    public void delete(int id_reponse) {
        String SQL = "DELETE FROM reponse WHERE id_reponse = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, id_reponse);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println(" Réponse supprimée avec succès (ID : " + id_reponse + ")");
            } else {
                System.out.println(" Aucune réponse trouvée avec l'ID : " + id_reponse);
            }
        } catch (SQLException e) {
            System.out.println(" Erreur lors de la suppression : " + e.getMessage());
        }
    }

    @Override
    public List<Reponse> getAll() {
        List<Reponse> reponses = new ArrayList<>();
        String SQL = "SELECT * FROM reponse";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                int id_reponse = rs.getInt("id_reponse");
                String date_reponse = rs.getString("date_reponse");
                String decision = rs.getString("decision");
                double montant = rs.getDouble("montant");
                double amortissement = rs.getDouble("amortissement");
                double interet = rs.getDouble("interet");

                Reponse reponse = new Reponse(id_reponse, date_reponse, decision, montant, amortissement, interet);
                reponses.add(reponse);
            }
        } catch (SQLException e) {
            System.out.println(" Erreur lors de la récupération des réponses : " + e.getMessage());
        }
        return reponses;
    }

    // Méthodes non implémentées
    @Override
    public void update(Reponse reponse) { }

    @Override
    public void delete(Reponse reponse) { }

    @Override
    public void update(Pret pret, int ancienID) { }
}
