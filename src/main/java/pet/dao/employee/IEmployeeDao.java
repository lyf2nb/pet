package pet.dao.employee;

import org.springframework.stereotype.Component;
import pet.model.employee.Employee;

@Component
public interface IEmployeeDao {
    int deleteByPrimaryKey(String id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}