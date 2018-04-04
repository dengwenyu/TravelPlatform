package xmu.anygo.dao;

import org.apache.ibatis.annotations.*;
import xmu.anygo.model.LoginTicket;

@Mapper
public interface LoginTicketDao {
    String TABLE_NAEM = " loginTicket ";
    String INSERT_FIELDS = " User_Id, Ticket, Expired, Status ";
    String SELECT_FIELDS = " ID, " + INSERT_FIELDS;

    @Insert({"insert into",TABLE_NAEM,"(",INSERT_FIELDS,") values (#{userId},#{ticket},#{expired},#{status})"})
    void insertLoginTicket(LoginTicket loginTicket);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAEM,"where ID=#{id}"})
    LoginTicket seletById(int id);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAEM,"where Ticket=#{ticket}"})
    LoginTicket seletByTicket(String ticket);

    @Update({"update",TABLE_NAEM,"set Status = #{status} where Ticket = #{ticket}"})
    void updateStatus(@Param("ticket") String ticket, @Param("status") int status);

    @Delete({"delete from",TABLE_NAEM,"where ID=#{id}"})
    void deleteById(int id);
}
