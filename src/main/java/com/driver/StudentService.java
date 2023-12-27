package com.driver;

import com.driver.Student;
import com.driver.StudentRepository;
import com.driver.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repoObj;



    public Student getStudent(String name){
        List<Student> st  = repoObj.getAllStudent();
        Student ans  = null;
        for(Student student : st) {

            if (student.getName().equals(name)){
                ans = student;
                break;
            }
        }

       return ans;
    }

    public Teacher getTeacher(String name){
        List<Teacher> tc  = repoObj.getAllTeacher();
        Teacher ans  = null;
        for(Teacher teacher : tc) {

            if (teacher.getName().equals(name)){
                ans = teacher;
                break;
            }
        }


        return ans;
    }

    public List<String> getNameOfAllStudents(String Name){
        List<Student> temp   = repoObj.getStudents(Name);
        List<String> pans  = new ArrayList<>();
        for(Student st : temp){
            pans.add(st.getName());
        }

        return pans;
    }

    public List<String> getAllStudent(){
        List<Student> temp  =  repoObj.getAllStudent();
        List<String> pans  = new ArrayList<>();

        for(Student student : temp){
            pans.add(student.getName());
        }

        return pans;
    }

}
