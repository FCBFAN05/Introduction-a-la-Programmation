package semaine2;

import java.util.Scanner;
public class Age {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age;
        int annee = 2023;

        System.out.println("Vous avez quel âge?");
        age = scanner.nextInt();
        annee -= age;
        System.out.println("Votre année de naissance est: " + annee);


    }
}
