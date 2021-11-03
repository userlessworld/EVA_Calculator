package whz.pti.eva.praktikum_02.grade.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {
	Optional<Grade> findByGrade(String grade);
}
