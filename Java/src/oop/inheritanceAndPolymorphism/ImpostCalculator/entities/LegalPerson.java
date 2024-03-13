package oop.inheritanceAndPolymorphism.ImpostCalculator.entities;

public class LegalPerson extends Person {
    private int employeesNumb;

    public LegalPerson(String name, double anualIncome, int employeesNumb) {
        super(name, anualIncome);
        this.employeesNumb = employeesNumb;
    }

    public int getEmployeesNumb() {
        return employeesNumb;
    }

    public void setEmployeesNumb(int employeesNumb) {
        this.employeesNumb = employeesNumb;
    }

    @Override
    public Double taxCalc() {
        if(getEmployeesNumb() > 10){

            return getAnualIncome() * 0.14;
        }

        return getAnualIncome() * 0.16;
    }
}
