package controller;

import compagnie.Vol;
import compagnie.CompagnieAerienne;
import gestion.AeroportManager;
import moyens.Pave;
import moyens.Reclamation;

import java.util.Scanner;

public class AgentController {
    private AeroportManager manager;
    private Scanner scanner;

    public AgentController(AeroportManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void lancerMenu() {
        int choix;
        do {
            System.out.println("\n=== Menu Agent de Planification ===");
            System.out.println("1. Créer un vol");
            System.out.println("2. Voir tous les vols");
            System.out.println("3. Créer une réclamation");
            System.out.println("4. Voir les réclamations");
            System.out.println("5. Supprimer une réclamation");
            System.out.println("6. Modifier une réclamation");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = Integer.parseInt(scanner.nextLine());

            switch (choix) {
                case 1:
                    creerVol();
                    break;
                case 2:
                    afficherVols();
                    break;
                case 3:
                    creerReclamation();
                    break;
                case 4:
                    afficherReclamations();
                    break;
                case 5:
                    supprimerReclamation();
                    break;
                case 6:
                    modifierReclamation();
                    break;
                case 0:
                    System.out.println("Déconnexion...");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } while (choix != 0);
    }

    private void creerVol() {
        if (manager.getCompagnies().isEmpty() || manager.getPistes().isEmpty()) {
            System.out.println("Impossible de créer un vol : il faut au moins une compagnie et une piste.");
            return;
        }

        System.out.print("Code du vol : ");
        String codeVol = scanner.nextLine();

        System.out.println("Sélectionnez une compagnie :");
        for (int i = 0; i < manager.getCompagnies().size(); i++) {
            System.out.println(i + ". " + manager.getCompagnies().get(i).getNom());
        }
        int choixCompagnie = Integer.parseInt(scanner.nextLine());
        CompagnieAerienne compagnie = manager.getCompagnies().get(choixCompagnie);

        System.out.println("Sélectionnez une piste :");
        for (int i = 0; i < manager.getPistes().size(); i++) {
            System.out.println(i + ". " + manager.getPistes().get(i).getIdentifiant());
        }
        int choixPiste = Integer.parseInt(scanner.nextLine());
        Pave pave = manager.getPistes().get(choixPiste);

        Vol vol = new Vol(codeVol, compagnie, pave);
        compagnie.ajouterVol(vol);
        manager.ajouterVol(vol);

        System.out.println("Vol créé avec succès !");
    }

    private void afficherVols() {
        if (manager.getVols().isEmpty()) {
            System.out.println("Aucun vol planifié.");
            return;
        }

        System.out.println("Liste des vols :");
        for (Vol v : manager.getVols()) {
            System.out.println("- " + v);
        }
    }

    private void creerReclamation() {
        if (manager.getVols().isEmpty()) {
            System.out.println("Aucun vol disponible.");
            return;
        }

        System.out.println("Sélectionnez un vol :");
        for (int i = 0; i < manager.getVols().size(); i++) {
            System.out.println(i + ". " + manager.getVols().get(i));
        }
        int choixVol = Integer.parseInt(scanner.nextLine());
        Vol vol = manager.getVols().get(choixVol);

        System.out.print("Contenu de la réclamation : ");
        String contenu = scanner.nextLine();

        Reclamation r = new Reclamation(contenu);
        vol.ajouterReclamation(r);

        System.out.println("Réclamation ajoutée au vol " + vol.getCodeVol());
    }

    private void afficherReclamations() {
        if (manager.getVols().isEmpty()) {
            System.out.println("Aucun vol disponible.");
            return;
        }

        System.out.println("Sélectionnez un vol :");
        for (int i = 0; i < manager.getVols().size(); i++) {
            System.out.println(i + ". " + manager.getVols().get(i));
        }
        int choixVol = Integer.parseInt(scanner.nextLine());
        Vol vol = manager.getVols().get(choixVol);

        if (vol.getReclamations().isEmpty()) {
            System.out.println("Aucune réclamation pour ce vol.");
            return;
        }

        System.out.println("Réclamations pour le vol " + vol.getCodeVol() + " :");
        for (Reclamation r : vol.getReclamations()) {
            System.out.println("- " + r);
        }
    }


    private void supprimerReclamation()
    {
        if (manager.getVols().isEmpty()) {
            System.out.println("Aucun vol disponible.");
            return;
        }

        System.out.println("Sélectionnez un vol :");
        for (int i = 0; i < manager.getVols().size(); i++) {
            System.out.println(i + ". " + manager.getVols().get(i));
        }
        int choixVol = Integer.parseInt(scanner.nextLine());
        Vol vol = manager.getVols().get(choixVol);

        if (vol.getReclamations().isEmpty()) {
            System.out.println("Aucune réclamation pour ce vol.");
            return;
        }

        System.out.println("Sélectionnez la réclamation à supprimer :");
        for (int i = 0; i < vol.getReclamations().size(); i++) {
            System.out.println(i + ". " + vol.getReclamations().get(i));
        }
        int choixReclamation = Integer.parseInt(scanner.nextLine());
        Reclamation reclamation = vol.getReclamations().get(choixReclamation);

        vol.getReclamations().remove(reclamation);
        System.out.println("Réclamation supprimée avec succès.");

    }
    private void modifierReclamation() {
        if (manager.getVols().isEmpty()) {
            System.out.println("Aucun vol disponible.");
            return;
        }

        System.out.println("Sélectionnez un vol :");
        for (int i = 0; i < manager.getVols().size(); i++) {
            System.out.println(i + ". " + manager.getVols().get(i));
        }
        int choixVol = Integer.parseInt(scanner.nextLine());
        Vol vol = manager.getVols().get(choixVol);

        if (vol.getReclamations().isEmpty()) {
            System.out.println("Aucune réclamation pour ce vol.");
            return;
        }

        System.out.println("Sélectionnez la réclamation à modifier :");
        for (int i = 0; i < vol.getReclamations().size(); i++) {
            System.out.println(i + ". " + vol.getReclamations().get(i).getContenu());
        }
        int choixRec = Integer.parseInt(scanner.nextLine());
        Reclamation reclamation = vol.getReclamations().get(choixRec);

        System.out.print("Nouveau contenu de la réclamation : ");
        String nouveauContenu = scanner.nextLine();

        reclamation.setContenu(nouveauContenu.trim());
        System.out.println("Réclamation modifiée avec succès.");
    }




}
