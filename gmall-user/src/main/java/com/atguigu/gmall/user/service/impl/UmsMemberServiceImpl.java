package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.mapper.UmsMemberMapper;
import com.atguigu.gmall.user.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 会员Service
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private UmsMemberMapper umsMemberMapper;

    /**
     * 获取所有会员信息
     * @return
     */
    @Override
    public List<UmsMember> getAllUmsMember() {
        List<UmsMember> umsMemberList = umsMemberMapper.selectAll();
        if (CollectionUtils.isEmpty(umsMemberList)){
            return null;
        }
        return umsMemberList;
    }
}
