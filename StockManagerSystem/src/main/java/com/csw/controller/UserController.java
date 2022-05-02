package com.csw.controller;

import com.csw.common.vo.Result;
import com.csw.common.vo.RoleQuery;
import com.csw.entity.Role;
import com.csw.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    RoleMapper roleMapper;

    @RequestMapping("")
    public String toUser(){
        return "sys/user";
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public Result<Object> getUser(RoleQuery param){
        List<Role> lists=roleMapper.getRolesByParam(param);
        Long counts =roleMapper.getCounts();
        return Result.success(lists,counts);
    }

    @RequestMapping("/changeEnabled")
    @ResponseBody
    public Result<Object> changeEnabled(RoleQuery param){
        roleMapper.changeEnabled(param);
        return Result.success();
    }

    @RequestMapping("/changeAuth/{username}/{authorities}")
    public String changeAuth(@PathVariable("username")String username, @PathVariable("authorities")String authorities, Model model){
        model.addAttribute("username", username);
        model.addAttribute("authorities", authorities);

        return "sys/changeAuthUI";
    }

    @RequestMapping("/changeAuthDo")
    @ResponseBody
    public Result<Object> changeAuthDo(String username, String authorities){
        roleMapper.changeAuth(username, authorities);
        return Result.success();
    }

    @RequestMapping("/deleteUserByUserName/{username}")
    @ResponseBody
    public Result<Object> deleteUserByUserName(@PathVariable("username") String username){
        roleMapper.deleteRoleByUserName(username);
        return Result.success();
    }

    @RequestMapping("addUserUI")
    public String toAddUserUI(){
        return "sys/addUserUI";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Result<Object> addUser(Role role){
        roleMapper.addRole(role);
        return Result.success();
    }
}
