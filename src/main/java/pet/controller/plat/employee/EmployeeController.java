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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

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

    @ResponseBody
    @RequestMapping(value = "/notifications", method = RequestMethod.POST)
    public Object notifications(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
        logger.info("notifications+notifications+notifications");
        for(int i=1;i<6; i++){
            logger.info(i+"");
            Thread.sleep(1000);
        }
        Map<String, Object> result = new HashMap();
        result.put("success", true);
        result.put("data", "notify success");
        logger.info(result.toString());
        return result;
    }

}
