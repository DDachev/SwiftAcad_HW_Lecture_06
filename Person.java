package bg.swift.HW06;

public class Person {
	private Product[] products = new Product[500];
	private int countOfProducts = 0;
	
	private String name;
	private double balance;


	private Person(String name, double balance) {
			this.name = name;
			this.balance = balance;
	}
	
	public static Person addNewPerson(String name, double balance) {
		if (isValidAll(name, balance)) {
			Person pr = new Person(name, balance);
			return pr;
		}
		return null;
	}

	private static boolean isValidAll(String name, double balance) {
		if (isValidName(name) && isValidBalance(balance)) {
			return true;
		}
		return false;
	}
	
	private static boolean isValidName(String name) {
		if(name != null && !name.trim().isEmpty()){
			return true;
		}
		System.out.println("Name can’t be empty.");
		return false;
	}
	
	public static boolean isValidBalance(double balance) {
		if (balance > 0) {
			return true;
		}
		
		return false;
	}
	
	public void buyProduct(Product product) {
		if(balance >= product.getPrice()) {
			products[countOfProducts++] = product;
			balance -= product.getPrice();
			System.out.println(name + " bought " + product.getName());
			return;
		}
		System.out.println(name + " can't afford " + product.getName());
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getPrintStr() {
		if (countOfProducts == 0) {
			return name + " - Nothing bought";
		}
		
		String productBought = "";
		for(int i = 0; i < countOfProducts; i++) {
			productBought += products[i].getName();
			if (i < countOfProducts - 1) {
				 productBought += ", ";
			}
		}
		return name + " - " + productBought;
	}

}
