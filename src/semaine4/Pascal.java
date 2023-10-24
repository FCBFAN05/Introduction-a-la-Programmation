package semaine4;

import java.util.Scanner;

public class Pascal {
    public static void main(String[] args) {
        // Écrire un programme qui demande à l'utilisateur d'entrer un nombre n>=1,
        // qui stocke le triangle de Pascal de taille n dans un tableau de tableaux et qui l'affiche.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez un nombre n >= 1: ");
        int n = scanner.nextInt();
        if (n < 1) {
            System.out.println("Entrez un nombre n >= 1: ");
            n = scanner.nextInt();
        }
        int[][] pascal = new int[n][n];
        pascal[0][0] = 1;
        for (int i = 1; i < n; ++i) {
            pascal[i][0] = 1;
            pascal[i][i] = 1;
            for (int j = 1; j < n - 1; ++j) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                System.out.print(pascal[i][j] + " ");
            }
            System.out.println();
        }
    }
}
