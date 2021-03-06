package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;

import java.util.List;

/**
 * dao接口，用户管理
 */
public interface UserDao {

    //根据id查询用户
    public User findUserById(int id) throws Exception;

    //根据用户名模糊查询用户列表
    public List<User> findUserByName(String name) throws Exception;

    //添加用户信息
    public void insertUser(User user) throws Exception;

    //删除用户信息
    public  void deleteUser(int id) throws Exception;
}
