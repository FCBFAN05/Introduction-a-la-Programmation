package semaine3;
import java.util.Scanner;
public class Rebonds2 {
    public static void main(String[] args) {
        // constants
        Scanner scanner = new Scanner(System.in);
        final double G = 9.81;

        // Inputs
        System.out.println("Entrez la hauteur initiale en mètres (>= 0): ");
        final double h0 = scanner.nextDouble();
        System.out.println("Entrez le coefficient de (0 <= eps < 1): ");
        final double eps = scanner.nextDouble();
        System.out.println("Entrez la hauteur finale désirée ( 0 < h_fin < H0): ");
        double hFin = scanner.nextInt();

        // values
        double v = Math.sqrt(2*h0*G);
        double v1 = 0;
        double h1 = 0;
        int rebonds = 0;

        // Calculer les rebonds
        do {
            v1 = eps*v;
            v = v1;
            h1 = Math.pow(v1,2)/(2*G);
            rebonds++;
        } while (h1 > hFin);
        System.out.println("Il faut " + rebonds + " rebonds pour obtenir la hauteur " + hFin);
    }
}
