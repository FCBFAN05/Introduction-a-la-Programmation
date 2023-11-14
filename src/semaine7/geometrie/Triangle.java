package semaine7.geometrie;
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        14/11/2023
 */

import java.util.Scanner;

public class Triangle {
    private Point p1;
    private Point p2;
    private Point p3;

    Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    private double calculateDistance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2)
                + Math.pow(point1.getY() - point2.getY(), 2));
    }

    public double determinePerimeter() {
        return calculateDistance(p1, p2) + calculateDistance(p2, p3)
                + calculateDistance(p3, p1);
    }

    public boolean determineIsocele() {
        return (calculateDistance(p1, p2) == calculateDistance(p1, p3))
                || (calculateDistance(p1, p3) == calculateDistance(p2, p3))
                || (calculateDistance(p1, p2) == calculateDistance(p2, p3));
    }

    private static Scanner scanner = new Scanner(System.in);

    public Point createPoint() {
        System.out.println("Construction d'un nouveau point");
        System.out.print("Veuillez entrer x : ");
        double x = scanner.nextDouble();
        System.out.print("Veuillez entrer y : ");
        double y = scanner.nextDouble();
        return new Point(x, y);
    }
}
