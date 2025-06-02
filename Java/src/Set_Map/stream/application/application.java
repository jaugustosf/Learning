package Set_Map.stream.application;

import Set_Map.stream.entities.employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        String PATH = "C:/Dev/Projects/Learning/Java/src/Set_Map/stream/test.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            List<employee> employeerList = new ArrayList<>();

            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                employeerList.add(new employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.print("Salary: ");
            double salaryEnter = sc.nextDouble();

            List<String> emails = employeerList.stream()
                    .filter(p -> p.getSalary() > salaryEnter)
                    .map(x -> x.getEmail())
                    .sorted()
                    .collect(Collectors.toList());

            emails.forEach(System.out::println);

            double sumOfSalary = employeerList.stream()
                    .filter(p -> p.getName().charAt(0) == 'M')
                    .map(p -> p.getSalary())
                    .reduce(0.0, (x, y) -> x + y);


            System.out.print("Sum salary of people whose name starts with 'M': " + sumOfSalary);

        } catch (IOException error) {
            System.out.println("Error: " + error.getMessage());
        } catch (EmptyStackException error) {
            System.out.println("Error: File is empty");
        }
    }
}
