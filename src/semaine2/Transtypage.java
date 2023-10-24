package semaine2;

public class Transtypage {
    public static void main(String[] args) {
        int n1 = 2;
        double r1 = 2.7; //possible

        /*int*/ double n2 = 2.7; // pas possible -> double
        double r2 = 5;

        int n3 = (int) 5.6; // donne 6
        double r3 = 5.6;

        int n4 = 9;
        double r4 = /*(double)*/ n4; // le seconde double n'est pas nécessaire
        double r5 = (int) r4; //Arrondi r4

        int n5 = 19 / 4;
        /*int*/double n6 = n5 / r5; // On peut pas diviser un int sur un double
        double r6 = 5.0;
        int n7 = (int) (n5 / r5);
        double r7 = 19.0 / r6;

        double r8 = 15.0 / n3;
        double r9 = 19 / 4;
        double r10 = (double) (19 / 4);
        double r11 = (double) 19 / (double) 4;
    }
}
