package vendingmachinesimulator;
/**
 * @author  we can create object food with parameters
 */
public class Food {

    private String name;
    private double priceUSD;
    private double priceEuro;
    private double priceGBP;
    private int quantity;

    public Food(String name, double priceUSD, double priceEuro, double priceGBP, int quantity) {
        this.name = name;
        this.priceUSD = priceUSD;
        this.priceEuro = priceEuro;
        this.priceGBP = priceGBP;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(double priceUSD) {
        this.priceUSD = priceUSD;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceEuro() {
        return priceEuro;
    }

    public void setPriceEuro(double priceEuro) {
        this.priceEuro = priceEuro;
    }

    public double getPriceGBP() {
        return priceGBP;
    }

    public void setPriceGBP(double priceGBP) {
        this.priceGBP = priceGBP;
    }

    /**
     *
     * @param type its a currency that user choosen
     * @return  a price element with choosen currency
     */

    public double getPrice(String type) {
        if (type.equals(Money.EURO)) {
            return priceEuro;
        }
        if (type.equals(Money.GBP)) {
            return priceGBP;
        }
        return priceUSD;
    }

    @Override
    public String toString() {
        return name + " USD " + priceUSD + " Euro " + priceEuro + " GBP " + priceGBP + " Quantity " + quantity;
    }

}
