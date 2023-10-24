package semaine2;

import java.util.Scanner;

public class Fondue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double BASE = 4;
        double fromage = 800.0;
        double eau = 2.0;
        double ail = 2.0;
        double pain = 400.0;
        double nbconvives;

        System.out.println("Entrez le nombre de personne(s) conviée(s) à la fondue :");
        nbconvives = scanner.nextDouble();
        /* adapt ingredients to persons */
        fromage *= (nbconvives / BASE);
        eau *= (nbconvives / BASE);
        ail *= (nbconvives / BASE);
        pain *= (nbconvives / BASE);

        System.out.println("Pour faire une fondue fribourgeoise pour " + nbconvives + "personnes, il vous faut :");
        System.out.println(" - " + fromage + " gr de Vacherin fribourgeois");
        System.out.println(" - " + eau + " dl d'eau");
        System.out.println(" - " + ail + " gousse(s) d'ail");
        System.out.println(" - " + pain + " gr de pain");
        System.out.println(" - du poivre à volonté");
    }
}
