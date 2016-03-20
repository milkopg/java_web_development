package bg.jwd.uni.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import bg.jwd.uni.entities.Student;

@Service("newImpl")
public class StudentServiceImpl2 implements StudentService {

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Student> getStudent() {
		List<Student> students = new ArrayList<>();
		Student student = new Student();
		student.setFacultyNo("faculty no new impl");
		student.setName("name new impl");

		students.add(student);
		return students;
	}

}
