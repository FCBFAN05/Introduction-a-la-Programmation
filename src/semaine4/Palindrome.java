package semaine4;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez un mot ou une phrase: ");
        String input = scanner.nextLine();

       /* for (int i = 0; i < input.length(); ++i) {
            char check = input.charAt(i);
            if (!Character.isLetter(check) || check == '\'' || check == ',' || check == '-')
                input =  input.substring(0,i) + input.substring(i+1);
        } */

        // On ne garde que les caractères alphabétiques
        String temp = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                temp += c;
            }
        }
        String inputLowerCase = temp.toLowerCase();
        int equal = 0;
        for (int i = 0; i < inputLowerCase.length(); ++i) {
            if (inputLowerCase.charAt(i) == inputLowerCase.charAt(inputLowerCase.length() - i - 1)) {
                ++equal;
            }
        }

        if (equal == inputLowerCase.length())
            System.out.println("C'est un palindrome");
        else
            System.out.println("C'est un non-palindrome");

    }
}
