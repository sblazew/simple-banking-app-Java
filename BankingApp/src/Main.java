import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank("National Bank of Poland");
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        menu();

        while(!quit){
            int menuOption = scanner.nextInt();
            scanner.nextLine();
            switch (menuOption){
                case 1:
                    menu();
                    break;
                case 2:
                    System.out.println("Enter customer name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter initial amount: ");
                    double initialAmount = scanner.nextDouble();

                    bank.newCustomer(name, initialAmount);
                    System.out.println("Customer: " + name + " added, inital amount: " + initialAmount +
                            "\nChoose option");
                    break;
                case 3:
                    System.out.println("Enter customer name: ");
                    String nameFind = scanner.nextLine();

                 //   if(bank.f)
                    System.out.println("Enter added amount: ");
                    double amountToAdd = scanner.nextDouble();
                    bank.addCustomerTransaction(nameFind, amountToAdd);
                    System.out.println("Amount: " + amountToAdd + " added to customer: " + nameFind+
                            "\nChoose option");
                    break;
                case 4:
                    bank.customersList(true);
                    System.out.println("choose option");
                    break;
                case 5:
                    quit = true;
                    break;
            }
        }
       }
    private static void menu() {
        System.out.println("Available options: \n" +
                "1 - menu options,\n" +
                "2 - add new consumer and initial amount,\n" +
                "3 - add transaction,\n" +
                "4 - show customers list,\n" +
                "5 - exit.\n"+
                "Choose option");
    }
}
