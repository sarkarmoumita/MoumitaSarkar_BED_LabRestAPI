package com.greatlearning.studentManagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.studentManagement.entity.Student;
import com.greatlearning.studentManagement.service.StudentService;




@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;


// ResponseBody into restAPI ->  that will be use 
	// add mapping for "/list"

@RequestMapping("/list")
public String listStudents(Model theModel) {
		// get Students from db
		List<Student> theStudents = studentService.findAll();
		// add to the spring model
		theModel.addAttribute("Students", theStudents);
		return "list-Students";
	}
@RequestMapping("/showFormForAdd")
public String showFormForAdd(Model theModel) {
	// create model attribute to bind form data
		Student theStudent = new Student();
		theModel.addAttribute("Student", theStudent);
		return "Student-form";
	}
@RequestMapping("/showFormForUpdate")
public String showFormForUpdate(
		@RequestParam("studentId") int theId,
		Model theModel) {
		// get the Book from the service
		Student theStudent = studentService.findById(theId);
		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("Student", theStudent);
		// send over to our form
		return "Student-form";			
	}
@PostMapping("/save")
public String saveStudent(
		    @RequestParam("id") int id,
			@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname,
			@RequestParam("course") String course, 
			@RequestParam("country") String country) {

		System.out.println(id);
		Student theStudent;
		if (id != 0) {
			theStudent = studentService.findById(id);
			theStudent.setFirstname(firstname);
			theStudent.setLastname(lastname);
			theStudent.setCourse(course);
			theStudent.setCountry(country);
		} else
			theStudent = new Student(firstname,lastname, course, country);
		// save the student
		studentService.save(theStudent);
		System.out.println("student saved");
		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";
}
@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		// delete the Student
		studentService.deleteById(theId);
		// redirect to /Books/list
		return "redirect:/students/list";
	}
@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}
		model.setViewName("403");
		return model;
	}
}


















