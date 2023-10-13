package vectors.entities;

public class Person {
    private String name;
    private int yo;
    private double height;

    public Person(String name, int yo, double height) {
        this.name = name;
        this.yo = yo;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getYo() {
        return yo;
    }

    public double getHeight() {
        return height;
    }
}
