package com.my.ssm.service;

import com.my.ssm.bean.Permission;
import com.my.ssm.dao.permissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    permissionMapper permissionMapper;


    public List<Permission> queryAll() {
        List<Permission> list = permissionMapper.queryAll();
        return list;
    }

    
    public List<Integer> queryPermissionidsByRoleid(Integer roleid) {
        List<Integer> list = permissionMapper.queryPermissionidsByRoleid(roleid);
        return list;
    }

    /**
     * 根据userName 查找对应权限
     * @param userName
     * @return
     */
    public List<Permission> getPermissionsByUserName(String userName) {
        List<Permission> list = permissionMapper.getPermissionsByUserName(userName);
        return list;
    }
}
