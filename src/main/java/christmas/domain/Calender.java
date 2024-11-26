package christmas.domain;


import java.util.HashMap;
import java.util.Map;

public class Calender {

    private Map<Integer,String> calender = new HashMap<>();
    private String[] week = {"금","토","일","월","화","수","목"};

    public Calender() {
        for (int i = 1; i <= 31; i++) {
            int day = i % 7 - 1;
            if (day == -1) {
                day = 6;
            }
            calender.put(i,week[day]);
        }
    }

    public Map<Integer,String> getCalender() {
        return calender;
    }


}



