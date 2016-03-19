package bg.jwd.uni.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import bg.jwd.uni.entities.Student;

@Repository
public class StudentDaoImpl implements StudentDao{
	
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USERNAME = "softuni";
	public static final String PASSWORD = "softuni";

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		try (
			Connection connection = DriverManager.getConnection(URL, USERNAME	, PASSWORD);
			Statement stmp = connection.createStatement()) {
			
			String sql = "SELECT * FROM student";
			ResultSet result = stmp.executeQuery(sql);
			
			while (result.next()) {
				Student student = new Student();
				student.setId(result.getLong("id"));
				student.setFacultyNo(result.getString("faculty_no"));
				student.setName(result.getString("name"));
				
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return students;
	}

	@Override
	public boolean addStudent(Student student) {
		String sql = "INSERT INTO STUDENT (id, faculty_no, name) VALUES (?,?,?)";
		
		try (
				
				Connection connection = DriverManager.getConnection(URL, USERNAME	, PASSWORD);
				PreparedStatement stmp = connection.prepareStatement(sql)) {
				
				stmp.setLong(1, 2);
				stmp.setString(2, student.getFacultyNo());
				stmp.setString(3, student.getName());
				
				stmp.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		return true;
	}

}
