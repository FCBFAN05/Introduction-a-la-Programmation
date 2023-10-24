package semaine2;
import java.util.Scanner;
public class Echanger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;

        System.out.println("Entrez x: ");
        x = scanner.nextInt();
        System.out.println("Entrez y: ");
        y = scanner.nextInt();
        System.out.println("Avant permutation:");
        System.out.println("x : " + x);
        System.out.println("y : " + y);
        int temp = x;
        x = y;
        y = temp;
        System.out.println("Après permutation :");
        System.out.println("x : " + x);
        System.out.println("y : " + y);
    }

}
