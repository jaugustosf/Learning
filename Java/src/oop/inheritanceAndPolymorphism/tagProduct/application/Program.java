package oop.inheritanceAndPolymorphism.tagProduct.application;

import oop.inheritanceAndPolymorphism.tagProduct.entities.ImportedProduct;
import oop.inheritanceAndPolymorphism.tagProduct.entities.UsedProduct;
import oop.inheritanceAndPolymorphism.tagProduct.entities.tProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<tProduct> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int numberOfProducts = sc.nextInt();

        for(int i = 1; i <= numberOfProducts; i++){
            System.out.printf("Product #%d data: \n", i);
            System.out.print("Common, used or imported (c/u/i): ");
            char type = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (type == 'c'){
                list.add(new tProduct(name, price));

            }else if (type == 'u'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                list.add(new UsedProduct(name,price,date));
            }else {
                System.out.print("Customs fee: ");
                double customFee = sc.nextDouble();

                list.add(new ImportedProduct(name, price, customFee));
            }
        }
//        list.add(new ImportedProduct("Tablet", 260.0, 20));
//        list.add(new tProduct("Notebook", 1100.0));
//        LocalDate manufactureDate = LocalDate.parse("15/03/2017", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//        list.add(new UsedProduct("Iphone", 400.0, manufactureDate));

        System.out.println();

        for(tProduct product : list){
            product.priceTag();
        }
    }
}
