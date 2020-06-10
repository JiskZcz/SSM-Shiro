package com.my.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.ssm.bean.Msg;
import com.my.ssm.bean.role;
import com.my.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/index")
    public String index(){
        return "role/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "role/add";
    }

    @RequestMapping("/assign")
    public String assign(){
        return "role/assign";
    }

    /**
     * 添加角色权限
     * @param roleid
     * @param permissionids
     * @return
     */
    @ResponseBody
    @RequestMapping("/doAssign")
    public Msg doAssign( Integer roleid, Integer[] permissionids ) {

        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("roleid", roleid);
            paramMap.put("permissionids", permissionids);
            roleService.insertRolePermission(paramMap);
            return Msg.success();
        } catch ( Exception e ) {
            e.printStackTrace();
            return Msg.fail();
        }
    }

    /**
     * 先查找数据然后跳转页面
     * @param id 主键
     * @param model 回显数据
     * @return
     */
    @RequestMapping("/edit")
    public String edit(@RequestParam("id") Integer id,Model model){
        role role = roleService.selectByRole(id);
        model.addAttribute("role",role);
        return "role/edit";
    }

    /**
     * 更新部门
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public Msg updateRole(role role){
        List<role> roles = roleService.getByRoleName(role.getName());
        if(roles.size()==1){
            if(roles.get(0).getId()==role.getId()){
                roleService.updateRole(role);
                return Msg.success();
            }else{
                return Msg.fail().add("errorMsg","fail");
            }
        }else{
            roleService.updateRole(role);
            return Msg.success();
        }
    }


    /**
     * @param ids 批量删除的id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deletes",method = RequestMethod.DELETE)
    public Msg BatchDeleteRole(@RequestParam("roleid") Integer[] ids){
        roleService.BatchDeleteRole(ids);
        return Msg.success();
    }

    /**
     * 单个删除按钮 这里忘写了 @ResponseBody 注解，前端报404，后台却删除了数据，踩了一个坑。
     * @param id 删除用户的主键
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public Msg DeleteRole(@PathVariable("id") Integer id){
        try{
            roleService.DeleteRole(id);
            return Msg.success();
        }catch (Exception ex){
            return Msg.fail();
        }
    }

    /**
     * 用部门名先查找是否存在相同部门，如果存在提示，反之保存
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public Msg insertRole(role role){
        List<role> roles = roleService.getByRoleName(role.getName());
        if(roles.size()==1){
            return Msg.fail();
        }else{
            roleService.insertRole(role);
            return Msg.success();
        }
    }


    /**
     * 分页查询
     * @param pn 页数
     * @param queryText 是否查询
     * @return
     */
    @RequestMapping("/pageQuery")
    @ResponseBody
    public Msg pageQuery(@RequestParam(value = "pn", defaultValue = "1",required = false) Integer pn,
                         @RequestParam(value ="queryText",required = false) String queryText){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 10);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<role> roles = roleService.getByLike(queryText);
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(roles, 6);
        return Msg.success().add("pageInfo",page);
    }
}
