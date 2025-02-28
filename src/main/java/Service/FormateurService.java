package Service;
import Model.Formateur;
import Util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FormateurService implements IService<Formateur>{
    Connection conn = DBConnection.getInstance().getConn();;

    @Override
    public void add(Formateur formateur) {
        String SQL = "insert into formateur (Numero,  Nom_F, Prenom_F, Email, Specialite) values ('" +
                formateur.getNumero() + "','" + formateur.getNom_F() + "','" +
                formateur.getPrenom_F() + "','" + formateur.getEmail()  + "','" + formateur.getSpecialite()    + "')";
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Formateur formateur) {
        String SQL = "UPDATE formateur SET Numero = '" + formateur.getNumero() +
                "', Nom_F = '" + formateur.getNom_F() +
                "', Prenom_F = '" + formateur.getPrenom_F() +
                "', Email = '" + formateur.getEmail() +
                "', Specialite = '" + formateur.getSpecialite() +
                "' WHERE id_Formateur = " + formateur.getid_Formateur();

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Formateur x) {
        String SQL = "DELETE FROM formateur WHERE id_Formateur = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1,x.getid_Formateur());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Formateur> getAll() {
        String req = "SELECT * FROM `formateur`";
        ArrayList<Formateur> formateur = new ArrayList<>();
        Statement stm;
        try {
            stm = this.conn.createStatement();


            ResultSet rs=  stm.executeQuery(req);
            while (rs.next()){
                Formateur fo = new Formateur();
                fo.setid_Formateur(rs.getInt("id_Formateur"));
                fo.setNumero(rs.getInt("Numero"));
                fo.setNom_F(rs.getString("Nom_F"));
                fo.setPrenom_F(rs.getString("Prenom_F"));
                fo.setEmail(rs.getString("Email"));
                fo.setSpecialite(rs.getString("Specialite"));



                formateur.add(fo);
            }


        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
        return formateur;
    }



}
