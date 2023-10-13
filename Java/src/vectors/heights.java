package vectors;

import vectors.entities.Person;

import java.util.Locale;
import java.util.Scanner;

public class heights {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int tam = sc.nextInt();
        Person[] vector = new Person[tam];

        for(int i = 0; i < vector.length; i++){
            sc.nextLine(); //Absorve a linha anterior sobrando.
            System.out.printf("Data values person %d\n", i+1);

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("YO: ");
            int yo = sc.nextInt();

            System.out.print("Height: ");
            double height = sc.nextDouble();

            vector[i] = new Person(name, yo, height);
        }

        double med = 0;
        for(int i = 0; i < vector.length; i++){
            med += vector[i].getHeight();
        }

        int underYO = 0;
        for(int i = 0; i < vector.length; i++){
            if(vector[i].getYo() < 16){
                underYO++;
            }
        }

        double percentage = ((double) underYO /vector.length) * 100.0;

        System.out.println();
        System.out.printf("Media %.2f\n", med/vector.length);
        System.out.printf("People under 16: %.2f%%\n", percentage);

        for(int i = 0; i < vector.length; i++){
            if(vector[i].getYo() < 16){

                System.out.printf("Name person %d: %s", i+1, vector[i].getName());
            }
        }

        sc.close();
    }
}
