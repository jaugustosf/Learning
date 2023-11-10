package vectors;

import java.util.Locale;
import java.util.Scanner;

public class negatives {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar?");
        int tam = sc.nextInt();
        int[] vector = new int[tam];

        for(int i = 0; i < vector.length; i++){
            System.out.print("Digite um numero: ");
            vector[i] = sc.nextInt();
        }

        System.out.println("Negative numbers:");

        for (int j : vector) {
            if (j < 0) {
                System.out.println(j);
            }
        }

        sc.close();
    }
}
