package cn.sxt.test;

import cn.sxt.entity.User;
import cn.sxt.interfac.UserDao;
import cn.sxt.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class Test2 {
    public static void main(String[] args) throws IOException {
        SqlSession session= MyBatisUtil.getSession();
        UserDao userDao=session.getMapper(UserDao.class);
        List<User> list=userDao.getList();
        for(User u:list){
            System.out.println(u);
        }
    }
}
/*
user






/api/users



/api/chat_room_info

coach









 */