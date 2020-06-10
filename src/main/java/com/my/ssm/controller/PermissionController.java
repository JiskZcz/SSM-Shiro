package com.my.ssm.controller;

import com.my.ssm.bean.Msg;
import com.my.ssm.bean.Permission;
import com.my.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/permission")
@Controller
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @RequestMapping("/add")
    public String add() {
        return "permission/add";
    }

    @RequestMapping("/index")
    public String index() {
        return "permission/index";
    }


    /**
     * 回显数据
     * @param roleid
     * @return
     */
    @ResponseBody
    @RequestMapping("/loadAssignData")
    public Object loadAssignData( Integer roleid ) {
        List<Permission> permissions = new ArrayList<Permission>();
        List<Permission> ps = permissionService.queryAll();

        // 获取当前角色已经分配的许可信息
        List<Integer> permissionids = permissionService.queryPermissionidsByRoleid(roleid);

        Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();
        for (Permission p : ps) {
            if ( permissionids.contains(p.getId()) ) {
                p.setChecked(true);
            } else {
                p.setChecked(false);
            }
            permissionMap.put(p.getId(), p);
        }
        for ( Permission p : ps ) {
            Permission child = p;
            if ( child.getPid() == 0 ) {
                permissions.add(p);
            } else {
                Permission parent = permissionMap.get(child.getPid());
                parent.getChildren().add(child);
            }
        }

        return permissions;
    }

    /**
     * zTree的数据结构，使用Map来进行根节点查询，缩短时间复杂度
     * @return 返回节点结构
     */
    @ResponseBody
    @RequestMapping("/loadData")
    public Object loadData(){
        List<Permission> permissions = new ArrayList<>();
        // 查询所有的许可数据
        List<Permission> ps = permissionService.queryAll();
        Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();
        for (Permission p : ps) {
            permissionMap.put(p.getId(), p);
        }
        for ( Permission p : ps ) {
            Permission child = p;
            if ( child.getPid() == 0 ) {
                permissions.add(p);
            } else {
                Permission parent = permissionMap.get(child.getPid());
                parent.getChildren().add(child);
            }
        }
        return permissions;
    }
}
