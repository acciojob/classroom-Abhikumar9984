package com.driver;

import com.driver.Student;
import com.driver.Teacher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    //Useful
    HashMap<String , Student> StudentDb  = new HashMap<>();
    HashMap<String , Teacher> TeacherDb  = new HashMap<>();

    HashMap<String , List<Student>> pairDb  = new HashMap<>();
    public void addStudentToTheDb(Student student){

        StudentDb.put(student.getName(), student);


    }

    public  void addTeacherToTheDb(Teacher teacher){

        TeacherDb.put(teacher.getName() , teacher);


    }

    public List<Student> getAllStudent(){

        return StudentDb.values().stream().toList();
    }

    public List<Teacher> getAllTeacher(){
        return TeacherDb.values().stream().toList();
    }

    public void addPairToPairDb(String StudentName , String TeacherName){

        List<Student> t  = pairDb.get(TeacherName);

        List<Student> temp  = StudentDb.values().stream().toList();
        Student st  = null;
        for(Student student : temp){

            if(student.getName().equals(StudentName)){
                st  = student;
                break;
            }
        }

        t.add(st);


    }

    public List<Student> getStudents(String Name){

        List<Teacher> temp  = getAllTeacher();

        for(Teacher teacher : temp){

            if(teacher.getName().equals(Name)){
                return pairDb.get(Name);
            }
        }

        return new ArrayList<>();
    }


    public void DeletefromRecord(String Name){

        pairDb.remove(Name);
    }

    public void deleteAll(){

        for(String teacher : pairDb.keySet()){
            pairDb.remove(teacher);
        }

    }

}
