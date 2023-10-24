package semaine3;

import java.util.Scanner;

public class PairImpair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.println("Entrez un nombre entier: ");
        n = scanner.nextInt();
        if (n == 0) {
            System.out.println("Le nombre " + n + " est zéro (et il est pair).");
        } else if (n % 2 == 0) {
            if (n < 0) {
                System.out.println("Le nombre " + n + " est négatif et pair.");
            } else {
                System.out.println("Le nombre " + n + " est positif et pair.");
            }
        } else {
            if (n < 0) {
                System.out.println("Le nombre " + n + " est négatif et impair.");
            } else {
                System.out.println("Le nombre " + n + " est positif et impair.");
            }
        }
    }
}
