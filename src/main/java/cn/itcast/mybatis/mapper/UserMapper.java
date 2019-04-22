package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

import java.util.List;

/**
 * mapper接口，相当于dao接口，用户管理
 */
public interface UserMapper {

    //用户信息综合查询总数
    public int findUserCount(UserQueryVo userQueryVo) throws Exception;

    //用户综合信息查询
    public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

    //根据id查询用户
    public User findUserById(int id) throws Exception;

    public User findUserByIdResultMap(int id) throws Exception;

    //根据用户名模糊查询用户列表
    public List<User> findUserByName(String name) throws Exception;

    //添加用户信息
    public void insertUser(User user) throws Exception;

    //删除用户信息
    public  void deleteUser(int id) throws Exception;
}
