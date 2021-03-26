package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Email Already taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        Boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("id doesn't exist");
        }
        studentRepository.deleteById(id);
    }
    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()->new IllegalStateException("Student doesn't exist")
        );
        if(name !=null && name.length()>0) student.setName(name);

        if(email !=null && email.length()>0) student.setEmail(email);

    }
}
