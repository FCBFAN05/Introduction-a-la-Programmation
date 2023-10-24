package semaine2;

import java.util.Scanner;

public class RoseBlanches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int toutArgent;
        int liFou;
        int cafes;
        int flash;
        int billets;
        int rest1;
        int rest2;

        System.out.println(" Combien avez-vous reçu d'argent (Frs)?");
        toutArgent = scanner.nextInt();

        liFou = (int) (toutArgent * (3 / 4.0));
        rest1 = toutArgent - liFou;
        rest2 = rest1 % 3 + (rest1 / 3) % 4 + (rest1 / 3) % 3 + (rest1 / 3) % 2;
        cafes = (rest1 / 3) / 2;
        flash = (rest1 / 3) / 4;
        billets = (rest1 / 3) / 3;

        System.out.println("Livres et Fournitures: " + liFou + " Frs");
        System.out.println("Vous pouvez ensuite acheter:");
        System.out.println(" " + cafes + " cafes a Sat");
        System.out.println(" " + flash + " numeros du Flash");
        System.out.println(" " + billets + " billets de métro");
        System.out.println("et il vous restera " + rest2 + " Frs pour les roses blanches.");

    }
}
