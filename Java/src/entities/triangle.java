package entities;

public class triangle {
    public double a,b,c;

    public double area(){
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public void see(){
       System.out.printf("Triangle X area: %.4f%n", area());
    }

    public static void maior(double areaX, double areaY){
        if (areaX > areaY) {
            System.out.println("Larger area: X");
        }else if(areaX < areaY){
            System.out.println("Larger area: Y");
        }else{
            System.out.println("As areas são iguais");
        }
    }
}
