package semaine2;

import java.util.Scanner;

public class Degre3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        int b;
        int c;
        double x;
        double poly;
 /* Entrez les valeurs*/
        System.out.println("Entrez a (int) :");
        a = scanner.nextInt();
        System.out.println("Entrez b (int) :");
        b = scanner.nextInt();
        System.out.println("Entrez c (int) :");
        c = scanner.nextInt();
        System.out.println("Entrez x (int) :");
        x = scanner.nextDouble();
        /*output*/
        poly = ((a + b) / 2.0) * Math.pow(x, 3) + Math.pow((a + b), 2) * Math.pow(x, 2) + a + b + c;
        System.out.println("  La valeur du polynôme est :" + poly);

    }
}
