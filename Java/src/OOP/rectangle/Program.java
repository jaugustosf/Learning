package OOP.rectangle;

import entities.Rectangle;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Rectangle rectangle = new Rectangle();

        System.out.println("Enter rectangle width and height");

        rectangle.width = sc.nextDouble();
        rectangle.heigth = sc.nextDouble();

        System.out.printf("Area: %.2f " , rectangle.area());

        System.out.printf("Perimeter: %.2f ", rectangle.perimeter());

        System.out.printf("Diagonal: %.2f", rectangle.diagonal());

        sc.close();
    }
}
