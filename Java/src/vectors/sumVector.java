package vectors;

import java.util.Locale;
import java.util.Scanner;

public class sumVector {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int tam = sc.nextInt();
        double[] vector = new double[tam];

        for(int i = 0; i < vector.length; i++){
            System.out.print("Digite um numero: ");
            vector[i] = sc.nextInt();
        }

        System.out.print("Values: ");
        for(int i = 0; i < vector.length; i++){
            System.out.print(vector[i] + " ");
        }

        double sum = 0;
        for(int i = 0; i < vector.length; i++){
            sum += vector[i];
        }

        System.out.println();
        System.out.printf("Soma: %.2f\n", sum);
        System.out.printf("Media %.2f\n", sum/vector.length);
        sc.close();
    }
}
