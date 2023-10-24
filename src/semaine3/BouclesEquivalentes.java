package semaine3;

public class BouclesEquivalentes {

    public static void main(String[] args) {
        System.out.println("Boucle for :");
        for (int a = 3; a <= 10; a++) {
            System.out.println("a : " + a);
        }

        System.out.println("Boucle while :");
        // A compléter. Ecrivez une boucle while qui fait la même chose
        // que la boucle for ci-dessus
        int b = 3;
        while (b <= 10) {
            System.out.println("b: " + b);
            b++;
        }

        System.out.println("Boucle do..while :");
        // A compléter. Ecrivez une boucle do..while qui fait la même
        // chose que la boucle for ci-dessus.
        int c = 3;
        do {
            System.out.println("c: " + c);
            c++;
        } while (c <= 10);
    }
}
