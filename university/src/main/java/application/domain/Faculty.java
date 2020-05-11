package application.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "faculies")
public class Faculty {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column (name = "number_of_students")
	private Integer numberOfStudents;
	
	@Column (name = "faculty_name")
	private FacultyName facultyName;
	
	@Enumerated (EnumType.STRING)
	private Subjects firstSubject;
	
	@Enumerated (EnumType.STRING)
	private Subjects secondSubject;
	
	@Enumerated (EnumType.STRING)
	private Subjects thirdSubject;

	public Faculty() {}

	public Faculty(Integer numberOfStudents, FacultyName facultyName, Subjects firstSubject, Subjects secondSubject,
			Subjects thirdSubject) {
		this.numberOfStudents = numberOfStudents;
		this.facultyName = facultyName;
		this.firstSubject = firstSubject;
		this.secondSubject = secondSubject;
		this.thirdSubject = thirdSubject;
	}

	public Faculty(Integer id, Integer numberOfStudents, FacultyName facultyName, Subjects firstSubject,
			Subjects secondSubject, Subjects thirdSubject) {
		this.id = id;
		this.numberOfStudents = numberOfStudents;
		this.facultyName = facultyName;
		this.firstSubject = firstSubject;
		this.secondSubject = secondSubject;
		this.thirdSubject = thirdSubject;
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

	public Subjects getFirstSubject() {
		return firstSubject;
	}

	public void setFirstSubject(Subjects firstSubject) {
		this.firstSubject = firstSubject;
	}

	public Subjects getSecondSubject() {
		return secondSubject;
	}

	public void setSecondSubject(Subjects secondSubject) {
		this.secondSubject = secondSubject;
	}

	public Subjects getThirdSubject() {
		return thirdSubject;
	}

	public void setThirdSubject(Subjects thirdSubject) {
		this.thirdSubject = thirdSubject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facultyName == null) ? 0 : facultyName.hashCode());
		result = prime * result + ((firstSubject == null) ? 0 : firstSubject.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numberOfStudents == null) ? 0 : numberOfStudents.hashCode());
		result = prime * result + ((secondSubject == null) ? 0 : secondSubject.hashCode());
		result = prime * result + ((thirdSubject == null) ? 0 : thirdSubject.hashCode());
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
		if (firstSubject != other.firstSubject)
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
		if (secondSubject != other.secondSubject)
			return false;
		if (thirdSubject != other.thirdSubject)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Faculty [numberOfStudents=" + numberOfStudents + ", facultyName=" + facultyName + ", firstSubject="
				+ firstSubject + ", secondSubject=" + secondSubject + ", thirdSubject=" + thirdSubject + "]";
	}
	
	
	
	
}
