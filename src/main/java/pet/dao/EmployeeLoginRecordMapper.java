package pet.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pet.model.EmployeeLoginRecord;
import pet.model.EmployeeLoginRecordExample;

public interface EmployeeLoginRecordMapper {
    int countByExample(EmployeeLoginRecordExample example);

    int deleteByExample(EmployeeLoginRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(EmployeeLoginRecord record);

    int insertSelective(EmployeeLoginRecord record);

    List<EmployeeLoginRecord> selectByExample(EmployeeLoginRecordExample example);

    EmployeeLoginRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EmployeeLoginRecord record, @Param("example") EmployeeLoginRecordExample example);

    int updateByExample(@Param("record") EmployeeLoginRecord record, @Param("example") EmployeeLoginRecordExample example);

    int updateByPrimaryKeySelective(EmployeeLoginRecord record);

    int updateByPrimaryKey(EmployeeLoginRecord record);
}