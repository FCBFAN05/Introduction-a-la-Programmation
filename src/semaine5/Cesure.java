package semaine5;
import java.util.Scanner;
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        22/10/2023
*/
public class Cesure {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String[] phrase = lirePhrase();
        System.out.println();
        System.out.println("Le résultat est : ");
        System.out.println();
        for (String s : phrase) {
            cesure(s);
        }
    }

    static String[] lirePhrase() {
        // retourne un tableau de chaines de caractÃ¨res
        // introduits par l'utilisateur
        int nbrMots;
        do {
            System.out.print("Donnez le nombre de mots dans votre phrase: ");
            nbrMots = scanner.nextInt();
        } while (nbrMots <= 0);
        String[] phrase = new String[nbrMots];
        for (int i = 0; i < nbrMots; ++i) {
            System.out.print("Donnez le mot " + (i+1) + " : ");
            phrase[i] = scanner.next();
        }
        return phrase;
    }

    static boolean voyelle(char c) {
        // teste si un caractÃ¨re est une voyelle
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u', 'y' -> true;
            default -> false;
        };
    }

    static boolean queVoyelles(String s) {
        // teste si une chaÃ®ne ne contient que des voyelles
        // utilise la mÃ©thode voyelle
        int l = 0;
        boolean voyelle;
        do {
            voyelle = voyelle(s.charAt(l));
            l++;
        } while (l < s.length() && voyelle);
       return voyelle;
    }

    static void cesure(String mot) {
        // dÃ©termine la cÃ©sure d'un mot donnÃ© et effectue les affichages
        // correspondants (voir exemple de dÃ©roulement)
        if (queVoyelles(mot) || mot.length() <= 1) {
            System.out.println(mot);
        } else {
            char[] letters = new char[mot.length()];
            for (int i = 0; i < letters.length; ++i) {
                letters[i] = mot.charAt(i);
            }
            String s01 = String.valueOf(letters[0]) + letters[1];
            switch (letters.length) {
                case 2:  System.out.println(s01);
                break;
                case 3:  System.out.println(s01 + "-");
                    System.out.print(letters[2]);
                    break;
                default: System.out.print(letters[2]);
                break;
            }
            for (int j = 3; j < letters.length-2; ++j) {
                boolean cut = (voyelle(letters[j]) && !voyelle(letters[j + 1]));
                if (cut) {
                    System.out.println(letters[j] + "-");
                } else {
                    System.out.print(letters[j]);
                }
            }
            System.out.println(String.valueOf(letters[letters.length-2]) + letters[letters.length-1]);
        }
    }
}
