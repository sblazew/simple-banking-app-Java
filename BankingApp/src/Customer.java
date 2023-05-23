import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> trasactionList;

    public Customer(String name, double initialAmount) {
        this.name = name;
        this.trasactionList = new ArrayList<Double>();
        addTransaction(initialAmount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactionList() {
        return trasactionList;
    }

    public void addTransaction (double amount) {
        this.trasactionList.add(amount);
    }
}
