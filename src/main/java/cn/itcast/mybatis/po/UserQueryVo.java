package cn.itcast.mybatis.po;

import lombok.Data;

import java.util.List;

/**
 * 用户包装类型
 */
@Data
public class UserQueryVo {

    //在这里包装所需要的查询条件

    //用户查询条件
    private UserCustom userCustom;

    //可以包装其它的查询条件，订单、商品

    //传入多个id
    private List<Integer> ids;

}
