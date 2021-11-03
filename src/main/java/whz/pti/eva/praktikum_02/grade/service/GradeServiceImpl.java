package whz.pti.eva.praktikum_02.grade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import whz.pti.eva.praktikum_02.grade.domain.Grade;
import whz.pti.eva.praktikum_02.grade.domain.GradeRepository;

@Service
public class GradeServiceImpl implements GradeService{
	
	
	private GradeRepository graderepro;
	
	@Autowired
	public GradeServiceImpl(GradeRepository graderepro) {
		this.graderepro = graderepro;
	}
	
	
	@Override
	public List<Grade> listAllGrades() { 
		return graderepro.findAll();
	}

	@Override
	public void addGrade(String lecture, String grade) {
		Grade g = new Grade(lecture, grade);
		graderepro.save(g);		
	}

	@Override
	public double calculateAverage() {
		List<Grade> grades = listAllGrades();
		return grades.stream().mapToDouble(g -> Double.valueOf(g.getGrade())).sum()/grades.size();
	}

}



