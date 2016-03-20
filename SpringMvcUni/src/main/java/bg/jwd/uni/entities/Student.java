package bg.jwd.uni.entities;

public class Student {
	private Long id;
	private String facultyNo;
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFacultyNo() {
		return facultyNo;
	}
	public void setFacultyNo(String facultyNo) {
		this.facultyNo = facultyNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
