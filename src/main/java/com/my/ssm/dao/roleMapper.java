package com.my.ssm.dao;

import com.my.ssm.bean.role;
import com.my.ssm.bean.roleExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface roleMapper {
    long countByExample(roleExample example);

    int deleteByExample(roleExample example);

    int insert(role record);

    int insertSelective(role record);

    List<role> selectByExample(roleExample example);

    //删除一个职位
    void deleteByPrimaryKey(Integer id);

    //批量删除
    void BatchDeleteRole(Integer[] ids);

    //全部查询或模糊查询
    List<role> selectByLike(String queryText);

    //用部门名查找是否有相同的部门，顺带用Shiro查找
    List<role> getByRoleName(String name);

    //用主键查找是否有相同的部门
    role getByRoleId(Integer id);

    //更新
    void updateRole(role role);

    //添加角色权限前先删除当前角色的权限
    void deleteRolePermissions(Map<String, Object> paramMap);

    //给角色添加相关权限
    void insertRolePermission(Map<String, Object> paramMap);

    //用户名查找对应职位
    List<role> getByUserName(String userName);

    int updateByExampleSelective(@Param("record") role record, @Param("example") roleExample example);

    int updateByExample(@Param("record") role record, @Param("example") roleExample example);

}