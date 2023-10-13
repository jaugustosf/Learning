package oop.salary;

import oop.entities.Person;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Person person = new Person();

        System.out.print("Name: ");
        person.name = sc.nextLine();
        System.out.print("Gross salary: ");
        person.grossSalary = sc.nextDouble();
        System.out.print("Tax: ");
        person.tax = sc.nextDouble();

        System.out.println();
        System.out.printf("Employee: " + person);

        System.out.println();
        System.out.print("Which percentage to increase salary? ");
        double percentage = sc.nextDouble();
        person.increaseSalary(percentage);

        System.out.println();
        System.out.printf("Updated employee: " + person);

        sc.close();
    }
}
