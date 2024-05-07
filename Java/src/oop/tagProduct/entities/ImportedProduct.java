package oop.tagProduct.entities;

public class ImportedProduct extends tProduct {
    double customsFee;

    public ImportedProduct(String name, Double price, double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(double customsFee) {
        this.customsFee = customsFee;
    }

    @Override
    public void priceTag(){
        System.out.printf("%s - R$ %.2f (Customs Fee - R$ %.2f\n",getName(),totalPrice(),customsFee);
    }

    public double totalPrice(){
        return price += customsFee;
    }
}