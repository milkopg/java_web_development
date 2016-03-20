package bg.jwd.uni.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.constants.UrlConstants;
import bg.jwd.uni.entities.Student;
import bg.jwd.uni.services.StudentService;
import bg.jwd.uni.utils.UserUtils;

@Controller
public class StudentController {

	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	// @Secured("ROLE_USER")
	@RequestMapping(value = UrlConstants.STUDENT_REGISTER_URL, method = RequestMethod.GET)
	public String getStudents(Model model) {
		model.addAttribute("students", studentService.getStudent());
		model.addAttribute("addStudentUrl", UrlConstants.ADD_STUDENT_URL);
		model.addAttribute("user", UserUtils.getUser());

		return "studentRegister";
	}

	@RequestMapping(value = UrlConstants.ADD_STUDENT_URL, method = RequestMethod.GET)
	public String addStudent() {
		return "addStudent";
	}

	@RequestMapping(value = UrlConstants.ADD_STUDENT_SAVE_URL, method = RequestMethod.POST)
	public String addStudentSave(Model model, @ModelAttribute(value = "student") Student student) {

		studentService.addStudent(student);

		model.addAttribute("students", studentService.getStudent());

		return "studentRegister";
	}
}