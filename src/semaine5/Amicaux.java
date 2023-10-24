package semaine5;
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        21/10/2023
 */
import java.util.ArrayList;
import java.util.List;
public class Amicaux {
    public static void main(String[] args) {
        int[] nombres = {1210, 45, 27, 220, 54, 284, 9890, 120, 1184};
        afficherAmicaux(nombres);
    }

// tests if two numbers are amical and returns boolean value
    static boolean amical(int nombre1, int nombre2) {
        if(diviseursSomme(nombre1) == diviseursSomme(nombre2) && (nombre1+nombre2) == diviseursSomme(nombre1)) {
            return true;
        } else
            return false;
    }

    // gives the sum of all dividers of a number
    static int diviseursSomme(int nb) {
        int somme = 0;
        for (int i = 1; i <= nb; i++) {
            if (nb % i == 0) {
                somme += i;
            }
        }
        return somme;
    }
// prend en entrée un tableau d’entiers et retourne toutes les paires de nombres amicaux qu’il contient
    static void afficherAmicaux(int[] nombres) {
        System.out.println("Les paires de nombres amicaux sont : ");
       for (int i = 0; i < (nombres.length)/2.0; i++) {
           for (int j = nombres.length-1; j > ((nombres.length)/2.0)-1; j--) {
               if (amical(nombres[i], nombres[j])) {
                   System.out.println(nombres[i] + " " + nombres[j]);
               }
           }
       }
    }
}
