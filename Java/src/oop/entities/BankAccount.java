package oop.entities;

public class BankAccount {
    private int id;
    private String name;
    private double amount;

    public BankAccount() {
    }

    public BankAccount(int id, String name, double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public BankAccount(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void deposit(double amount){
        this.amount += amount;
    }

    public void withdraw(double amount){
        this.amount -= amount + 5;
    }
}
