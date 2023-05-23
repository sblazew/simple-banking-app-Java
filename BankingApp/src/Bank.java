import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customerList;

    public Bank(String name) {
        this.name = name;
        this.customerList =  new ArrayList<Customer>();
        }


    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public boolean newCustomer(String customerName, double initialAmount){
        if(findCustomer(customerName)==null){
            this.customerList.add(new Customer(customerName, initialAmount));
            return true;
        }
    return false;
    }

    private Customer findCustomer(String customerName){
        for (int i=0; i<this.customerList.size(); i++){
            Customer checkingCustomer = this.customerList.get(i);
            if(checkingCustomer.getName().equals(customerName)) {
                return checkingCustomer;
            }
        }
        return null;
    }

    public boolean addCustomerTransaction(String name, double amount){
        Customer ifCustomerExists = findCustomer(name);
        if (ifCustomerExists != null) {
            ifCustomerExists.addTransaction(amount);
            return true;
        }
        return false;
    }

    public boolean customersList (boolean showTransactions) {

        ArrayList<Customer> bankCustomers = getCustomerList();
        for(int i=0; i<bankCustomers.size(); i++) {
            Customer bankCustomer = bankCustomers.get(i);
            System.out.println("customer: " + bankCustomer.getName()+"[" + (i+1) +"]");
            if(showTransactions){
                System.out.println("Transactions");
                ArrayList<Double> transactions = bankCustomer.getTransactionList();
                for(int j= 0; j<transactions.size(); j++) {
                    System.out.println("["+(j+1)+"] amount " + transactions.get(j));
                }
            }
        }
        return true;
    }

}
