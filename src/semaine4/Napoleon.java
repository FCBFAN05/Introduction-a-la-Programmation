package semaine4;
import java.util.Scanner;
public class Napoleon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String noms = "Napoleon Bonaparte Bill Gates Claudia Schiffer Martina Hingis ";

        System.out.println("Entrez un prénom: ");
        String input = scanner.next();

        int prenomsStart = noms.indexOf(input);
        if (prenomsStart < 0) {
            System.out.println("Inconnu au bataillon!");
        } else {
            int nomStart = noms.indexOf(' ',prenomsStart)+1;
            int nomEnd = noms.indexOf(' ', nomStart);
            String output = noms.substring(nomStart, nomEnd);
            System.out.println("Nom: " + output);
        }
    }
}
