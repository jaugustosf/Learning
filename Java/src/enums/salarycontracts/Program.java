package enums.salarycontracts;

import enums.salarycontracts.entities.Department;
import enums.salarycontracts.entities.HourContract;
import enums.salarycontracts.entities.Worker;
import enums.salarycontracts.entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String workerDepartment = sc.nextLine();

        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.println("Digite em level uma das opções: JUNIOR, MID_LEVEL, SENIOR;");
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        double workerBaseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Department(workerDepartment));

        System.out.print("How many contracts to this worker? ");
        int counter = sc.nextInt();

        for(int i = 1; i <= counter; i++){
            System.out.printf("Enter contract #%d data: ", i);
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            sc.nextLine();
            System.out.print("Value per hour: ");
            Double contractValuePerHour = sc.nextDouble();
            System.out.print("Duration (Hours): ");
            int contractHours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, contractValuePerHour, contractHours);
            worker.addContract(contract);
            System.out.println();
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}
