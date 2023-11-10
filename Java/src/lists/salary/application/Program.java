package lists.salary.application;

import lists.salary.entities.Employee;
import lists.salary.entities.Filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("How many employees will be registered? " );
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.println();
            System.out.printf("Employee #%d: \n",i);

            System.out.print("Id: ");
            int id = sc.nextInt();
            while(Filter.hasId(list, id)) {
                System.out.print("Id already taken. Try again: ");
                id = sc.nextInt();
            }
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            list.add(new Employee(id,name,salary));
        }

        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int searchId = sc.nextInt();

        Employee emp = list.stream().filter(x -> x.getId() == searchId).findFirst().orElse(null);
        
        if(emp == null){
            System.out.println("This id does not exist!");
        }else{
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }

        for(Employee x : list){
            System.out.println(x);
        }
    }
}
