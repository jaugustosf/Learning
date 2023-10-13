package oop.student.grade;

import oop.entities.Student;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Student student = new Student();

        student.name = sc.nextLine();
        student.note1 = sc.nextDouble();
        student.note2 = sc.nextDouble();
        student.note3 = sc.nextDouble();

        System.out.printf("FINAL GRADE: %.2f%n", student.averageGrade());
        student.noteCheck();

        sc.close();
    }
}
