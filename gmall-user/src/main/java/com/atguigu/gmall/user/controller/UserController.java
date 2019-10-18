package com.atguigu.gmall.user.controller;

import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 会员Controller
 */
@Controller
@RequestMapping("/umsMember")
public class UserController {

    @Autowired
    private UmsMemberService umsMemberService;

    /**
     * 测试
     * @return
     */
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "hello world";
    }

    /**
     * 获取所有用户会员信息
     * @return
     */
    @RequestMapping("/getAllUmsMember")
    @ResponseBody
    public List<UmsMember> getAllUmsMember(){
        List<UmsMember> umsMemberList = umsMemberService.getAllUmsMember();
        return umsMemberList;
    }
}
