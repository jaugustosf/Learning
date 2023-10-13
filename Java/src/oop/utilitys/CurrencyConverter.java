package oop.utilitys;

public class CurrencyConverter {
    public static final double IOF = 0.06;
    public static double dolarToReal(double amount, double dolarPrice){
        return amount * dolarPrice * (1 + IOF);
    }
}
