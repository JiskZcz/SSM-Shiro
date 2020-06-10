package com.my.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.ssm.bean.Msg;
import com.my.ssm.bean.role;
import com.my.ssm.bean.user;
import com.my.ssm.service.RoleService;
import com.my.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/index")
    public String index(){
        return "user/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "user/add";
    }

    /**
     * @param ids 批量删除的id
     * @return JSON数据
     */
    @ResponseBody
    @RequestMapping(value = "/deletes",method = RequestMethod.DELETE)
    public Msg DeleteUsers(@RequestParam("userid") Integer[] ids){
        userService.BatchDeleteUser(ids);
        return Msg.success();
    }

    /**
     * 单个删除按钮 这里忘写了 @ResponseBody 注解，前端报404，后台却删除了数据，踩了一个坑。
     * @param id 删除用户的主键
     * @return JSON数据
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public Msg DeleteUser(@PathVariable("id") Integer id){
        try{
            userService.DeleteUser(id);
            return Msg.success();
        }catch (Exception ex){
            return Msg.fail();
        }
    }

    /**
     * 查询当前点击的按钮id的对应权限，再回显到页面上
     * @param id 当前点击按钮的id值
     * @param model 页面显示数据
     * @return 返回页面
     */
    @RequestMapping("/assign")
    public String assign(Integer id, Model model){
        user user = userService.getUser(id);
        //不传查询条件就会查找所有数据
        List<role> roles = roleService.getByLike(null);
        //未分配
        ArrayList<role> unassignRoles = new ArrayList<>();
        //已分配
        ArrayList<role> assignRoles = new ArrayList<>();
        //关系表数据
        List<Integer> roleids = userService.getRoleidsByUserid(id);
        for (role role : roles) {
            if(roleids.contains(role.getId())){
                assignRoles.add(role);
            }else{
                unassignRoles.add(role);
            }
        }
        model.addAttribute("unassignRoles",unassignRoles);
        model.addAttribute("assignRoles",assignRoles);
        model.addAttribute("userid",user.getId());
        return "user/assign";
    }

    /**
     * 添加角色关系表
     * @param id userid
     * @param ids roleid
     * @return
     */
    @ResponseBody
    @RequestMapping("/doAssign")
    public Msg doAssign(@RequestParam("userid") Integer id,@RequestParam("unassignroleids") Integer[] ids){
        HashMap<String, Object> map = new HashMap<>();
        map.put("userid",id);
        map.put("roleids",ids);
        try{
            userService.insert_user_role(map);
            return Msg.success();
        }catch (Exception ex){
            return Msg.fail();
        }
    }
    /**
     * 删除角色关系表
     * @param id userid
     * @param ids roleid
     * @return
     */
    @ResponseBody
    @RequestMapping("/dounAssign")
    public Msg dounAssign(@RequestParam("userid") Integer id,@RequestParam("assignroleids") Integer[] ids){
        HashMap<String, Object> map = new HashMap<>();
        map.put("userid",id);
        map.put("roleids",ids);
        try {
            userService.delete_user_role(map);
            return Msg.success();
        }catch (Exception ex){
            return Msg.fail();
        }

    }
    /**
     * 点击更新按钮 查出当前用户数据，回显数据
     * @param id 主键
     * @param mdoel 传回数据
     * @return 去到更新页面
     */
    @RequestMapping("/edit")
    public String edit(Integer id, Model mdoel){
        user user = userService.getUser(id);
        mdoel.addAttribute("user",user);
        return "user/edit";
    }

    /**
     * 更新用户的操作
     * @param user 序列化数据
     * @param result JSR303数据校验
     * @return 返回处理是否成功和错误信息
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Msg updateUser(@Valid user user, BindingResult result){
        List<user> users = userService.getUsers(user.getName());
        if (users.size()==1){
            if(users.get(0).getId()==user.getId()) {
                if(result.hasErrors()) {
                    Map<String,Object> map = new HashMap<String, Object>();
                    //校验失败，返回失败 页面显示信息
                    List<FieldError> errors = result.getFieldErrors();
                    for (FieldError fieldError : errors) {
                        System.out.println("错误的字段名："+fieldError.getField());
                        map.put(fieldError.getField(), fieldError.getDefaultMessage());
                    }
                    return Msg.fail().add("errorMsg", map);
                }else{
                    userService.updateUser(user);
                    return Msg.success();
                }
            }else{
                return Msg.fail().add("nameisnotunique","notunique");
            }
        }else{
            if(result.hasErrors()) {
                Map<String,Object> map = new HashMap<String, Object>();
                //校验失败，返回失败 页面显示信息
                List<FieldError> errors = result.getFieldErrors();
                for (FieldError fieldError : errors) {
                    System.out.println("错误的字段名："+fieldError.getField());
                    map.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
                return Msg.fail().add("errorMsg", map);
            }else{
                userService.updateUser(user);
                return Msg.success();
            }
        }
    }

    /**
     * 添加用户，可以考虑拿来写注册用
     * @param user 页面序列化过来的数据
     * @param result JSR303数据校验
     * @return 返回JSON数据
     */
    @ResponseBody
    @RequestMapping("/insert")
    public Msg AddUser(@Valid user user, BindingResult result){
        List<user> byLike = userService.getUsers(user.getName());
        if(byLike.size()==0){
            if(result.hasErrors()) {
                Map<String,Object> map = new HashMap<String, Object>();
                //校验失败，返回失败 页面显示信息
                List<FieldError> errors = result.getFieldErrors();
                for (FieldError fieldError : errors) {
                    map.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
                return Msg.fail().add("errorFields", map);
            }
            else {
                userService.addUser(user);
                return Msg.success();
            }
        }else{
            return Msg.fail().add("usernameisnotunique","uniquename");
        }
    }
    /**
     * 分页查询
     * @param pn 页数
     * @param queryText 是否有查询条件，只能查询用户名，后期考虑是否加上邮箱
     * @return 返回JSON数据
     */
    @RequestMapping("/pageQuery")
    @ResponseBody
    public Msg pageQuery(@RequestParam(value = "pn", defaultValue = "1",required = false) Integer pn,
                         @RequestParam(value ="queryText",required = false) String queryText){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 7);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<user> users = userService.getByLike(queryText);
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(users, 6);
        return Msg.success().add("pageInfo",page);
    }

}
