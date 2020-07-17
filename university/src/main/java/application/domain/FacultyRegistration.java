package application.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "faculty_registration")
public class FacultyRegistration {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "faculty_id", referencedColumnName = "id")
	private Faculty faculty;
	
	@Column(name = "first_subject_mark")
	private Integer firstSubjectMark;
	
	@Column(name = "second_subject_mark")
	private Integer secondSubjectMark;
	
	@Column(name = "third_subject_mark")
	private Integer thirdSubjectMark;
	
	@Lob
	private String encodedImage;
	
	@Transient
	private String userEmail;
	
	@Transient
	private Integer facultyId;

	public FacultyRegistration(Integer id, User user, Faculty faculty, Integer firstSubjectMark,
			Integer secondSubjectMark, Integer thirdSubjectMark) {
		super();
		this.id = id;
		this.user = user;
		this.faculty = faculty;
		this.firstSubjectMark = firstSubjectMark;
		this.secondSubjectMark = secondSubjectMark;
		this.thirdSubjectMark = thirdSubjectMark;
	}

	public FacultyRegistration(User user, Faculty faculty, Integer firstSubjectMark, Integer secondSubjectMark,
			Integer thirdSubjectMark) {
		super();
		this.user = user;
		this.faculty = faculty;
		this.firstSubjectMark = firstSubjectMark;
		this.secondSubjectMark = secondSubjectMark;
		this.thirdSubjectMark = thirdSubjectMark;
	}

	public FacultyRegistration() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Integer getFirstSubjectMark() {
		return firstSubjectMark;
	}

	public void setFirstSubjectMark(Integer firstSubjectMark) {
		this.firstSubjectMark = firstSubjectMark;
	}

	public Integer getSecondSubjectMark() {
		return secondSubjectMark;
	}

	public void setSecondSubjectMark(Integer secondSubjectMark) {
		this.secondSubjectMark = secondSubjectMark;
	}

	public Integer getThirdSubjectMark() {
		return thirdSubjectMark;
	}

	public void setThirdSubjectMark(Integer thirdSubjectMark) {
		this.thirdSubjectMark = thirdSubjectMark;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	public String getEncodedImage() {
		return encodedImage;
	}

	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		result = prime * result + ((firstSubjectMark == null) ? 0 : firstSubjectMark.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((secondSubjectMark == null) ? 0 : secondSubjectMark.hashCode());
		result = prime * result + ((thirdSubjectMark == null) ? 0 : thirdSubjectMark.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		FacultyRegistration other = (FacultyRegistration) obj;
		if (faculty == null) {
			if (other.faculty != null)
				return false;
		} else if (!faculty.equals(other.faculty))
			return false;
		if (firstSubjectMark == null) {
			if (other.firstSubjectMark != null)
				return false;
		} else if (!firstSubjectMark.equals(other.firstSubjectMark))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (secondSubjectMark == null) {
			if (other.secondSubjectMark != null)
				return false;
		} else if (!secondSubjectMark.equals(other.secondSubjectMark))
			return false;
		if (thirdSubjectMark == null) {
			if (other.thirdSubjectMark != null)
				return false;
		} else if (!thirdSubjectMark.equals(other.thirdSubjectMark))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FacultyRegistration [id=" + id + ", user=" + user + ", faculty=" + faculty + ", firstSubjectMark="
				+ firstSubjectMark + ", secondSubjectMark=" + secondSubjectMark + ", thirdSubjectMark="
				+ thirdSubjectMark + "]";
	}
	
	
}
