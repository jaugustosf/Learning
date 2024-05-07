package interfaces.Exercises.paymentService.models.services;


public class PaypalService implements OnlinePaymentService{

    private static final double PAYMENT_FEE = 0.02;
    private static final double MONTHLY_INTEREST = 0.01;

    @Override
    public double interest(double amount, Integer parcels){
        return amount * MONTHLY_INTEREST * parcels;
    }

    @Override
    public double paymentFee(double amount){
        return amount * PAYMENT_FEE;
    }
}
