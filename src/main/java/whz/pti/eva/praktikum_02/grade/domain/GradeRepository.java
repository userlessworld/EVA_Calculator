package whz.pti.eva.praktikum_02.grade.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, String> {
	Optional<Grade> findByGrade(String lecture,String grade);
}
