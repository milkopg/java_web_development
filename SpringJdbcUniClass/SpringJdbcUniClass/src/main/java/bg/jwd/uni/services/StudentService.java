package bg.jwd.uni.services;

import java.util.List;

import bg.jwd.uni.entities.Student;

public interface StudentService {

	boolean addStudent(Student student);

	List<Student> getStudents();
}
