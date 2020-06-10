package com.my.ssm.service;

import com.my.ssm.bean.role;
import com.my.ssm.dao.roleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleService {
    @Autowired
    private roleMapper roleMapper;

    /**
     * 批量删除
     * @param ids
     */
    public void BatchDeleteRole(Integer[] ids){
        roleMapper.BatchDeleteRole(ids);
    }
    /**
     * 删除一个部门
     * @param id
     */
    public void DeleteRole(Integer id){
        roleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加一条数据
     * @param role
     */
    public void insertRole(role role){
        roleMapper.insert(role);
    }

    /**
     * 更新部门
     * @param role
     */
    public void updateRole(role role) {
        roleMapper.updateRole(role);
    }
    /**
     * 利用部门名称查找是否有相同数据
     * @param name
     * @return
     */
    public List<role> getByRoleName(String name) {
       List<role> roles = roleMapper.getByRoleName(name);
       return roles;
    }

    /**
     * 利用主键查找是否有相同数据
     * @param id
     * @return
     */
    public role selectByRole(Integer id) {
       role role = roleMapper.getByRoleId(id);
       return role;
    }
    /**
     * 模糊查询或全部数据的显示
     * @param queryText
     * @return
     */
    public List<role> getByLike(String queryText){
        List<role> list = roleMapper.selectByLike(queryText);
        return list;
    }

    /**
     * 给角色添加相关的权限
     * @param paramMap
     */
    public void insertRolePermission(Map<String, Object> paramMap) {
        roleMapper.deleteRolePermissions(paramMap);
        roleMapper.insertRolePermission(paramMap);
    }

    /**
     * 根据用户名查找对应角色
     * @param userName
     * @return
     */
    public List<role> getRolesByUserName(String userName) {
        List<role> list = roleMapper.getByUserName(userName);
        return list;
    }
}
