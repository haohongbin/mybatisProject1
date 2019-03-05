package cn.sxt.dao;

import cn.sxt.entity.User;
import cn.sxt.util.MyBatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
//    查询所有
    public List<User> getAll() throws IOException {
        SqlSession session= MyBatisUtil.getSession();
        List<User> user=session.selectList("userMapper.selectAll");
        session.close();
        return user;
    }
    //分页查询-通过RowBounds来实现分页，Mapper文件不用做任何改变
    //RowBounds rowBounds=new RowBounds(index,size);index是下标，size是数据
    public List<User> getAll3(int currentPage,int pageSize) throws IOException {
        SqlSession session= MyBatisUtil.getSession();
        RowBounds rowBounds=new RowBounds((currentPage-1)*pageSize,pageSize);
        List<User> user=session.selectList("userMapper.selectAll",null,rowBounds);
        session.close();
        return user;
    }

    //分页查询，采用Map结构来解决问题，Mapper文件需要改变
    public List<User> getAll2(int currentPage,int pageSize) throws IOException {
        SqlSession session= MyBatisUtil.getSession();
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        List<User> user=session.selectList("userMapper.selectAll2",map);
        session.close();
        return user;
    }


    public User getById(int id) throws IOException {
        SqlSession session= MyBatisUtil.getSession();
        User user=session.selectOne("userMapper.selectUser",id);
        session.close();
        return user;
    }

    public int add(User user) throws IOException {
        SqlSession session= MyBatisUtil.getSession();
        int result=session.insert("userMapper.addUser",user);
        session.commit();
        session.close();
        return result;
    }

    public int update(User user) throws IOException {
        SqlSession session= MyBatisUtil.getSession();
        int result=session.update("userMapper.updateUser",user);
        session.commit();
        session.close();
        return result;
    }

    public int delete(int id) throws IOException {
        SqlSession session= MyBatisUtil.getSession();
        int result=session.delete("userMapper.deleteUser",id);
        session.commit();
        session.close();
        return result;
    }
}
