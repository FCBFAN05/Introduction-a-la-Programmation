package semaine3;
import java.util.Scanner;
public class Rebonds1 {

    public static void main(String[] args) {
        // constants
        Scanner scanner = new Scanner(System.in);
        final double G = 9.81;

        // Inputs
        System.out.println("Entrez la hauteur initiale en mètres (>= 0): ");
        double h0 = scanner.nextDouble();
        System.out.println("Entrez le coefficient de (0 <= eps < 1): ");
        double eps = scanner.nextDouble();
        System.out.println("Entrez le nombre de rebonds (>= 0): ");
        int nbr = scanner.nextInt();

        // values
        double v = Math.sqrt(2*h0*G);
        double v1 = 0;
        double h1 = 0;

        for (int i = 1; i <= nbr; i++) {
            v1 = eps*v;
            v = v1;
            h1 = Math.pow(v1,2)/(2*G);
        }
        System.out.println("La hauteur obtenue est: " + h1);
    }
}
