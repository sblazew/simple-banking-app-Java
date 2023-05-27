import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("National Bank of Poland");
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        menu();

        while(!quit) {

            int menuOption = menuOptionCheck();
            while (menuOption != 0) {

                switch (menuOption) {
                    case 1:
                        menu();
                        break;
                    case 2:
                        System.out.println("Enter customer name: ");
                        String name = scanner.nextLine();
                        double userInput1;
                        System.out.println("Enter initial amount: ");
                        while (true) {
                            try {
                                userInput1 = Double.parseDouble(scanner.next());
                                scanner.nextLine();
                                break;
                            } catch (NumberFormatException ignore) {
                                System.out.println("Invalid input, enter initial amount:");
                            }
                        }
                        bank.newCustomer(name, userInput1);
                        System.out.println("Customer: " + name + " added, initial amount: " + userInput1 +
                                "\nChoose option");
                        break;
                    case 3:
                        System.out.println("Enter customer name: ");
                        String nameFind = scanner.nextLine();
                        double userInput2;
                        System.out.println("Enter amount to add: ");

                        while (true) {
                            try {
                                userInput2 = Double.parseDouble(scanner.next());
                                scanner.nextLine();
                                break;
                            } catch (NumberFormatException ignore) {
                                System.out.println("Invalid input, enter amount:");
                            }
                        }
                        bank.addCustomerTransaction(nameFind, userInput2);
                        break;
                    case 4:
                        bank.customersList(true);
                        System.out.println("choose option");
                        break;
                    case 5:
                        quit = true;
                        break;
                }
                break;
            }
        }
        scanner.close();
        }

    private static void menu() {
        System.out.println("Available options: \n" +
                "1 - menu options,\n" +
                "2 - add new consumer and initial amount,\n" +
                "3 - add transaction to existing customer,\n" +
                "4 - show customers list,\n" +
                "5 - exit.\n"+
                "Choose option");
    }
    //input data validation
   private static int menuOptionCheck() {

        int digitToCheck;
        System.out.println("Pick one of menu options: ");
        Scanner scanner = new Scanner(System.in);

        try {
            digitToCheck = scanner.nextInt();

            if(digitToCheck > 0 && digitToCheck < 6){
                return digitToCheck;
            } else {
                System.out.println("Wrong input. Must be a number from 1 to 5");
                return 0;
            }
        } catch (InputMismatchException e) {
            // System.out.println(e.getMessage());
            System.out.println("Wrong input. Must be a number from 1 to 5");
            return 0;
        }
    }
}
