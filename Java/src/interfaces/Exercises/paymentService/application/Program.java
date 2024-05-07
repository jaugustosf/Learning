package interfaces.Exercises.paymentService.application;

import interfaces.Exercises.paymentService.models.entities.Contract;
import interfaces.Exercises.paymentService.models.entities.Installment;
import interfaces.Exercises.paymentService.models.services.ContractService;
import interfaces.Exercises.paymentService.models.services.PaypalService;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Entre os dados do contrato: ");
        System.out.print("Numero: ");
        int numb = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), dtf);
        System.out.print("Valor do contrato: ");
        double contractValue = sc.nextDouble();

        Contract contract = new Contract(numb, date, contractValue);

        System.out.print("Entre com o numero de parcelas: ");
        int parcel = sc.nextInt();

        ContractService service = new ContractService(new PaypalService());

        service.processContract(contract, parcel);

        for (Installment x : contract.getInstallments()) {
            System.out.println(x);
        }

        sc.close();
    }
}
