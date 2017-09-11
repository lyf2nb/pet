package pet.controller.plat.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hama on 2017/9/11.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);


    @RequestMapping("/list")
    public String index() {
        return "/plat/employee/employeeList";
    }



}
