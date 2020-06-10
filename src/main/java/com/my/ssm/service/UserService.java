package com.my.ssm.service;

import com.my.ssm.bean.user;
import com.my.ssm.bean.userExample;
import com.my.ssm.dao.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private userMapper userMapper;

    public void BatchDeleteUser(Integer[] ids){
        userMapper.BatchDeleteUser(ids);
    }
    /**
     * 删除用户
     * @param id
     */
   public void DeleteUser(Integer id){
       userMapper.deleteByPrimaryKey(id);
   }

    /**
     * 用于判断更新当前用户的名称是否唯一
     * @return
     */
    public List<user> getUsers(String name){
        List<user> list = userMapper.selectByUsers(name);
        return list;
    }
    /**
     * 更新用户
     * @param user
     */
    public void updateUser(user user){
        userMapper.updateByPrimaryKeySelective(user);
    }
    /**
     * 主键查询，用于更新，删除
     * @param id
     * @return
     */
    public user getUser(Integer id){
        user user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    /**
     * 添加用户
     * @param user
     */
    public void addUser(user user){
        userMapper.insert(user);
    }
    /**
     * 用户模糊查询或全部数据的显示也可用于判断注册姓名唯一性
     * @param queryText
     * @return
     */
    public List<user> getByLike(String queryText){
        List<user> list = userMapper.selectByLike(queryText);
        return list;
    }

    /**
     * Shiro 判断是否有这个用户
     * @param userName
     * @return
     */
    public user selectByUserName(String userName){
        user user = userMapper.selectByUserName(userName);
        return user;
    }
    /**
     * 用户登录
     * @param Condition
     * @return
     */
    public boolean getBycondition(user Condition){
        userExample userExample = new userExample();
       com.my.ssm.bean.userExample.Criteria criteria = userExample.createCriteria();
       criteria.andNameEqualTo(Condition.getName());
       criteria.andUserpasswordEqualTo(Condition.getUserpassword());
        List<user> user = userMapper.selectByExample(userExample);
        if(user != null){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 添加角色关系表
     * @param map
     */
    public void insert_user_role(HashMap<String, Object> map) {
        userMapper.insert_user_role(map);
    }

    /**
     * 删除角色关系表
     * @param map
     */
    public void delete_user_role(HashMap<String, Object> map) {
        userMapper.delete_user_role(map);
    }

    /**
     * 查询角色对应的权限
     * @param id
     * @return
     */
    public List<Integer> getRoleidsByUserid(Integer id) {
       List<Integer> list = userMapper.getRoleidsByUserid(id);
       return list;
    }
}
