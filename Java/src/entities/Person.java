package entities;

public class Person {
    public String name;
    public double grossSalary;
    public double tax;

    public double netSalary(){
        return grossSalary - tax;
    }

    public void increaseSalary(double percentage){
        grossSalary += (grossSalary * percentage) / 100;
    }

    public String toString(){
        return String.format("%s, R$%.2f", name, netSalary());
    }
}
