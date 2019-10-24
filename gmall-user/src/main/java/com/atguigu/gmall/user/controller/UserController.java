package com.atguigu.gmall.user.controller;

import com.atguigu.gmall.api.model.UmsMember;
import com.atguigu.gmall.api.model.UmsMemberReceiveAddress;
import com.atguigu.gmall.api.service.UmsMemberReceiveAddressService;
import com.atguigu.gmall.api.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户会员Controller
 */
@Controller
@RequestMapping("/umsMember")
public class UserController {

    @Autowired
    private UmsMemberService umsMemberService;
    @Autowired
    private UmsMemberReceiveAddressService umsMemberReceiveAddressService;

    /*************************************************用户会员****************************************/
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

    /**
     * 根据ID获取用户会员详情
     * @param id
     * @return
     */
    @RequestMapping("/getUmsMemberDetail")
    @ResponseBody
    public UmsMember getUmsMemberDetail(String id){
        UmsMember umsMember = umsMemberService.getUmsMemberDetail(id);
        return umsMember;
    }

    /**
     * 添加会员
     * @param umsMember
     * @return
     */
    @RequestMapping("/addUmsMember")
    @ResponseBody
    public String addUmsMember(UmsMember umsMember){
        return umsMemberService.addUmsMember(umsMember);
    }

    /**
     * 根据主键ID删除用户会员
     * @param id
     * @return
     */
    @RequestMapping("/delUmsMemberById")
    @ResponseBody
    public String delUmsMemberById(String id){
        return umsMemberService.delUmsMemberById(id);
    }

    /**
     * 修改会员信息
     * @param umsMember
     * @return
     */
    @RequestMapping("/updateUmsMember")
    @ResponseBody
    public String updateUmsMember(UmsMember umsMember){
        return umsMemberService.updateUmsMember(umsMember);
    }

    /*****************************************用户会员地址*****************************************************/
    /**
     * 根据会员ID获取收货地址信息
     * @param memberId
     * @return
     */
    @RequestMapping("/getReceviceAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceviceAddressByMemberId(String memberId){
        List<UmsMemberReceiveAddress> umsMemberReceiveAddressList = umsMemberReceiveAddressService.getReceviceAddressByMemberId(memberId);
        return umsMemberReceiveAddressList;
    }

    /**
     * 根据主键ID获取会员收货地址信息
     * @param id
     * @return
     */
    @RequestMapping("/getReceviceAddressDetail")
    @ResponseBody
    public UmsMemberReceiveAddress getReceviceAddressDetail(String id){
        return umsMemberReceiveAddressService.getReceviceAddressDetail(id);
    }

    /**
     * 添加会员收货地址
     * @param receiveAddress
     * @return
     */
    @RequestMapping("/addReceviceAddress")
    @ResponseBody
    public String addReceviceAddress(UmsMemberReceiveAddress receiveAddress){
        return umsMemberReceiveAddressService.addReceiveAddress(receiveAddress);
    }

    /**
     * 根据主键ID删除会员收货地址
     * @param id
     * @return
     */
    @RequestMapping("/delReceviceAddressById")
    @ResponseBody
    public String delReceviceAddressById(String id){
        return umsMemberReceiveAddressService.delReceiveAddressById(id);
    }

    /**
     * 修改会员收货地址信息
     * @param receiveAddress
     * @return
     */
    @RequestMapping("/updateReceviceAddress")
    @ResponseBody
    public String updateReceviceAddress(UmsMemberReceiveAddress receiveAddress){
        return umsMemberReceiveAddressService.updateReceiveAddress(receiveAddress);
    }
}
