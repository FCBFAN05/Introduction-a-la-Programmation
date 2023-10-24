package semaine3;

import java.math.BigInteger;

public class CombiPermu {
    public static void main(String[] args) {
        /* Formule math'ematique calculant le nombre de  permutations de k
         * 'elements parmis n: (n!)/(n-k)!
         * Formule math'ematique calculant le nombre de combinaisons de k
         * 'elements parmis n: (n!)/(k!*(n-k)!)
         */
        //valeurs à  définir
        int n = 10;
        int k = 6;

        //Réaliser le calcul du nombre de permutations et de combinaisons
        //avec les deux valeurs n et k et les formules données

        // Factorials
        int nFactorial = n;
        for (int i = n; i >= 1; i--) {
            nFactorial *= i;
        }
        int kFactorial = k;
        for (int i = k; i >= 1; i--) {
            kFactorial *= i;
        }
        int nMinusKFactorial = n-k;
        for (int i = (n-k); i >= 1; i--) {
            nMinusKFactorial *= i;
        }
        // permutations
        int permutations = nFactorial/nMinusKFactorial;
        System.out.println(permutations);

        // combinaisons
        int combinaisons = nFactorial/(kFactorial*nMinusKFactorial);
        System.out.println(combinaisons);

        // Factorials with BigInteger
        BigInteger nFactorialBig = BigInteger.valueOf(n);
        for (int i = n; i >= 1; i--) {
            nFactorialBig = nFactorialBig.multiply(BigInteger.valueOf(i));
        }
        BigInteger kFactorialBig = BigInteger.valueOf(k);
        for (int i = k; i >= 1; i--) {
            kFactorialBig = kFactorialBig.multiply(BigInteger.valueOf(i));
        }
        BigInteger nMinusKFactorialBig = BigInteger.valueOf(n-k);
        for (int i = (n-k); i >= 1; i--) {
            nMinusKFactorialBig = nMinusKFactorialBig.multiply(BigInteger.valueOf(i));
        }
        // permutations
        BigInteger permutationsBig = nFactorialBig.divide(nMinusKFactorialBig);
        System.out.println(permutationsBig);

        // combinaisons
        BigInteger combinaisonsBig = nFactorialBig.divide(kFactorialBig.multiply(nMinusKFactorialBig));
        System.out.println(combinaisonsBig);
        
    }
}
