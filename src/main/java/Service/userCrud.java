package Service;

import Model.user;
import Util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class userCrud implements  IService<user> {

    Connection conn;

    public userCrud() {
        this.conn = DBConnection.getInstance().getConn();
    }

    @Override
    public void add(user user) {
        String SQL = "INSERT INTO user(cin, nom, prenom, email, username, password, role, sexe, adresse, numero) VALUES ('"
                + user.getCin() + "','"
                + user.getNom() + "','"
                + user.getPrenom() + "','"
                + user.getEmail() + "','"
                + user.getUsername() + "','"
                + user.getPassword() + "','"
                + user.getRole() + "','"
                + user.getSexe() + "','"
                + user.getAdresse() + "','"
                + user.getNumero() + "')";

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(user user) {

    }

    @Override
    public void delete(user user) {

    }

    @Override
    public List<user> getAll() {
        return null;
    }




}
