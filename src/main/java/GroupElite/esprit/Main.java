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
