package semaine3;

import java.util.Scanner;

public class Intervalle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = 0.0;

        // demande à l'utilisateur d'entrer un réel et enregistre la réponse de l'utilisateur dans une variable x de type réel
        System.out.print("Entrez un nombre decimal : ");
        x = scanner.nextDouble();

        /* teste l'appartenance de x à l'ensemble I et affiche le message «x appartient à I» si c'est le cas,
         et «x n'appartient pas à I» dans le cas contraire. Ce test doit utiliser uniquement les opérateurs relationnels < et ==.
         Tous les opérateurs logiques sont, par contre, autorisés. */
        if ((x >= 2 && x < 3) || (x > 0 && x <= 1) || (x >= -10 && x <= -2)) {
            System.out.println("x appartient a I");
        } else {
            System.out.println("x n'appartient pas a I");
        }
    }
}
