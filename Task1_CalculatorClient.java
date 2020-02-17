package bg.swift.HW06;

import java.util.Scanner;

public class Task1_CalculatorClient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = "";
		String[] commandAndNumbers;
		System.out.println(
				"You have to insert the command and after that two numbers: the commands are SUM, SUB, MUL, DIV, PER");
		while (!line.equals("END")) {
			line = sc.nextLine();
			commandAndNumbers = line.split(" ");
			if (commandAndNumbers[0].equals("SUM")) {
				System.out.printf("%.3f", Calculator.sum(Double.parseDouble(commandAndNumbers[1]),
						Double.parseDouble(commandAndNumbers[2])));
				System.out.println();
				continue;
			}
			if (commandAndNumbers[0].equals("SUB")) {
				System.out.printf("%.3f", Calculator.substract(Double.parseDouble(commandAndNumbers[1]),
						Double.parseDouble(commandAndNumbers[2])));
				System.out.println();
				continue;
			}

			if (commandAndNumbers[0].equals("MUL")) {
				System.out.printf("%.3f", Calculator.multiply(Double.parseDouble(commandAndNumbers[1]),
						Double.parseDouble(commandAndNumbers[2])));
				System.out.println();
				continue;
			}

			if (commandAndNumbers[0].equals("DIV")) {
				System.out.printf("%.3f", Calculator.divide(Double.parseDouble(commandAndNumbers[1]),
						Double.parseDouble(commandAndNumbers[2])));
				System.out.println();
				continue;
			}

			if (commandAndNumbers[0].equals("PER")) {
				System.out.printf("%.3f", Calculator.percentage(Double.parseDouble(commandAndNumbers[1]),
						Double.parseDouble(commandAndNumbers[2])));
				System.out.println();
				continue;
			}
		}
		sc.close();
	}
}
