package semaine7.geometrie;
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        14/11/2023
 */

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Point p1 = createPoint();
        Point p2 = createPoint();
        Point p3 = createPoint();
        Triangle triangle = new Triangle(p1, p2, p3);
        System.out.println("Périmètre: " + triangle.determinePerimeter());
        if (triangle.determineIsocele()) {
            System.out.println("Le triangle est isocèle");
        } else {
            System.out.println("Le triangle n'est pas isocèle");
        }
    }

    private static Point createPoint() {
        System.out.println("Construction d'un nouveau point");
        System.out.print("Veuillez entrer x : ");
        double x = scanner.nextDouble();
        System.out.print("Veuillez entrer y : ");
        double y = scanner.nextDouble();
        return new Point(x, y);
    }
}
