package whz.pti.eva.praktikum_02.grade.domain;

import javax.persistence.Entity;

@Entity
public class Grade {
	
	private String lecture;
	private String grade;
	
	public Grade(String lecture, String grade) {
		this.lecture = lecture;
		this.grade = grade;
	}
	
	public String getLecture() {
		return lecture;
	}
	
	public String getGrade() {
		return grade;
	}
}
