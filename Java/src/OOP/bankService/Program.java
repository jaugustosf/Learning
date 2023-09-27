package OOP.bankService;

import java.util.Locale;
import java.util.Scanner;
import entities.BankAccount;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        BankAccount bankAccount;

        System.out.print("Enter account ID:");
        int id = sc.nextInt();

        System.out.print("Enter account name:");
        sc.nextLine(); //Para consumir o pulo de linha do nextInt.
        String name = sc.nextLine();

        System.out.print("Do you want to make your first deposit? | (Y/N):");
        char option = sc.next().toLowerCase().charAt(0);

//        double value = 0;
        if (option == 'y') {
            System.out.print("Enter initial deposit value:");
            double firstValue = sc.nextDouble();
            bankAccount = new BankAccount(id, name, firstValue);
        } else {
            bankAccount = new BankAccount(id, name);
        }

        System.out.println();
        System.out.println("Account data:");
        System.out.printf("ID: %d; Name: %s; Amount: %.2f\n\n", id, name, bankAccount.getAmount());

        System.out.print("Enter a deposit value:");
        double depositValue = sc.nextDouble();
        bankAccount.deposit(depositValue);

        System.out.println("Updated account data:");
        System.out.printf("ID: %d; Name: %s; Amount: %.2f\n\n", id, name, bankAccount.getAmount());

        System.out.print("Enter withdraw value:");
        double withDrawValue = sc.nextDouble();
        bankAccount.withdraw(withDrawValue);

        System.out.println("Updated account data:");
        System.out.printf("ID: %d; Name: %s; Amount: %.2f\n\n", id, name, bankAccount.getAmount());

        sc.close();
    }
}
