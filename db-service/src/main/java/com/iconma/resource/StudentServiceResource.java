package com.iconma.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iconma.constants.StudentServiceRestEndPoints;
import com.iconma.entity.Student;
import com.iconma.repository.StudentRepository;
@RestController
public class StudentServiceResource {
	@Autowired
	private StudentRepository studentRepository;

	@PostMapping(value = {StudentServiceRestEndPoints.SAVE_STUDENT_ENDPOINT})
	public Student saveStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}

	@PutMapping(value = {StudentServiceRestEndPoints.UPDATE_STUDENT_ENDPOINT})
	public Student updateStudent(@RequestBody Student student) {
		Optional<Student> optional = studentRepository.findById(student.getStudentId());
		Student student1 = optional.get();
		student1.setStudentName(student.getStudentName());
		student1.setStudentPhno(student.getStudentPhno());
		student1.setStudentRollNo(student.getStudentRollNo());
		return studentRepository.save(student1);
	}

	@PutMapping(value = {StudentServiceRestEndPoints.DELETE_STUDENT_ENDPOINT })
	public void deleteStudent(@PathVariable("studentId") final int studentId) {
		studentRepository.deleteById(studentId);
	}

	@PutMapping(value = {StudentServiceRestEndPoints.DELETEALL_STUDENTS_ENDPOINT})
	public void deleteAllStudents() {
		studentRepository.deleteAll();
	}

	@GetMapping(value = { StudentServiceRestEndPoints.FINDBYID_STUDENT_ENDPOINT })
	public Student findStudent(@PathVariable("studentId") final int studentId) {
		return studentRepository.findById(studentId).get();
	}

	@GetMapping(value = {StudentServiceRestEndPoints.FINDALL_STUDENTS_ENDPOINT })
	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}
}
