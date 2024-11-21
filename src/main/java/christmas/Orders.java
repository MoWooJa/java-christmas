package christmas;

import christmas.Benefit.BenefitStatus;
import java.util.List;

public class Orders {
    private final List<OrderRequestDto> orderRequests;

    private final int totalPrice;

    private final December visitDay;

    private final BenefitStatus benefitStatus;

    // 평일인지 주말인지

    public Orders(List<OrderRequestDto> orderRequestDtos, December visitDay) {
        this.orderRequests = orderRequestDtos;
        this.visitDay = visitDay;
        this.totalPrice = totalPrice();
        this.benefitStatus = isBenefit(totalPrice, orderRequestDtos);
    }

    public BenefitStatus isBenefit(int totalPrice, List<OrderRequestDto> orderRequests) {
        if (totalPrice > 10000) {
            return BenefitStatus.ACTIVE;
        }
        return BenefitStatus.NONE;
    }

    public int totalPrice() {
        int totalPrice = 0;
        for (OrderRequestDto orderRequest : orderRequests) {
            totalPrice += orderRequest.menu().getPrice();
        }
        return totalPrice;
    }

    public List<OrderRequestDto> getOrderRequests() {
        return orderRequests;
    }

    public BenefitStatus getBenefitStatus() {
        return benefitStatus;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public December getVisitDay() {
        return visitDay;
    }
}
