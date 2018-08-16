package vendingmachinesimulator;

import java.util.Scanner;
/**
 * @author create a menu where we can choose that we want make with vending machine
 */
public class VendingMachineSimulator {

    static Scanner sc = new Scanner(System.in);

 
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        String selection;

        do {
            System.out.println("Enter \n 1:Display the list of commands \n 2:Display the vending machine inventory\n 3:Display the money currently held in the vending machine \n 4:Purchase an item \n 5:Exit");
            selection = sc.nextLine();
            switch (selection) {
                case "1":
                    System.out.println(" Touch 2 for display the vending machine inventory \n Touch 3 for display the money currently held in the vending machine \n Touch 4 for purchase an item \n Touch 5 for exit ");
                    System.out.println("---------------------");
                    break;
                case "2":
                    vm.showAllFood();
                    System.out.println("---------------------");
                    break;
                case "3":
                    System.out.println(vm.getMoney(Money.EURO));
                    System.out.println(vm.getMoney(Money.USD));
                    System.out.println(vm.getMoney(Money.GBP));
                    break;
                case "4":
                    System.out.println("Choose national currencies");
                    System.out.println(" 1:Euro \n 2:USD \n 3:GBP");
                    String currencies = sc.nextLine();
                    while (!currencies.matches("[1-3]")) {
                        System.out.println("Enter correct currencies ");
                        currencies = sc.nextLine();
                    }
                    String type = chooseCurrency(currencies);
                    System.out.println("Choose item");
                    vm.showAllFood();
                    String StringNumberOfElement = sc.nextLine();
                    while (!StringNumberOfElement.matches("^[0-9]+")) {
                        System.out.println("Enter correct number of element ");
                        StringNumberOfElement = sc.nextLine();
                    }
                    int numberOfElement = Integer.parseInt(StringNumberOfElement);
                    if (!vm.containsFood(numberOfElement)) {
                        break;
                    }

                    System.out.println("You can use bills,quarters,dimes,nickels,pennies");
                    System.out.println("Enter number of bills");
                    String StringBills = sc.nextLine();
                    while (!StringBills.matches("^[0-9]+")) {
                        System.out.println("Enter correct number bills ");
                        StringBills = sc.nextLine();
                    }
                    int bills = Integer.parseInt(StringBills);

                    System.out.println("Enter number of quarters");
                    String StringQuarters = sc.nextLine();
                    while (!StringQuarters.matches("^[0-9]+")) {
                        System.out.println("Enter correct number quarters ");
                        StringQuarters = sc.nextLine();
                    }
                    int quarters = Integer.parseInt(StringQuarters);

                    System.out.println("Enter number of dimes");

                    String StringDimes = sc.nextLine();
                    while (!StringDimes.matches("^[0-9]+")) {
                        System.out.println("Enter correct number dimes ");
                        StringDimes = sc.nextLine();
                    }
                    int dimes = Integer.parseInt(StringDimes);

                    System.out.println("Enter number of nickels");
                    String StringNickels = sc.nextLine();
                    while (!StringNickels.matches("^[0-9]+")) {
                        System.out.println("Enter correct number nickels ");
                        StringNickels = sc.nextLine();
                    }
                    int nickels = Integer.parseInt(StringNickels);

                    System.out.println("Enter number of pennies");
                    String StringPennies = sc.nextLine();
                    while (!StringPennies.matches("^[0-9]+")) {
                        System.out.println("Enter correct number pennies ");
                        StringPennies = sc.nextLine();
                    }
                    int pennies = Integer.parseInt(StringPennies);

                    System.out.println(vm.purchaseAnItem(type, numberOfElement - 1, bills, quarters, dimes, nickels, pennies));
                    break;
                case "5":
                    System.exit(0);
                default:
                    break;
            }
        } while (!selection.equals("5"));

    }


    /**
     *choose currency
     * @param currency - its a number that chosen user for choose currency
     * @return choosen currency
     */

    public static String chooseCurrency(String currency) {
        if (currency.equals("1")) {
            return Money.EURO;
        }
        if (currency.equals("2")) {
            return Money.USD;
        }
        return Money.GBP;

    }

}
