package bg.swift.HW06;

import java.util.Scanner;

public class Task2_CredentialsManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = "";
		String[] command;
		System.out.println("You have to insert the command and after that username and password (and new password)");
		while (!line.equals("END")) {
			line = sc.nextLine();
			command = line.split(" ");

			if (command[0].equals("ENROLL")) {
				Credentials.addNewUser(command[1], command[2]);
				if (Credentials.addNewUser(command[1], command[2]) != null) {
					System.out.println("ENROLL success");
				} else {
					System.out.println("ENROLL fail");
				}
				continue;
			}
			
			if (command[0].equals("CHPASS")) {
				if (Credentials.passwordChange(command[1], command[2], command[3])) {
					System.out.println("CHPASS success");
				} else {
					System.out.println("CHPASS fail");
				}
				continue;
			}

			if (command[0].equals("AUTH")) {
				if (Credentials.authentication(command[1], command[2])) {
					System.out.println("AUTH success");
				} else {
					System.out.println("AUTH fail");
				}
				continue;
			}
		}
		sc.close();
	}
}
