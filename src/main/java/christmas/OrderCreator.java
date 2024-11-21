package christmas;

import christmas.Benefit.Benefit;
import christmas.Benefit.BenefitStatus;
import java.util.List;

public class OrderCreator {
    public Orders create(December visitDay, List<OrderRequestDto> orderRequests) {
        return new Orders(orderRequests, visitDay);
    }

    public Benefit applyBenefit(Orders orders, December visitDay) {
        if (orders.getBenefitStatus() == BenefitStatus.NONE) {
            return null;
        }
        return new Benefit(orders, visitDay);
    }
}

