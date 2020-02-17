package bg.swift.HW06;

import java.util.Scanner;

public class Task3_BankManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = "";
		String[] command;
		System.out.printf("You have to insert one of the command:%n1. OPEN <username> <password> <name> <govId>;%n"
				+ "2. CLOSE <username> <password>;%n" + "3. DEPOSIT <username> <amount>;%n"
				+ "4. WITHDRAW <username> <password> <amount>;%n"
				+ "5. TRANSFER <username> <password> <amount> <recipient>.%n");
		while (!line.equals("END")) {
			line = sc.nextLine();
			command = line.split(" ");

			if (command[0].equals("OPEN")) {
				Bank.openAccount(command[3], command[4], command[1], command[2]);
				continue;
			}

			if (command[0].equals("CLOSE")) {
				Bank.closeAccount(command[1], command[2]);
				continue;
			}

			if (command[0].equals("DEPOSIT")) {
				Bank.deposit(command[1], Double.parseDouble(command[2]));
				continue;
			}

			if (command[0].equals("WITHDRAW")) {
				Bank.withdraw(command[1], command[2], Double.parseDouble(command[3]));
				continue;
			}

			if (command[0].equals("TRANSFER")) {
				Bank.transfer(command[1], command[2], Double.parseDouble(command[3]), command[4]);
				continue;
			}
		}
		sc.close();

		System.out.println(Bank.getAssets());

		Bank.printInfoAccounts();
	}
}
