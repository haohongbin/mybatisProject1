package cn.sxt.interfac;

import cn.sxt.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    @Select("select * from student")
    public List<User> getList();
}
