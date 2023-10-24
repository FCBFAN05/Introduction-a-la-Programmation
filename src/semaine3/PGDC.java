package semaine3;
import java.util.Scanner;
public class PGDC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.println("Entrez un nombre positif :");
        int aIn = scanner.nextInt();
        System.out.println("Entrez un nombre positif :");
        int bIn = scanner.nextInt();

        //PGDC
        int a = aIn;
        int b = bIn;
        while (a > b) {
                a -= b;
        } while (a < b) {
            int temp = a;
            a = b;
            b = temp;
            a -= b;
        }
        if (a == b) {
            System.out.println("Le plus grand diviseur commun de " + aIn + " et " + bIn + " est " + a);
        }
    }
}
