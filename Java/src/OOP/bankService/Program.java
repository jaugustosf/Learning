package OOP.bankService;

import Strings.Scan;
import entities.BankAccount;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account ID:");
        int id = sc.nextInt();

        System.out.print("Enter account name:");
        sc.nextLine(); //Para consumir o pulo de linha do nextInt.
        String name = sc.nextLine();

        System.out.print("Do you want to make your first deposit? | (Y/N):");
        char option = sc.next().toLowerCase().charAt(0);

        if(option == 'y'){
            System.out.print("Enter initial deposit value:");
            double value = sc.nextDouble();
            BankAccount bankAccount = new BankAccount(id, name, value);
        }else{
            BankAccount bankAccount = new BankAccount(id, name);
        }

        System.out.println("Account data:");
        System.out.printf("ID: %d; Name: %s; Amount: %.2f",id,name,value);


        sc.close();
    }
}
