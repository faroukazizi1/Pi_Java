package Service;

import Util.DBConnection;
import models.Pret;
import models.Reponse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PretService implements IService<Pret> {
    private Connection conn;

    public PretService() {
        this.conn = DBConnection.getInstance().getConn();
    }

    @Override
    public void add(Pret pret) {
        String SQL = "INSERT INTO pret (Montant_pret, Date_pret) VALUES (?, ?)"; // Suppression de l'ID pour l'auto-incrément

        try (PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setFloat(1, pret.getMontant_pret());
            pstmt.setDate(2, new Date(pret.getDate_pret().getTime()));

            pstmt.executeUpdate();

            // Récupération de l'ID généré automatiquement
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    pret.setId_pret(generatedKeys.getInt(1));
                }
            }

            System.out.println(" Prêt ajouté à la base de données : " + pret);
        } catch (SQLException e) {
            System.out.println(" Erreur lors de l'ajout : " + e.getMessage());
        }
    }

    @Override
    public void update(Pret pret) {

    }

    @Override
    public void delete(Pret pret) {

    }

    @Override
    public void update(Pret pret, int ancienID) {
        String SQL = "UPDATE pret SET montant_pret = ?, date_pret = ? WHERE ID_pret = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setFloat(1, pret.getMontant_pret());
            pstmt.setDate(2, new Date(pret.getDate_pret().getTime()));
            pstmt.setInt(3, ancienID);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println(" Prêt mis à jour avec succès : " + pret);
            } else {
                System.out.println("⚠ Aucun prêt trouvé avec l'ID : " + ancienID);
            }
        } catch (SQLException e) {
            System.out.println(" Erreur lors de la mise à jour : " + e.getMessage());
        }
    }

    @Override
    public void update(Reponse reponse, int ancienID) {

    }

    @Override
    public void delete(int id_pret) {
        String SQL = "DELETE FROM pret WHERE ID_pret = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, id_pret);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println(" Prêt supprimé avec succès (ID : " + id_pret + ")");
            } else {
                System.out.println(" Aucun prêt trouvé avec l'ID : " + id_pret);
            }
        } catch (SQLException e) {
            System.out.println(" Erreur lors de la suppression : " + e.getMessage());
        }
    }

    @Override
    public List<Pret> getAll() {
        List<Pret> prets = new ArrayList<>();
        String SQL = "SELECT * FROM pret";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                int ID_pret = rs.getInt("ID_pret");
                Date date_pret = rs.getDate("Date_pret");
                float montant_pret = rs.getFloat("Montant_pret");

                Pret pret = new Pret(ID_pret, date_pret, montant_pret);
                prets.add(pret);
            }
        } catch (SQLException e) {
            System.out.println(" Erreur lors de la récupération des prêts : " + e.getMessage());
        }
        return prets;
    }
}
