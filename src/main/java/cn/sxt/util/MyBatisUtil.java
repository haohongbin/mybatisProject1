package cn.sxt.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    /**
     * 通过配置文件 创建SqlSessionFactory 是一个SqlSession的工厂类
     * @return
     * @throws IOException
     */
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    /**
     *SqlSession 通过id找到对应的sql语句，执行sql语句
     * @return
     * @throws IOException
     */
    public static SqlSession getSession() throws IOException {
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        return sqlSessionFactory.openSession();
    }
}
