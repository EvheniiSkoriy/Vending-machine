package vendingmachinesimulator;

import java.util.Random;
/**
 * @author  we can create object Money with parameters and choose type pay
 */
public class Money {

    public static final String EURO = "Euro";
    public static final String USD = "USD";
    public static final String GBP = "GBP";
    private String type;
    private int bills;
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;


    public Money(String type) {
        Random r = new Random();
        this.type = type;
        this.bills = r.nextInt(100);
        this.quarters = r.nextInt(100);
        this.dimes = r.nextInt(100);
        this.nickels = r.nextInt(100);
        this.pennies = r.nextInt(100);
    }


    public Money(String type, int bills, int quarters, int dimes, int nickels, int pennies) {
        this.type = type;
        this.bills = bills;
        this.quarters = quarters;
        this.dimes = dimes;
        this.nickels = nickels;
        this.pennies = pennies;
    }

  
    /**
     * add money to machine
     * @param money its a money that add to machine
     * @return the object Money with the addition of the money 
     */

    public Money addMoney(Money money) {
        this.bills += money.bills;
        this.dimes += money.dimes;
        this.nickels += money.nickels;
        this.pennies += money.pennies;
        this.quarters += money.quarters;
        return this;
    }

    public int getBills() {
        return bills;
    }

    public void setBills(int bills) {
        this.bills = bills;
    }

    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }

    @Override
    public String toString() {
        return type + ":" + type + " = " + bills + " Quarters = " + quarters + " Dimes = " + dimes + " Nickels = " + nickels + " Pennies = " + pennies + "\n";
    }
}
