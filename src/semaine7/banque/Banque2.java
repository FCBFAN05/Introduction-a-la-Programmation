package semaine7.banque;
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        12/11/2023
 */

// Version orientée objet de Banque1.java
public class Banque2 {
    public static void main(String[] args) {
        Client pedro = new Client("Pedro", "Geneve", false, 1000.0, 2000.0);
        Client alexandra = new Client("Alexandra", "Lausanne", true, 3000.0, 4000.0);

        System.out.println("Donnees avant le bouclement des comptes:");
        pedro.afficher();
        alexandra.afficher();

        pedro.boucler();
        alexandra.boucler();

        System.out.println("Donnees apres le bouclement des comptes:");
        pedro.afficher();
        alexandra.afficher();
    }

}

