package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {

    //需要向dao实现类中注入SqlSessionFactory
    //这里通过构造方法注入
    private SqlSessionFactory sqlSessionFactory;
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory=sqlSessionFactory;
    }

    public User findUserById(int id) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();

        User user=sqlSession.selectOne("test.findUserById",id);

        sqlSession.close();

        return user;
    }

    public List<User> findUserByName(String name) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();

        List<User> user=sqlSession.selectList("test.findUserByName",name);

        sqlSession.close();

        return user;
    }

    public void insertUser(User user) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行插入操作
        sqlSession.insert("test.insertUser", user);

        // 提交事务
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    public void deleteUser(int id) throws Exception {

        SqlSession sqlSession=sqlSessionFactory.openSession();

        sqlSession.delete("test.deleteUser",id);

        sqlSession.commit();
        sqlSession.close();

    }
}
