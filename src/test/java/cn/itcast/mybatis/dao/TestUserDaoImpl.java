package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.InputStream;

public class TestUserDaoImpl {

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

        UserDaoImpl userDaoImpl=new UserDaoImpl(sqlSessionFactory);

        User user=userDaoImpl.findUserById(28);

        System.out.println(user);
    }
}
