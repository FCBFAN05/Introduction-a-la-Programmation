package semaine2;

import java.util.Scanner;
public class IMC {
    public static void main(String[] args) {
        double poids;
        double taille;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un poids  (en kg) : ");
        poids = scanner.nextDouble();
        System.out.print("Entrez une taille (en m) : ");
        taille = scanner.nextDouble();

        double imc = poids / (taille * taille);

        System.out.println("Pour" + poids + " kg et " + taille
        + " m, l' Semaine2.IMC est de " + imc);
    }
}
