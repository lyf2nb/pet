package pet.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pet.dao.IStudentDao;
import pet.model.Student;
import pet.model.StudentExample;
import pet.model.StudentExample.Criteria;


/**
 * 
 * @author YUAN
 *  这个是测试用的,以后就删了,可以参考一下看看
 */
@Controller
public class StudentController {
    private Logger logger = Logger.getLogger(StudentController.class);
    
    @Resource
    private IStudentDao studentDao;
 
    /*
     *  http://localhost:8080/getUserInfo
     */
 
    @RequestMapping("/getStudentInfo")
    @ResponseBody
    public Student getUserInfo() {
       /* List<Student> findStudenInfo = studentService.findStudenInfo();
        if(findStudenInfo!= null){
            System.out.println(findStudenInfo);
            logger.info("user.getAge():"+findStudenInfo);
        }
        return findStudenInfo.get(0);*/
        
        StudentExample exa = new StudentExample();
        Criteria criteria = exa.createCriteria();
        criteria.andNameEqualTo("Megan");
        List<Student> list = studentDao.selectByExample(exa);
        System.out.println(list);
        System.out.println(list);
        return list.get(0);
    }
}
