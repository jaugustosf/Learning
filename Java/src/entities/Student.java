package entities;

public class Student {
    public String name;
    public double note1;
    public double note2;
    public double note3;

    public double averageGrade(){
        return note1 + note2 + note3;
    }

    public void noteCheck(){
        if(averageGrade() > 60){
            System.out.println("Pass!");
        }else{
            System.out.println("Failed!");
            System.out.printf("MISSING %.2f POINTS%n", noteMissing());
        }
    }

    public double noteMissing(){
        return 60 - averageGrade();
    }
}
