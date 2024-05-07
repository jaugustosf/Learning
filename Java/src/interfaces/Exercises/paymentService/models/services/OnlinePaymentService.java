package interfaces.Exercises.paymentService.models.services;

public interface OnlinePaymentService {
    double interest(double amount, Integer parcels);
    double paymentFee(double amount);
}