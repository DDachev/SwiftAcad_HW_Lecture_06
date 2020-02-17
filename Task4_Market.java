package bg.swift.HW06;

import java.util.Scanner;

public class Task4_Market {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String personsWithBalance = "";
		String productWithPrice = "";
		String line = "";

		System.out.println("You have to insert name1=balance1;name2=balance2...nameN=balanceN");
		personsWithBalance = sc.nextLine();
		Person[] people = convertToPeople(personsWithBalance);
		if (people == null) {
			System.out.println("Balance can’t be negative.");
			sc.close();
			return;
		}

		System.out.println("You have to insert productname1=price1;productname2=price2...productnameN=priceN");
		productWithPrice = sc.nextLine();
		Product[] products = convertToProduct(productWithPrice);
		if (products == null) {
			System.out.println("Price can’t be negative.");
			sc.close();
			return;
		}

		System.out.println("You have to insert name of person and name of product");

		while (!line.equals("END")) {
			line = sc.nextLine();
			if (line.equals("END")) {
				break;
			}
			int lastSpaceIndex = line.lastIndexOf(' ');
			String personName = line.substring(0, lastSpaceIndex);
			String productName = line.substring(lastSpaceIndex + 1);

			for (int i = 0; i < people.length; i++) {
				if (people[i].getName() != null && people[i].getName().equals(personName)) {
					for (int j = 0; j < products.length; j++) {
						if (products[j].getName() != null && products[j].getName().equals(productName)) {
							people[i].buyProduct(products[i]);
							break;
						}
					}
				}
			}
		}

		sc.close();

		for (int i = 0; i < people.length; i++) {
			System.out.println(people[i].getPrintStr());
		}

	}

	public static Product[] convertToProduct(String input) {
		String[] products = input.split("[=;]");
		Product[] result;
		if (products.length % 2 == 0) {
			result = new Product[products.length / 2];
		} else {
			result = new Product[products.length / 2 + 1];
		}

		for (int i = 0; i < result.length; i++) {
			String name = products[i * 2];
			double price = Double.parseDouble(products[(i * 2) + 1]);

			if (!Product.isValidPrice(price)) {
				return null;
			}
			result[i] = Product.addNewProduct(name, price);
		}
		return result;
	}

	public static Person[] convertToPeople(String input) {
		String[] people = input.split("[=;]");
		Person[] result;
		if (people.length % 2 == 0) {
			result = new Person[people.length / 2];
		} else {
			result = new Person[people.length / 2 + 1];
		}

		for (int i = 0; i < result.length; i++) {
			String name = people[i * 2];
			double balance = Double.parseDouble(people[(i * 2) + 1]);

			if (!Person.isValidBalance(balance)) {
				return null;
			}
			result[i] = Person.addNewPerson(name, balance);
		}
		return result;
	}

}
