package com.atguigu.gmall.api.service;

import com.atguigu.gmall.api.model.UmsMember;

import java.util.List;

public interface UmsMemberService {
    //获取会员信息
    List<UmsMember> getAllUmsMember();

    //获取会员详情
    UmsMember getUmsMemberDetail(String id);

    //添加会员
    String addUmsMember(UmsMember umsMember);

    //根据主键ID删除会员
    String delUmsMemberById(String id);

    //修改会员信息
    String updateUmsMember(UmsMember umsMember);
}
