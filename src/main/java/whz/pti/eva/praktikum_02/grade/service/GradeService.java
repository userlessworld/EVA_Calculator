package whz.pti.eva.praktikum_02.grade.service;

import java.util.List;

import whz.pti.eva.praktikum_02.grade.domain.Grade;

public interface GradeService {
	List<Grade> listAllGrades();
	
	void addGrade(String lecture, String grade);
	
	double calculateAverage();
}
