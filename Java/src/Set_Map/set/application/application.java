package Set_Map.set.application;

import java.io.Serial;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> serieA = new HashSet<>();
        Set<Integer> serieB = new HashSet<>();
        Set<Integer> serieC = new HashSet<>();

        System.out.print("How much studants has in Serie A:");
        int numbOfStudents = sc.nextInt();

        for(int i = 0; i < numbOfStudents; i++ ){
            int informedNumber =  sc.nextInt();
            serieA.add(informedNumber);
        }

        System.out.print("How much studants has in Serie B:");
        numbOfStudents = sc.nextInt();

        for(int i = 0; i < numbOfStudents; i++ ){
            int informedNumber =  sc.nextInt();
            serieB.add(informedNumber);
        }

        System.out.print("How much studants has in Serie C:");
        numbOfStudents = sc.nextInt();

        for(int i = 0; i < numbOfStudents; i++ ){
            int informedNumber =  sc.nextInt();
            serieC.add(informedNumber);
        }

        Set<Integer> totalStudents = new HashSet<>(serieA);
        totalStudents.addAll(serieB);
        totalStudents.addAll(serieC);

        System.out.println("Total numbers of Students: " + totalStudents.size());
    }
}
