package pet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.ApiOperation;

import pet.model.Student;


/**
 * 这个是restful接口的一个东西,先放着吧
 * @author YUAN
 *
 */
@RestController
@RequestMapping(value="/student")
public class SwaggerController {
    /*
     *  http://localhost:8080/swagger/index.html
     */
 
    @ApiOperation(value="Get all Students",notes="requires noting")
    @RequestMapping(method=RequestMethod.GET)
    public List<Student> getStudents(){
        List<Student> list=new ArrayList<Student>();
 
        Student Student=new Student();
        Student.setName("hello");
        list.add(Student);
 
        Student Student2=new Student();
        Student.setName("world");
        list.add(Student2);
        return list;
    }
 
    @ApiOperation(value="Get Student with id",notes="requires the id of Student")
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public Student getStudentById(@PathVariable String name){
        Student Student=new Student();
        Student.setName("hello world");
        return Student;
    }
}
