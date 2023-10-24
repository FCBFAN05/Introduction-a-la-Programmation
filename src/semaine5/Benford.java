package semaine5;
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        20/10/2023
 */

public class Benford {
    /* METHODES UTILTAIRES FOURNIES*/

    // affichage  d'un tableau d'entiers
    public static void print(int[] tab) {
        for (int i = 0; i < tab.length; ++i) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }

    // affichage  d'un tableau de doubles
    public static void print(double[] tab) {
        for (int i = 0; i < tab.length; ++i) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] frequencies = new int[9];
        double[] numbers = new double[25];

        //  TEST 1.1
        System.out.println("Test 1.1 : ");
        fillWithSquare(numbers);
        print(numbers);
        System.out.println();
        // FIN TEST 1.1

        //TEST 1.2
        System.out.println("Test 1.2 : ");
        System.out.println(extractMaxDigit(0));
        System.out.println(extractMaxDigit(632));
        System.out.println(extractMaxDigit(-221));
        System.out.println(extractMaxDigit(-554.15));
        System.out.println(extractMaxDigit(0.00421));
        System.out.println();
        // FIN TEST 1.2

        //  TEST 1.3
        System.out.println("Test 1.3 : ");
        analyze(numbers, frequencies);
        print(frequencies);
        System.out.println();
        // FIN TEST 1.3

        // TEST 1.4
        System.out.println("Test 1.4 : ");
        testBenford(frequencies, numbers.length);
        // FIN TEST 1.4
    }

    // Methodes programmé moi-même
    // numbers[i] stocke le carré de i+1 divisé par 100.0 . Le tableau fourni à la méthode sera intégralement rempli.
    //Le tableau numbers stocke en fait la suite de nombres sur laquelle nous allons tester la loi de Benford.
    static void fillWithSquare(double[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Math.pow(i+1,2)/100.0;
        }
    }

    // retourne le chiffre le plus à gauche de number
    static int extractMaxDigit(double number)  {
        if (number == 0) {
            return 0;
        } else if (number < 0) {
            number *= (-1);
        }
        while (number < 1) {
            number *= 10;
        }
        while (number >= 10) {
            number /= 10;
        }
        return (int) number;
    }

    static void analyze(double[] numbers, int[] occurences) {
        for (int i = 0; i < occurences.length; ++i) {
            for (double number : numbers) {
                if ((i + 1) == extractMaxDigit(number)) {
                    occurences[i]++;
                }
            }
        }
    }

    static void testBenford(int[] occurences, int lengthArray) {
        double[] occurencesDouble = new double[occurences.length];
        System.out.println("Pourcentage effectif / Predictions de la loi de Benford :");
        for (int i = 0; i < occurences.length; ++i) {
            occurencesDouble[i] = occurences[i];
            occurencesDouble[i] /= lengthArray;
            occurencesDouble[i] *= 100;
            double Benford = Math.log10(1 + 1 /(double) (i+1))*100;
            System.out.println((i+1) + " : " + occurencesDouble[i] + "%, Benford : " + Benford + "%");
        }
    }

}
