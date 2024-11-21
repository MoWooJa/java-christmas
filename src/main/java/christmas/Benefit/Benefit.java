package christmas.Benefit;


import christmas.December;
import christmas.Orders;

public class Benefit {

    private final XmasBenefit xmasBenefit;

    private final WeekDayBenefit weekDayBenefit;

    private final WeekendBenefit weekendBenefit;

    private final FreeBenefit freeBenefit;

    private final SpecialBenefit specialBenefit;

    public Benefit(Orders orders, December december) {
        this.xmasBenefit = xmasBenefit(december);
        this.weekDayBenefit = weekDayBenefit(orders, december);
        this.weekendBenefit = weekendBenefit(orders, december);
        this.freeBenefit = freeBenefit(orders);
        this.specialBenefit = specialBenefit(december);
    }

    public XmasBenefit xmasBenefit(December december) {
        return new XmasBenefit(december);
    }

    public WeekendBenefit weekendBenefit(Orders orders, December december) {
        return new WeekendBenefit(orders, december);
    }

    public WeekDayBenefit weekDayBenefit(Orders orders, December december) {
        return new WeekDayBenefit(orders, december);
    }

    public FreeBenefit freeBenefit(Orders orders) {
        return new FreeBenefit(orders.totalPrice());
    }

    public SpecialBenefit specialBenefit(December visitDay) {
        return new SpecialBenefit(visitDay);
    }

    public XmasBenefit getXmasBenefit() {
        return xmasBenefit;
    }

    public WeekDayBenefit getWeekDayBenefit() {
        return weekDayBenefit;
    }

    public WeekendBenefit getWeekendBenefit() {
        return weekendBenefit;
    }

    public FreeBenefit getFreeBenefit() {
        return freeBenefit;
    }

    public SpecialBenefit getSpecialBenefit() {
        return specialBenefit;
    }
}
