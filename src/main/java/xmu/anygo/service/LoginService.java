package xmu.anygo.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import xmu.anygo.Utils.MD5Util;
import xmu.anygo.dao.LoginTicketDao;
import xmu.anygo.dao.UserDao;
import xmu.anygo.model.LoginTicket;
import xmu.anygo.model.User;


import java.util.*;

public class LoginService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginTicketDao loginTicketDao;

    /**
     * 用户注册，密码进行MD5加密
     * @param phone
     * @param password
     * @return
     */
    public Map<String,String> register(String phone, String password){
        Map<String,String> map=new HashMap<>();
        Random random=new Random();
        if(StringUtils.isBlank(phone)){
            map.put("msg","手机号不能为空");
            return map;
        }

        if (StringUtils.isBlank(password)){
            map.put("msg","密码不能为空");
            return map;
        }
        User u = userDao.selectByPhone(phone);
        if (u!=null){
            map.put("msg","手机号已经被占用");
            return map;
        }

        User user=new User();
        user.setPhone(phone);
        user.setPassword(MD5Util.getStringMD5(password));
        userDao.insertUser(user);

        String ticket=addLoginTicket(user.getId());
        map.put("ticket",ticket);

        return map;
    }

    /**
     * 用户登录
     * @param phone
     * @param password
     * @return
     */
    public Map<String,String> login(String phone,String password){
        Map<String,String> map = new HashMap<>();
        Random random = new Random();
        if (StringUtils.isBlank(phone)){
            map.put("msg","用户名不能为空");
            return map;
        }

        if (StringUtils.isBlank(password)){
            map.put("msg","密码不能为空");
            return map;
        }

        User u=userDao.selectByPhone(phone);
        if (u==null){
            map.put("msg","用户名不存在");
            return map;
        }

        if(!MD5Util.getStringMD5(password).equals(u.getPassword())){
            map.put("msg","密码错误");
            return map;
        }

        String ticket = addLoginTicket(u.getId());
        map.put("ticket",ticket);
        return map;
    }
    /**
     * 免密码登录,往login_ticket表中插入一条记录用于绑定ticket凭证和用户身份
     * @param userId
     * @return
     */
    public String addLoginTicket(int userId){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime()+1000*3600*30);
        loginTicket.setExpired(date);
        loginTicket.setStatus(0);
        loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-",""));
        loginTicketDao.insertLoginTicket(loginTicket);
        return loginTicket.getTicket();
    }
}
