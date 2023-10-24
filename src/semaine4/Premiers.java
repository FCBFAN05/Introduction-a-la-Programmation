package semaine4;

import java.util.ArrayList;

public class Premiers {
    // Ecrivez le programme Premiers.java qui stocke dans un tableau dynamique l'ensemble
    // des nombres premiers compris entre 2 et 100 et affiche le contenu de ce tableau.
    public static void main(String[] args) {
        ArrayList<Integer> premiers = new ArrayList<>();
        boolean premier;
        for (int i = 2; i <= 100; ++i) {
            if (i % 2 != 0 || i == 2) {
                premier = true;
                for (int j = 3; j < i && j <= Math.sqrt(i); j += 2) {
                    if (i % j == 0) {
                        premier = false;
                        break;
                    }
                }
            } else
                premier = false;
            if (premier) {
                premiers.add(i);
            }
        }
        for (Integer allPremiers : premiers) {
            System.out.println(allPremiers);
        }
    }
}
