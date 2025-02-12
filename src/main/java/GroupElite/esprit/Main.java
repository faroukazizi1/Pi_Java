package org.example;

import Service.PretService;
import Service.ReponseService;
import models.Pret;
import models.Reponse;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PretService pretService = new PretService();
        ReponseService reponseService = new ReponseService();

        //  Ajout du prêt dans la base de données sans spécifier l'ID
        Pret newPret = new Pret(334, new Date(System.currentTimeMillis()), 155000.0f);
        pretService.add(newPret);

        //  Mise à jour du prêt
        Pret pret = new Pret(1, new Date(System.currentTimeMillis()), 5000.0f);
        int oldId = 1;  // L'ID existant à mettre à jour
        pret.setMontant_pret(3000.0f);
        pret.setDate_pret(new Date(System.currentTimeMillis() + 86400000)); // ✅ Nouvelle date (demain)

        pretService.update(pret, oldId);

        //  Suppression du prêt
        pretService.delete(334); // Remplace 334 par l'ID que tu veux supprimer

        //  Affichage de tous les prêts lors de l'exécution
        System.out.println("\nListe des prêts existants :");
        for (Pret p : pretService.getAll()) {
            System.out.println("ID: " + p.getId_pret() + ", Montant: " + p.getMontant_pret() + ", Date: " + p.getDate_pret());
        }

        //  Gestion des réponses
        // Ajout d'une réponse
        Reponse newReponse = new Reponse(1, "2025-02-11", "Approuvé", 2000.0, 200.0, 50.0);
        reponseService.add(newReponse);

        // Mise à jour de la réponse
        Reponse reponseToUpdate = new Reponse(1, "2025-02-12", "Refusé", 1000.0, 150.0, 30.0);
        reponseService.update(reponseToUpdate, 1);

        // Suppression d'une réponse
        reponseService.delete(1);

        // Affichage de toutes les réponses
        System.out.println("\nListe des réponses existantes :");
        for (Reponse r : reponseService.getAll()) {
            System.out.println("ID: " + r.getId_reponse() + ", Date: " + r.getDate_reponse() + ", Décision: " + r.getDecision() + ", Montant: " + r.getMontant() + ", Amortissement: " + r.getAmortissement() + ", Intérêt: " + r.getInteret());
        }
    }
}
