package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.api.model.UmsMember;
import com.atguigu.gmall.api.service.UmsMemberService;
import com.atguigu.gmall.user.mapper.UmsMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
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
            return new ArrayList<UmsMember>();
        }
        return umsMemberList;
    }

    /**
     * 根据主键id获取用户会员详情
     * @param id
     * @return
     */
    @Override
    public UmsMember getUmsMemberDetail(String id) {
        UmsMember umsMember = umsMemberMapper.selectByPrimaryKey(id);
        if (umsMember == null){
            return new UmsMember();
        }
        return umsMember;
    }

    @Override
    public String addUmsMember(UmsMember umsMember) {
        umsMember.setCreateTime(new Date());
        int addFlag = umsMemberMapper.insert(umsMember);
        String returnMsg = "";
        if (addFlag == 1){
            returnMsg =  "添加成功";
        }else {
            returnMsg = "添加失败";
        }
        return returnMsg;
    }

    @Override
    public String delUmsMemberById(String id) {
        int delFlag = umsMemberMapper.deleteByPrimaryKey(id);
        if (delFlag == 1){
            return "删除成功！";
        }
        return "删除失败！";
    }

    @Override
    public String updateUmsMember(UmsMember umsMember) {
        int updateFlag = umsMemberMapper.updateByPrimaryKey(umsMember);
        if (updateFlag == 1){
            return "修改成功";
        }
        return "修改失败";
    }


}
