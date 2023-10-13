package oop.area.triangule;
import oop.entities.triangle;
import java.util.Locale;
import java.util.Scanner;

public class areaTriangleOOP {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        triangle x,y;
        x = new triangle();
        y = new triangle();

        System.out.println("Enter the measures of triangle X: ");
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();

        System.out.println("Enter the measures of triangle Y: ");
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();

        double areaX = x.area();
        double areaY = y.area();

        x.see();
        y.see();

        triangle.maior(areaX,areaY);

        sc.close();
    }
}