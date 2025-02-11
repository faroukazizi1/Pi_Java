package GroupElite.esprit;
import Model.Formation;
import Service.FormationService;
import Model.Formateur;
import Service.FormateurService;

import java.sql.Connection;
import java.sql.Date;

import Util.DBConnection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FormationService fo=new FormationService();
        Date Date_D = Date.valueOf("2025-04-01");  // Format yyyy-mm-dd
        Date Date_F = Date.valueOf("2025-04-10");
        fo.add(new Formation("mm","kedheugyujf",Date_F,Date_D,20,"havxjhvaxkabkxv", 1));
        fo.delete(new Formation(42,"kedhe","kedheugyujf",Date_F,Date_D,20,"havxjhvaxkabkxv", 1));
        fo.update(new Formation(1,"teambulding","kedheugyujf",Date_F,Date_D,20,"havxjhvaxkabkxv", 1));
        System.out.println(fo.getAll());
        FormateurService formateurS = new FormateurService();
        formateurS.add(new Formateur(24,"mohamed","amine ","sai.lfft@esprit.com","math"));
        formateurS.delete(new Formateur(27,24,"menyar","ben ghorbel","said.laffet@esprit.com","math"));
        formateurS.update(new Formateur(28,24,"manou","ben ghorbel","said.laffet@esprit.com","math"));
        System.out.println(formateurS.getAll());

    }
}