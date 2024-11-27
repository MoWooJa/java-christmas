package christmas.domain;

import java.util.List;
import java.util.Map;

public class Planner {

    private List<String> orderList;
    private int totalPrice = 0;
    private String giftMenu;
    private int christmasSale = 0;
    private String weekSale;
    private int weekSalePrice = 0;
    private int specialSale = 0;
    private int giftEvent = 0;
    private int totalSalePrice = 0;
    private String badge = "없음";
    private int afterSaleTotalPrice = 0;

    public Planner(List<String> orderList,int totalPrice, String gift, int christmatSale, String[]weekAndPrice, int totalStarSalePrice) {
        this.orderList = orderList;
        this.totalPrice = totalPrice;
        if (gift != null) {
            this.giftMenu = gift;
            this.giftEvent = 25000;
        }
        this.christmasSale = christmatSale;
        weekSale = weekAndPrice[0];
        weekSalePrice = Integer.parseInt(weekAndPrice[1]);
        this.specialSale = totalStarSalePrice;
        totalSalePrice = giftEvent + christmatSale + weekSalePrice + specialSale;
        if (totalSalePrice > 5000) {
            badge = "별";
        }
        if (totalSalePrice > 10000) {
            badge = "트리";
        }
        if (totalSalePrice > 20000) {
            badge = "산타";
        }
        if (totalPrice < 10000) {
            this.afterSaleTotalPrice = totalPrice;
        }
        if (totalPrice >= 10000) {
            this.afterSaleTotalPrice = (totalPrice - totalSalePrice) + giftEvent;
        }
    }

    public int getAfterSaleTotalPrice() {
        return afterSaleTotalPrice;
    }

    public List<String> getOrderList() {
        return orderList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getGiftMenu() {
        return giftMenu;
    }

    public int getChristmasSale() {
        return christmasSale;
    }

    public String getWeekSale() {
        return weekSale;
    }

    public int getWeekSalePrice() {
        return weekSalePrice;
    }

    public int getSpecialSale() {
        return specialSale;
    }

    public int getGiftEvent() {
        return giftEvent;
    }

    public int getTotalSalePrice() {
        return totalSalePrice;
    }

    public String getBadge() {
        return badge;
    }
}
