package whz.pti.eva.praktikum_02.grade.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import whz.pti.eva.praktikum_02.grade.domain.Grade;
import whz.pti.eva.praktikum_02.grade.service.GradeService;
import whz.pti.eva.praktikum_02.grade.service.GradeServiceImpl;

@Controller
public class GradeController {
	
	
	private GradeService gradeService;
	
	@RequestMapping("/grades")
		public String listAllGrades( Model model) {
			List<Grade> list = gradeService.listAllGrades();
			model.addAttribute("listAllGrades", list);
		
			return "grades";
		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addGrade(@RequestParam String lecture, @RequestParam String grade,
			@RequestParam String lcontent, Model model) {
		model.addAttribute("lecture", lecture);
		model.addAttribute("currentLecture", lecture);
		List<Grade> list = gradeService.listAllGrades();
		model.addAttribute("listAllGrades", list);
		gradeService.addGrade(lecture, grade);
		return "redirect:grades?lecture=" + lecture + "&grade=" + grade;
	}
	
}
