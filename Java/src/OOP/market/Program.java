package OOP.market;

import entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Product product = new Product();

        System.out.println("Enter product data:");

        System.out.print("Name: ");
        product.name = sc.nextLine();

        System.out.print("Price: ");
        product.price = sc.nextDouble();

        System.out.print("Quantity: ");
        product.quantity = sc.nextInt();

        System.out.println();
        System.out.println("Product: "+ product);
        //System.out.println(product.toString());

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
