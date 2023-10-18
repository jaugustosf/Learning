package vectors.forEach;

import vectors.entities.Person;
import vectors.entities.Rent;

import java.util.Locale;
import java.util.Scanner;

public class roomAllocation2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many rooms will e rented? ");
        int size = sc.nextInt();
        Rent[] vector = new Rent[10];

        for(int i = 0; i< size; i++){
            System.out.printf("Rent #%d\n", i+1);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Room: ");
            int idRoom = sc.nextInt();

            vector[idRoom] = new Rent(name, email);
        }

        System.out.println("Busy rooms:");
        int index = 0;
        for(Rent vect : vector){
            if(vect != null){
                System.out.printf("%d: %s, %s\n",index , vect.getName(), vect.getEmail());
            }
            index++;
        }
    }
}
