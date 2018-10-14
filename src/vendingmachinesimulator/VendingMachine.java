package vendingmachinesimulator;

/**
 * @author create a vinding machine and her functionality
 */
public class VendingMachine {

    private List<Food> listFood = FileReader.readFile("listFood.txt");
    private List<Money> listMoney = new List();

    public VendingMachine() {
        listMoney.add(new Money(Money.EURO));
        listMoney.add(new Money(Money.USD));
        listMoney.add(new Money(Money.GBP));
    }

    /**
     * find in listMoney currency that equals type
     *
     * @param type - its a currency that user choosen
     * @return object money that have it type
     */
    public Money getMoney(String type) {
        Money result = null;
        for (int i = 0; i < listMoney.size(); i++) {
            if (type.equals(listMoney.get(i).getType())) {
                result = listMoney.get(i);
            }
        }
        return result;
    }

    /**
     * user buy a choosen element
     *
     * @param type - its a currency that user choosen
     * @param numberOfElement - element that user choosen
     * @param bills,quarters,dimes,nickels,pennies - money
     * @return cash machine condition
     */
    public List<Money> purchaseAnItem(String type, int numberOfElement, int bills, int quarters, int dimes, int nickels, int pennies) {
        int money = bills * 100 + quarters * 25 + dimes * 10 + nickels * 5 + pennies;
        if (money / 100.0 >= listFood.get(numberOfElement).getPrice(type)) {
            Money paidMoney = new Money(type, bills, quarters, dimes, nickels, pennies);
            addMoney(type, paidMoney);
            if (listFood.get(numberOfElement).getQuantity() > 1) {
                listFood.get(numberOfElement).setQuantity(listFood.get(numberOfElement).getQuantity() - 1);
            } else {
                listFood.remove(numberOfElement);
            }
            calculateChange(listFood.get(numberOfElement).getPriceEuro(), money, getMoney(type));
        }

        return listMoney;
    }

    /**
     * show all food that machine have
     */
    public void showAllFood() {
        for (int i = 0; i < listFood.size(); i++) {
            System.out.println((i + 1) + ":" + listFood.get(i));
        }
    }

    /**
     * add to machine maney that pay user
     *
     * @param type - its a currency that user choosen
     * @param paidMoney - its a money that user pay
     */
    private void addMoney(String type, Money paidMoney) {
        Money currentMoneyInVendingMachine = getMoney(type);
        currentMoneyInVendingMachine.addMoney(paidMoney);
    }

    /**
     * check list has a choosen element
     *
     * @param numberOfElement - element that user choosen
     * @return true element that user choosen is in list, in other cases false
     *
     */
    public boolean containsFood(int numberOfElement) {
        boolean find = true;
        if (numberOfElement > listFood.size() || numberOfElement == 0) {
            find = false;
        }
        return find;
    }

    /* 
    *@param price - price of choosen element
    *@param moneyInt - money that user pay
    *@param m - money of vending machine
     * calculate a change that vinding machine must pay a user
     */
    private void calculateChange(double price, int moneyInt, Money m) {
        moneyInt -= price * 100;
        while (m.getBills() != 0 && moneyInt >= 100) {
            moneyInt = moneyInt - 100;
            m.setBills(m.getBills() - 1);
        }
        while (m.getQuarters() != 0 && moneyInt >= 25) {
            moneyInt = moneyInt - 25;
            m.setQuarters(m.getQuarters() - 1);
        }
        while (m.getDimes() != 0 && moneyInt >= 10) {
            moneyInt = moneyInt - 10;
            m.setDimes(m.getDimes() - 1);
        }
        while (m.getNickels() != 0 && moneyInt >= 5) {
            moneyInt = moneyInt - 5;
            m.setNickels(m.getNickels() - 1);
        }
        while (m.getPennies() != 0 && moneyInt > 0) {
            moneyInt = moneyInt - 1;
            m.setPennies(m.getPennies() - 1);
        }
    }
}
