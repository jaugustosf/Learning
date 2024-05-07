package oop.tagProduct.entities;

public class tProduct {
    String name;
    Double price;

    public tProduct() {
    }

    public tProduct(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void priceTag(){
        System.out.printf("%s - R$ %.2f\n",name,price);
    }
}