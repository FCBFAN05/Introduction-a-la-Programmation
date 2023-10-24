package semaine4;
import java.util.Scanner;

public class Scalaire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nMax = 10;
        double[] v1 = new double[nMax];
        double[] v2 = new double[nMax];

        System.out.println("Entrez la taille des vecteurs: ");
        int n = scanner.nextInt();
        if (n < 1 || n > nMax) {
            System.out.println("Entrez une nouvelle valeur pour la taille des vecteurs: ");
            n = scanner.nextInt();
        }
        double prodScal = 0;
        for (int i = 0; i < n; ++i) {
            System.out.println("Donnez le composante" + i + " du vecteur v1: ");
            v1[i] = scanner.nextDouble();
            System.out.println("Donnez le composante" + i +  "du vecteur v2: ");
            v2[i] = scanner.nextDouble();
            prodScal += v1[i]*v2[i];
        }
        System.out.println("Produit scalaire: " + prodScal);
    }
}
