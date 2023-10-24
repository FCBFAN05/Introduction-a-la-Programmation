package semaine3;
import java.util.Scanner;
public class Bilan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int montantTotal = 0;
        int montantMax = 0;
        int montantMin = 0;

        System.out.println("Donnez n:");
        n = scanner.nextInt();
        int[] montant = new int [n];

        for (int i = 1; i <= n; i++) {
            System.out.println("Donnez le montant du mois " + i + " (Frs)");
            montant[i-1] = scanner.nextInt();
            montantTotal += montant[i-1];
            montantMax = montant[0];
            if (montant[i-1] > montantMax) {
                montantMax = montant[i-1];
            } else {
                montantMin = montant[0];
                if (montant[i-1] < montantMin) {
                    montantMin = montant[i-1];
                }
            }
        }
        int moyenne = montantTotal / n;
        System.out.println("La somme mensuelle moyenne reçue est: " + moyenne);
        System.out.println("Le montant maximal reçu est: " + montantMax);
        System.out.println("Le montant minimal reçu est: " + montantMin);
    }
}
