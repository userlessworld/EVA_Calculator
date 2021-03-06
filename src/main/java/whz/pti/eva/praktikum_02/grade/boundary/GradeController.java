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


@Controller
public class GradeController {
	
	@Autowired
	private GradeService gradeService;
	
	@RequestMapping(value = "/grades", method = RequestMethod.GET)
		public String listAllGrades( Model model) {
			List<Grade> list = gradeService.listAllGrades();
			model.addAttribute("listAllGrades", list);
			double average = gradeService.calculateAverage();
			model.addAttribute("average", average);
			return "grades";
		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addGrade(@RequestParam String lcontent, @RequestParam String gcontent) {
		gradeService.addGrade(lcontent, gcontent);
		return "redirect:grades";
	}
	

}
