package OOP.market.usingConstructors.usingEncapsulamento;

import entities.usingContructors.usingEncapsulamento.Product;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product data:");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Price: ");
        double price = sc.nextDouble();

        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        Product product = new Product(name, price, quantity);
        
        System.out.println();
        System.out.println("Product: "+ product);

        System.out.println();
        System.out.print("Enter the number of product to be added in stock: ");
        int addQuantity = sc.nextInt();
        product.addProducts(addQuantity);

        System.out.println();
        System.out.println("Updated Product: "+ product);

        System.out.println();
        System.out.print("Enter the number of product to be removed in stock: ");
        int remQuantity = sc.nextInt();
        product.removeProducts(remQuantity);

        System.out.println();
        System.out.println("Updated Product: "+ product);

        sc.close();
    }
}
