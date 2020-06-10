package com.my.ssm.Shiro;

import com.my.ssm.bean.Permission;
import com.my.ssm.bean.role;
import com.my.ssm.bean.user;
import com.my.ssm.service.PermissionService;
import com.my.ssm.service.RoleService;
import com.my.ssm.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Set<String> roles=new HashSet<String>();
        List<role> rolesByUserName = roleService.getRolesByUserName(userName);
        for(role role:rolesByUserName) {
            roles.add(role.getENname());
        }
        List<Permission> permissionsByUserName = permissionService.getPermissionsByUserName(userName);
        for(Permission permission:permissionsByUserName) {
            info.addStringPermission(permission.getENname());
        }
        info.setRoles(roles);
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String)token.getPrincipal();
        user user = userService.selectByUserName(userName);
        if (user != null) {
            AuthenticationInfo info = new SimpleAuthenticationInfo(user.getName(), user.getUserpassword(), getName());
            return info;
        }else{
            return null;
        }
    }
}
