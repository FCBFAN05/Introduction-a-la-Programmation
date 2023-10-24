package semaine4;
import java.util.Scanner;

public class Conversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez une seule lettre A..Z ou a..z :");
        char input = scanner.next().charAt(0);
        int output;
        if ((int) input >= 65 && (int) input <= 90) {
            output = input + 32;
            System.out.println("Version minuscule: " + (char) output);
        } else if ((int) input >= 97 && (int) input <= 122) {
            output = input - 32;
            System.out.println("Version majuscule: " + (char) output);
        } else
            System.out.println("Caractere non valable");

    }
}
