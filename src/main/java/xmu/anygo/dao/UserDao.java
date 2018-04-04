package xmu.anygo.dao;

import org.apache.ibatis.annotations.*;
import xmu.anygo.model.User;

@Mapper
public interface UserDao {
    String TABLE_NAME="user";
    String INSERT_FIELDS="Name,ID_Number,Phone,Visitor,Account,Password,Professional_Guide," +
            "Location,Credit_Score,Service_Score,Salary_UpperBound,Salary_LowerBound,Information";
    String SELECT_FIELDS="ID,"+INSERT_FIELDS;

    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,") values(#{name},#{idNumber},#{phone},#{visitor},#{account},#{password},#{professionalGuide})" +
            "#{location},#{creditScore},#{serviceScore},#{salaryUpperBound},#{salaryLowerBound},#{information}"})
    public void insertUser(User user);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where ID=#{id}"})
    public User selectById(int id);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where Phone=#{phone}"})
    public User selectByPhone(String phone);

    @Delete({"delete from",TABLE_NAME,"where ID=#{id}"})
    public void deleteById(int id);
}
