package pet.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import pet.dao.employee.IEmployeeDao;
import pet.model.employee.Employee;

import javax.annotation.Resource;

/**
 * Created by hama on 2017/9/14.
 */
@Service
public class IEmployeeService {

    @Autowired
    private IEmployeeDao iEmployeeDao;

    public Employee selectByPrimaryKey(String id){
        Employee employee = iEmployeeDao.selectByPrimaryKey(id);
        return employee;
    }

}
