package bg.swift.HW06;

public class Product {
	private String name;
	private double price;

	private Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public static Product addNewProduct(String name, double price) {
		if (isValidAll(name, price)) {
			Product pr = new Product(name, price);
			return pr;
		}
		return null;
	}

	private static boolean isValidAll(String name, double price) {
		if (isValidName(name) && isValidPrice(price)) {
			return true;
		}
		return false;
	}
	
	private static boolean isValidName(String name) {
		if(name != null && !name.trim().isEmpty()) {
			return true;
		}
		System.out.println("Name can’t be empty.");
		return false;
	}
	
	public static boolean isValidPrice(double price) {
		if(price > 0) {
			return true;
		}
		return false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPrice() {
		return this.price;
	}

}
