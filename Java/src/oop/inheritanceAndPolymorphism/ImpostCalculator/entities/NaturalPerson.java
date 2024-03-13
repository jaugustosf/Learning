package oop.inheritanceAndPolymorphism.ImpostCalculator.entities;

public class NaturalPerson extends Person{
    private double healthExpenditures;

    public NaturalPerson(String name, double anualIncome, double gastoSaude) {
        super(name, anualIncome);
        healthExpenditures = gastoSaude;
    }

    public double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double taxCalc() {
        if (getAnualIncome() < 20000.0) {
            return getAnualIncome() * 0.15 - healthExpenditures * 0.5;
        }
        else {
            return getAnualIncome() * 0.25 - healthExpenditures * 0.5;
        }
    }
}
