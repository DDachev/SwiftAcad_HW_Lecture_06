package bg.swift.HW06.ex05;

import java.time.LocalDate;
import java.util.Scanner;

public class Task5_PersonCharacteristics {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert the number of people:");
		int numberOfPeople = sc.nextInt();
		System.out.println("Insert the charachteristics of the person: first name; last name; gender; \r\n"
				+ " height; date of birth; name of institution; enrollment date; graduation date; (final grade if the person is graduated).");

		String[] personInput = new String[numberOfPeople];
		String[] personOutput = new String[numberOfPeople];
		Person[] people = new Person[numberOfPeople];

		// Fix scanner next line.
		sc.nextLine();

//		Read next line from console
		for (int i = 0; i < numberOfPeople; i++) {
			personInput[i] = sc.nextLine();
		}

		sc.close();

//      Create people from type Person and fill up the array of type Person
		for (int i = 0; i < numberOfPeople; i++) {
			String personInfo[] = personInput[i].split("[;]");
			String[] dateOfBirth = personInfo[4].split("[.]");
			LocalDate birth = LocalDate.of(Integer.parseInt(dateOfBirth[2]), Integer.parseInt(dateOfBirth[1]),
					Integer.parseInt(dateOfBirth[0]));
			String[] enrollmentDate = personInfo[6].split("[.]");
			LocalDate enrollment = LocalDate.of(Integer.parseInt(enrollmentDate[2]),
					Integer.parseInt(enrollmentDate[1]), Integer.parseInt(enrollmentDate[0]));
			String[] graduationDate = personInfo[7].split("[.]");
			LocalDate graduation = LocalDate.of(Integer.parseInt(graduationDate[2]),
					Integer.parseInt(graduationDate[1]), Integer.parseInt(graduationDate[0]));

			if (personInfo.length == 8) {
				people[i] = new Person(personInfo[0], personInfo[1], personInfo[2].charAt(0), birth,
						Short.parseShort(personInfo[3]), personInfo[5], enrollment, graduation, 0);
			} else {
				people[i] = new Person(personInfo[0], personInfo[1], personInfo[2].charAt(0), birth,
						Short.parseShort(personInfo[3]), personInfo[5], enrollment, graduation,
						Double.parseDouble(personInfo[8]));
			}
		}

//		Create strings with information for the people from the array
		for (int i = 0; i < numberOfPeople; i++) {
			String maleInfoOutput = String.format(
					"%s %s is %d years old. He was born in %d. He started %s on " + people[i].se.getEnrollmentDate()
							+ " and",
					people[i].getFirstName(), people[i].getLastName(), people[i].getAgeOfPerson(),
					people[i].getDateOfBirth().getYear(), people[i].se.getInstitutionName());

			String femaleInfoOutput = String.format(
					"%s %s is %d years old. She was born in %d. She started %s on " + people[i].se.getEnrollmentDate()
							+ " and",
					people[i].getFirstName(), people[i].getLastName(), people[i].getAgeOfPerson(),
					people[i].getDateOfBirth().getYear(), people[i].se.getInstitutionName());

			if (people[i].getGender() == 'M') {
				if (!people[i].isUnderAge(people[i].getDateOfBirth())) {
					personOutput[i] = maleInfoOutput + " is supposed to graduate on " + people[i].se.getGraduationDate()
							+ "." + people[i].getFirstName() + " " + people[i].getLastName() + " is under-aged.";
					continue;
				}
				if (people[i].se.getFinalGrade() == -1) {
					personOutput[i] = maleInfoOutput + " is supposed to graduate on " + people[i].se.getGraduationDate()
							+ ".";
					continue;
				}
				String info = String.format("%s finished on " + people[i].se.getGraduationDate() + 
						" with a grade of %.3f", maleInfoOutput, people[i].se.getFinalGrade());
				personOutput[i] = info;
				continue;
			}

			if (people[i].getGender() == 'F') {
				if (!people[i].isUnderAge(people[i].getDateOfBirth())) {
					personOutput[i] = femaleInfoOutput + " is supposed to graduate on "
							+ people[i].se.getGraduationDate() + "." + people[i].getFirstName() + " "
							+ people[i].getLastName() + " is under-aged.";
					continue;
				}
				if (people[i].se.getFinalGrade() == -1) {
					personOutput[i] = femaleInfoOutput + " is supposed to graduate on "
							+ people[i].se.getGraduationDate() + ".";
					continue;
				}
				String info = String.format("%s finished on " + people[i].se.getGraduationDate() + 
						" with a grade of %.3f", femaleInfoOutput, people[i].se.getFinalGrade());
				personOutput[i] = info;
			}
		}

//		Print the information for the people from the array
		for (int i = 0; i < personOutput.length; i++) {
			System.out.println(personOutput[i]);
		}
	}
}

