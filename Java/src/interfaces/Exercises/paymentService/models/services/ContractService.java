package interfaces.Exercises.paymentService.models.services;

import interfaces.Exercises.paymentService.models.entities.Contract;
import interfaces.Exercises.paymentService.models.entities.Installment;

import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int parcels) {
        double parcelValue = contract.getTotalValue()/parcels;

        for(int i = 1; i <= parcels; i++){
            LocalDate dueDate = contract.getDate().plusMonths(i);

            double interest = onlinePaymentService.interest(parcelValue, i);
            double fee = onlinePaymentService.paymentFee(parcelValue + interest);
            double totalParcelValue = parcelValue + interest + fee;

            contract.getInstallments().add(new Installment(dueDate, totalParcelValue));
        }
    }
}