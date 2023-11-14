package semaine7.banque;
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        12/11/2023
 */

class Banque1 {

    public static void main(String[] args) {
        // DonnÃ©es pour tous les comptes privÃ©s (taux d'intÃ©rÃªt):
        double taux1 = 0.01;
        // DonnÃ©es pour tous les comptes d'Ã©pargne (taux d'intÃ©rÃªt):
        double taux2 = 0.02;
        // DonnÃ©es pour le premier client (nom et ville):
        String nom1 = "Pedro";
        String ville1 = "Geneve";
        // DonnÃ©es pour le compte privÃ© du premier client (solde):
        double solde1PremierClient = 1000.0;
        // DonnÃ©es pour le compte d'Ã©pargne du premier client (solde):
        double solde2PremierClient = 2000.0;
        // DonnÃ©es pour le deuxiÃ¨me client (nom et ville):
        String nom2 = "Alexandra";
        String ville2 = "Lausanne";
        // DonnÃ©es pour le compte privÃ© du deuxiÃ¨me client (solde):
        double solde1DeuxiemeClient = 3000.0;
        // DonnÃ©es pour le compte d'Ã©pargne du deuxiÃ¨me client (solde):
        double solde2DeuxiemeClient = 4000.0;

        // Afficher les donnÃ©es du premier client:
        afficherClient(nom1, ville1, solde1PremierClient, solde2PremierClient);
        // Afficher les donnÃ©es du deuxiÃ¨me client:
        afficherClient(nom2, ville2, solde1DeuxiemeClient, solde2DeuxiemeClient);

        // Bouclement du compte privÃ© du premier client:
        solde1PremierClient = bouclerCompte(solde1PremierClient, taux1);
        // Bouclement du compte d'Ã©pargne du premier client:
        solde2PremierClient = bouclerCompte(solde2PremierClient, taux2);
        // Bouclement du compte privÃ© du deuxiÃ¨me client:
        solde1DeuxiemeClient = bouclerCompte(solde1DeuxiemeClient, taux1);
        // Bouclement du compte d'Ã©pargne du deuxiÃ¨me client:
        solde2DeuxiemeClient = bouclerCompte(solde2DeuxiemeClient, taux2);

        // Afficher les donnÃ©es du premier client:
        afficherClient(nom1, ville1, solde1PremierClient, solde2PremierClient);
        // Afficher les donnÃ©es du deuxiÃ¨me client:
        afficherClient(nom2, ville2, solde1DeuxiemeClient, solde2DeuxiemeClient);
    }

    static void afficherClient(String nom, String ville,
                               double solde1, double solde2) {
        // Cette mÃ©thode affiche les donnÃ©es du client
        System.out.println("Client " + nom + " de " + ville);
        System.out.println("   Compte prive:     " + solde1 + " francs");
        System.out.println("   Compte d'epargne: " + solde2 + " francs");
    }

    static double bouclerCompte(double solde, double taux) {
        // Cette mÃ©thode ajoute les intÃ©rÃªts au solde
        double interets = taux * solde;
        double nouveauSolde = solde + interets;
        return nouveauSolde;
    }
}
