package bg.jwd.uni.dao;

import java.util.List;

import bg.jwd.uni.entities.Student;

public interface StudentDao {
	public List<Student> getStudents();
	boolean addStudent(Student student);
}
