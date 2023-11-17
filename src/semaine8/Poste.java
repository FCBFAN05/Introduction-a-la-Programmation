package semaine8;
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        17/11/2023
 */

import java.util.Arrays;

// PROGRAMME PRINCIPAL (A NE PAS MODIFIER)
public class Poste {

    public static void main(String[] args) {
        //Cr'eation d'une boite-aux-lettres
        // 30  est la capacit'e maximale de la
        // boite aux lettres
        // (pas necessaire si vous dÃªcidez d'utiliser
        // un ArrayList).
        Boite boite = new Boite(30);

        //Creation de divers courriers/colis..
        Lettre lettre1 = new Lettre(200, true, "Chemin des Acacias 28, 1009 Pully", "A3");
        Lettre lettre2 = new Lettre(800, false, "", "A4"); // invalide

        Publicite pub1 = new Publicite(1500, true, "Les Moilles  13A, 1913 Saillon");
        Publicite pub2 = new Publicite(3000, false, ""); // invalide

        Colis colis1 = new Colis(5000, true, "Grand rue 18, 1950 Sion", 30);
        Colis colis2 = new Colis(3000, true, "Chemin des fleurs 48, 2800 Delemont", 70); //Colis invalide !

        boite.ajouterCourrier(lettre1);
        boite.ajouterCourrier(lettre2);
        boite.ajouterCourrier(pub1);
        boite.ajouterCourrier(pub2);
        boite.ajouterCourrier(colis1);
        boite.ajouterCourrier(colis2);


        System.out.println("Le montant total d'affranchissement est de " +
                boite.affranchir());
        boite.afficher();

        System.out.println("La boite contient " + boite.courriersInvalides()
                + " courriers invalides");
    }
}

class Courrier {
    private final double poids;
    private final boolean mode;
    private final String adresse;

    Courrier(double poids, boolean mode, String adresse) {
        this.poids = poids;
        this.mode = mode;
        this.adresse = adresse;
    }

    public boolean isMode() {
        return mode;
    }

    public double getMontant() {
        if (isNotValid()) {
            return 0.0;
        } else {
            double montant = this.poids/1000;
            if (this.mode) {
                montant *= 2;
            }
            return montant;
        }
    }

    public boolean isNotValid() {
        return this.adresse == null || this.adresse.isEmpty();
    }

    public void afficher() {
        if (isNotValid()) {
            System.out.println("(Courrier invalide)");
        }
        System.out.println("Poids : " + this.poids + " grammes");
        System.out.print("Express : ");
        if (this.mode) {
            System.out.println("oui");
        } else {
            System.out.println("non");
        }
        System.out.println("Destination : " + this.adresse);
        System.out.println("Prix : " + getMontant() + " CHF");
    }

}

class Lettre extends Courrier {
    private final String format;

    Lettre(double poids, boolean mode, String adresse, String format) {
        super(poids, mode, adresse);
        this.format = format;
    }

    public double getMontant() {
        if (isNotValid()) {
            return 0.0;
        }
        double montant = super.getMontant();
        if (this.format.equals("A4")) {
            if (super.isMode()) {
                montant += 2.50 * 2;
            } else {
                montant += 2.50;
            }
        } else {
            if (super.isMode()) {
                montant += 3.50 * 2;
            } else {
                montant += 3.50;
            }
        }
        return montant;
    }

    public void afficher() {
        System.out.println("Lettre");
        super.afficher();
        System.out.println("Format : " + this.format);
        System.out.println();
    }

}

class Colis extends Courrier {
    private final double volume;


    Colis(double poids, boolean mode, String adresse, double volume) {
        super(poids, mode, adresse);
        this.volume = volume;
    }

    public double getMontant() {
        if (isNotValid()) {
            return 0.0;
        }
        double montant = super.getMontant();
        if (isMode()) {
            montant += 0.5 * this.volume;
        } else {
            montant += 0.25 * this.volume;
        }
        return montant;
    }

    public boolean isNotValid() {
        return super.isNotValid() || !(volume <= 50);
    }

    public void afficher() {
        System.out.println("Colis");
        super.afficher();
        System.out.println("Volume : " + this.volume + " litres");
        System.out.println();
    }
}

class Publicite extends Courrier {

    Publicite(double poids, boolean mode, String adresse) {
        super(poids, mode, adresse);
    }

    public double getMontant() {
        if (isNotValid()) {
            return 0.0;
        }
        return super.getMontant() * 5.0;
    }

    public void afficher() {
        System.out.println("Publicité");
        super.afficher();
        System.out.println();
    }
}

class Boite {
    Courrier[] courriels;
    int index = 0;

    Boite(int maxSize) {
        this.courriels = new Courrier[maxSize];
    }

    public double affranchir() {
        double sum = 0.0;
        for (int i = 0; i < this.index; i++) {
            sum += courriels[i].getMontant();
        }
        return sum;
    }

    public void ajouterCourrier(Courrier courrier) {
        if (this.index < this.courriels.length) {
            this.courriels[this.index] = courrier;
            this.index++;
        } else System.out.println("Boite est déjà rempli!");
    }

    public int courriersInvalides() {
        int total = 0;
        for (int i = 0; i < index; i++) {
            if (courriels[i].isNotValid()) {
                total++;
            }
        }
        return total;
    }

    public void afficher() {
        for (int i = 0; i < index; i++) {
            courriels[i].afficher();
        }
    }
}
