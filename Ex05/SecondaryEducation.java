package bg.swift.HW06.ex05;

import java.time.LocalDate;

public class SecondaryEducation {
	private double finalGrade;
	private boolean graduated;
	private LocalDate enrollmentDate;
	private LocalDate graduationDate;
	private String institutionName;

	public SecondaryEducation(String institutionName, LocalDate enrollmentDate, 
			LocalDate graduationDate, double finalGrade) {
		this.institutionName = institutionName;
		this.enrollmentDate = enrollmentDate;
		this.graduationDate = graduationDate;
		this.finalGrade = finalGrade;
		if (this.finalGrade != 0) {
			this.graduated = true;
		}
	}

	public void setGraduatedAndFinalGrade(LocalDate enrollmentDate, LocalDate graduationDate, double finalGrade) {
		LocalDate dateNow = LocalDate.now();
		if (dateNow.compareTo(graduationDate) >= 0) {
			this.graduated = true;
			this.finalGrade = finalGrade;
		}
	}

	public double getFinalGrade() {
		if (this.finalGrade != 0) {
			return finalGrade;
		}
		return -1;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public LocalDate getGraduationDate() {
		return graduationDate;
	}

	public String getInstitutionName() {
		return institutionName;
	}

}
