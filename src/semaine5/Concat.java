package semaine5;
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        20/10/2023
 */

public class Concat {
    public static void main(String[] args) {
        String s = "China Blue";
        System.out.println(s);
        s = concatener(s, " Express");
        System.out.println(s);
    }

    static String concatener(String s, String s2) {
       return s += s2;
    }
}
