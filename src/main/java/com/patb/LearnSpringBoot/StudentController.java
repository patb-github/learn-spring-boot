package com.patb.LearnSpringBoot;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patb.LearnSpringBoot.model.Student;
import com.patb.LearnSpringBoot.model.StudentRepository;



@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/student/save")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/student/findByEmail")
    public Student findStudent(@RequestParam("email") String email) {
        return studentRepository.findByEmail(email);
    }
    
    @PatchMapping("/student/update")
    public Student updateEmail(@RequestParam("student_id") String id, @RequestParam("new_email") String email) {
        Optional<Student> studentToUpdateOption = studentRepository.findById(id);
        if (studentToUpdateOption.isPresent()) {
            Student studentToUpdate = studentToUpdateOption.get();
            studentToUpdate.setEmail(email);
            return studentRepository.save(studentToUpdate);
        }
        return null;
    }

    @GetMapping("/student/findByEmailDomain")
    public List<Student> findStudentByDomain(@RequestParam("domain") String domain) {
        return studentRepository.findByDomain(domain);
    }
}
