package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestUserMapper {

    private SqlSessionFactory sqlSessionFactory;

    @BeforeTest
    public void setUp() throws Exception{
        //mybatis配置文件
        String resource="SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream= Resources.getResourceAsStream(resource);
        //创建会话工厂
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        //调用UserMapper的方法
        User user=userMapper.findUserById(28);

        System.out.println(user);
    }

    @Test
    public void testFindUserByName() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        //调用UserMapper的方法
        List<User> list=userMapper.findUserByName("小明");

        sqlSession.close();

        System.out.println(list);

    }

    @Test
    public void testFindUserList() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        //创建包装对象，设置查询条件
        UserQueryVo userQueryVo=new UserQueryVo();
        UserCustom userCustom=new UserCustom();
        //由于这里使用动态sql，如果不设置某个值，条件不会拼接在sql中
//        userCustom.setSex("1");
//        userCustom.setUsername("张三丰");
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(1);
        ids.add(10);
        ids.add(16);
        userQueryVo.setIds(ids);
        userQueryVo.setUserCustom(userCustom);

        //调用UserMapper的方法
        List<UserCustom> list=userMapper.findUserList(userQueryVo);

        sqlSession.close();

        System.out.println(list);

    }

    @Test
    public void testFindUserCount() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        //创建包装对象，设置查询条件
        UserQueryVo userQueryVo=new UserQueryVo();
        UserCustom userCustom=new UserCustom();
        userCustom.setSex("1");
        userCustom.setUsername("张三丰");
        userQueryVo.setUserCustom(userCustom);

        //调用UserMapper的方法
        int sum=userMapper.findUserCount(userQueryVo);

        sqlSession.close();

        System.out.println(sum);

    }

    @Test
    public void testFindUserByIdResultMap() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        //调用UserMapper的方法
        User user=userMapper.findUserByIdResultMap(28);

        System.out.println(user);
    }
}
