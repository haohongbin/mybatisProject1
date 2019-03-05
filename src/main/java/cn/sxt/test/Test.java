package cn.sxt.test;

import cn.sxt.dao.UserDao;
import cn.sxt.entity.User;


import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        UserDao userDao=new UserDao();
//        //查询所有数据
//        List<User> list=userDao.getAll();
//        //增强for循环
//        for(User user:list){
//            System.out.println(user);
//        }
//        //普通for循环
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i));
//
//        }
//        //迭代器遍历
//        Iterator<User> iter=list.iterator();
//        while (iter.hasNext()){
//            System.out.println(iter.next());
//        }

//        查询一条数据
//        System.out.println(userDao.getById(1001));

        //分页查询
        List<User> list=userDao.getAll3(1,2);
        for(User u:list){
            System.out.println(u);
        }

        //增加
//        User user=new User();
//        user.setName("郝宏斌");
//        user.setAge("18");
//        System.out.println(userDao.add(user));

        //更新
//        User user=userDao.getById(1007);
//        user.setAge("10");
//        System.out.println(userDao.update(user));

        //删除
//        User user=userDao.getById(1007);
//        int id=user.getId();
//        System.out.println(userDao.delete(id));
    }
}
