package com.my.ssm.dao;

import com.my.ssm.bean.Permission;
import com.my.ssm.bean.user;

import java.util.List;

public interface permissionMapper {

    //这是递归查找子节点，比较浪费资源
   //List<Permission> queryChildPermissions(Integer pid);

    //查询所有节点
    List<Permission> queryAll();

    Permission queryById(Integer id);

    //获取当前角色已经分配的许可信息
    List<Integer> queryPermissionidsByRoleid(Integer roleid);

    List<Permission> queryPermissionsByUser(user dbUser);

    //根据userName 查找对应权限
    List<Permission> getPermissionsByUserName(String userName);
}
