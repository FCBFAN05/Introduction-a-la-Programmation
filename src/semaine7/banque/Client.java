package semaine7.banque;
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        14/11/2023
 */

import semaine7.banque.compte.Compte;
import semaine7.banque.compte.CompteEpargne;
import semaine7.banque.compte.ComptePrive;

public class Client {
    private String nom;
    private String ville;
    private boolean feminin;
    private Compte compte1;
    private Compte compte2;

    Client(String nom, String ville, boolean feminin, double solde1, double solde2) {
        this.nom = nom;
        this.ville = ville;
        this.feminin = feminin;
        this.compte1 = new ComptePrive(solde1);
        this.compte2 = new CompteEpargne(solde2);
    }

    public void afficher () {
        // Cette méthode affiche les données du client
        if (this.feminin) {
            System.out.println("Cliente " + this.nom + " de " + this.ville);
        } else {
            System.out.println("Client " + this.nom + " de " + this.ville);
        }
        System.out.println("   Compte privée:     " + compte1.getSolde() + " francs");
        System.out.println("   Compte d'épargne: " + compte2.getSolde() + " francs");
    }

    public void boucler () {
        this.compte1.boucler();
        this.compte2.boucler();
    }

}
