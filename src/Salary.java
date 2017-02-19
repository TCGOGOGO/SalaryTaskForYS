/**
 * Created by tcgogogo on 17/2/19.
 */
public class Salary {

    private int money;
    private String date;

    public Salary(int money, String date) {
        this.money = money;
        this.date = date;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
