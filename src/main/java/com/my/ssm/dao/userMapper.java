package com.my.ssm.dao;

import com.my.ssm.bean.user;
import com.my.ssm.bean.userExample;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userMapper {
    long countByExample(userExample example);

    int deleteByExample(userExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(user record);

    int insertSelective(user record);

    List<user> selectByExample(userExample example);

    user selectByPrimaryKey(Integer id);

    //根据用户名查找是否有对应数据
    user selectByUserName(String userName);

    //批量删除
    void BatchDeleteUser(Integer[] ids);

    //查找用户名是否唯一
    List<user> selectByUsers(String name);

    //模糊查询
    List<user> selectByLike(String queryText);

    //添加角色关系表
    void insert_user_role(HashMap<String, Object> map);

    //删除角色关系表
    void delete_user_role(HashMap<String, Object> map);

    //查询用户对应权限
    List<Integer> getRoleidsByUserid(Integer id);

    int updateByExampleSelective(@Param("record") user record, @Param("example") userExample example);

    int updateByExample(@Param("record") user record, @Param("example") userExample example);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);

}