package com.cubic.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")

@NamedQueries({ @NamedQuery(name = "StudentEntity.GetAll", query = "select s from StudentEntity s"),
		@NamedQuery(name = "StudentEntity.search", query = "select s from StudentEntity s where UPPER(s.studentName) like UPPER(?)"),
		@NamedQuery(name = "StudentEntity.cols", query = "select s.studentName from StudentEntity s"),
		@NamedQuery(name = "StudentEntity.findById", query = "select s from StudentEntity s where s.pk=?") })
public class StudentEntity {

	@Id
	@Column(name = "STUDENT_ID")
	@SequenceGenerator(name = "studentSeq", sequenceName = "PERSON_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "studentSeq")
	private Long pk;

	@Column(name = "STUDENT_NAME")
	private String studentName;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	private Set<CourseEntity> courses = new HashSet<CourseEntity>();

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Set<CourseEntity> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseEntity> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "StudentEntity [pk=" + pk + ", studentName=" + studentName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
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
		StudentEntity other = (StudentEntity) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		return true;
	}
}