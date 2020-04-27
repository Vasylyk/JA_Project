package application.domain;

import java.util.List;

public class Faculty {
	private Integer id;
	private Integer numberOfStudents;
	private FacultyName facultyName;
	private List<Subjects> subjects;
	
	
	public Faculty() {}
	
	public Faculty(Integer numberOfStudents, FacultyName facultyName, List<Subjects> subjects) {
		this.numberOfStudents = numberOfStudents;
		this.facultyName = facultyName;
		this.subjects = subjects;
	}
	
	public Faculty(Integer id, Integer numberOfStudents, FacultyName facultyName, List<Subjects> subjects) {
		this.id = id;
		this.numberOfStudents = numberOfStudents;
		this.facultyName = facultyName;
		this.subjects = subjects;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumberOfStudents() {
		return numberOfStudents;
	}
	public void setNumberOfStudents(Integer numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}
	public FacultyName getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(FacultyName facultyName) {
		this.facultyName = facultyName;
	}
	public List<Subjects> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facultyName == null) ? 0 : facultyName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numberOfStudents == null) ? 0 : numberOfStudents.hashCode());
		result = prime * result + ((subjects == null) ? 0 : subjects.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		if (facultyName != other.facultyName)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numberOfStudents == null) {
			if (other.numberOfStudents != null)
				return false;
		} else if (!numberOfStudents.equals(other.numberOfStudents))
			return false;
		if (subjects == null) {
			if (other.subjects != null)
				return false;
		} else if (!subjects.equals(other.subjects))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Faculty [numberOfStudents=" + numberOfStudents + ", facultyName=" + facultyName + ", subjects="
				+ subjects + "]";
	}
	
	
}
