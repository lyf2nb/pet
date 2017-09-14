package pet.controller.plat.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pet.model.employee.Employee;
import pet.service.employee.IEmployeeService;

import javax.annotation.Resource;

/**
 * Created by hama on 2017/9/11.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);


    @Autowired
    private IEmployeeService iEmployeeService;


    @RequestMapping("/list")
    public String index() {
        return "/plat/employee/employeeList";
    }


    @ResponseBody
    @RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET)
    public Object getEmployee(@PathVariable("id") String id) {
        logger.info("id:[{}]", id);
        Employee employee = iEmployeeService.selectByPrimaryKey(id);
        return employee;
    }

}
