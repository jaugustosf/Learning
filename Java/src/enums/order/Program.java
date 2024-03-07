package enums.order;

import enums.order.entities.OrderStatus;
import enums.order.entities.enums.Order;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Order order = new Order(1080, new Date(), OrderStatus.Shipped);

        System.out.println(order);

        OrderStatus os1 = OrderStatus.Shipped;
        //Para converter para string.
        OrderStatus os2 = OrderStatus.valueOf("Shipped");

        System.out.println(os1);
        System.out.println(os2);
    }
}
