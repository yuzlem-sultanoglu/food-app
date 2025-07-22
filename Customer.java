package food.app;

public class Customer {
	String customerName;
	double balance;
	public Customer(String customerName, double balance) {
		super();
		this.customerName = customerName;
		this.balance = balance;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void topUpBalance(double amount) {
		 if (amount > 0) {
		        this.balance += amount;
		        System.out.println(amount + "$ added. New balance: " + balance);
		    }
		
	}
}
