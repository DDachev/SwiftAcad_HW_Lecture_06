package bg.swift.HW06.ex05;

import java.time.LocalDate;

public class Person {

	private String firstName;
	private String lastName;
	private char gender;
	private LocalDate dateOfBirth;
	private short height;
	public SecondaryEducation se;

	public Person(String firstName, String lastName, char gender, LocalDate dateOfBirth, 
			short height, String institutionName, LocalDate enrollmentDate, 
			LocalDate graduationDate, double finalGrade) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.height = height;
		this.se = new SecondaryEducation(institutionName, enrollmentDate, graduationDate, finalGrade);
	}

	public boolean isUnderAge(LocalDate dateOfBirth) {
		LocalDate dateNow = LocalDate.now();
		if (dateNow.minusYears(18).compareTo(dateOfBirth) >= 0) {
			return true;
		}
		return false;
	}
	
	public int getAgeOfPerson() {
		LocalDate dateNow = LocalDate.now();
		int ageOfPerson = dateNow.compareTo(this.dateOfBirth);
		boolean yearIsAfter = this.dateOfBirth.plusYears(dateNow.getYear() - this.dateOfBirth.getYear())
				.isAfter(dateNow);

		if (yearIsAfter) {
			return ageOfPerson - 1;
		}
		return ageOfPerson;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public char getGender() {
		return gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public short getHeight() {
		return height;
	}
}
