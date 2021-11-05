package whz.pti.eva.praktikum_02.grade.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Grade {
	
	@Id	@GeneratedValue
	private Integer id;
	
	private String lecture;
	private String grade;
	
	
	public Grade() {
		
	}
	
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
