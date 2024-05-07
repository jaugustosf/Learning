package oop.tagProduct.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends tProduct{
    LocalDate manufactureDate;

    public UsedProduct(String name, Double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public void priceTag() {
        System.out.printf("%s - (Used) R$ %.2f - Manufacture date - %s\n",getName(),getPrice(), manufactureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}