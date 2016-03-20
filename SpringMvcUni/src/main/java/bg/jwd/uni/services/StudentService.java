package bg.jwd.uni.services;

import java.util.List;

import bg.jwd.uni.entities.Student;

public interface StudentService {
	public boolean addStudent(Student student);
	public List<Student> getStudent();
}
