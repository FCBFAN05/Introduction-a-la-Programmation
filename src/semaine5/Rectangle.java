package semaine5;
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        20/10/2023
 */

import java.util.Scanner;

public class Rectangle {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double largeur = lireDonnee("largeur");
        double hauteur = lireDonnee("hauteur");

        boolean donneesOk = testerDonnees(largeur, hauteur);

        if (donneesOk) {
            calculer(largeur, hauteur);
        } else {
            afficherErreur();
        }
    }

    // reads Input (sides of rectangle)
    static double lireDonnee(String side) {
        System.out.println("Donnez la " + side + " du rectangle: ");
        return scanner.nextDouble();
    }

    // tests if values are possible
    static boolean testerDonnees(double input1, double input2) {
        return input1 > 0 && input2 > 0;
    }

    static void calculer(double side1, double side2) {
        String type;
        do {
            System.out.print("Surface ('s/S') ou perimètre ('p/P')?: ");
            type = scanner.next();
            switch (type) {
                case "s":
                case "S":
                    System.out.println("La surface est: " + (side1 * side2));
                    break;
                case "p":
                case "P":
                    System.out.println("La hauteur est: " + (2 * (side1 + side2)));
                    break;
            }
        } while (!type.equals("s") && !type.equals("S") && !type.equals("p") && !type.equals("P"));
    }

    static void afficherErreur() {
        System.out.println("Erreur: vous avez introduit une largeur ou une hauteur négative!Erreur: vous avez introduit" +
                " une largeur ou une hauteur négative!");
    }
}
