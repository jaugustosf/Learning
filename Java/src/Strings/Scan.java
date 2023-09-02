package Strings;

import java.util.Scanner;
import java.util.Locale;
public class Scan{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US); //Para poder digitar número com vírgula.

//        int x;
//        x = sc.nextInt();
//        System.out.printf("Voce digitou: %d", x);

//        double y;
//        x = sc.nextDouble();
//        System.out.printf("Voce digitou: %.2f", y);

//        char z;
//        z = sc.next().charAt(0); //Vai pegar o primeiro char.
//        System.out.printf("Voce digitou: %c", z);

//        String x;
//        int y;
//        double z;
//
//        x = sc.next();
//        y = sc.nextInt();
//        z = sc.nextDouble();
//
//        System.out.println("Dados digitados:");
//        System.out.println(x);
//        System.out.println(y);
//        System.out.println(z);

        String s1,s2;
        s1 = sc.nextLine(); //Recebe a entrada a partir do "Enter" do usuário.
        s2 = sc.nextLine();
        System.out.println(s1);
        System.out.println(s2);
    }
}