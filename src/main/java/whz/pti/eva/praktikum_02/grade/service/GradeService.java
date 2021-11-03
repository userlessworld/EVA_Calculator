package whz.pti.eva.praktikum_02.grade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import whz.pti.eva.praktikum_02.grade.domain.Grade;

@Service
public interface GradeService {
	List<Grade> listAllGrades();
	
	void addGrade(String lecture, String grade);
	
	double calculateAverage();
}
