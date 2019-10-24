package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.api.model.UmsMemberReceiveAddress;
import com.atguigu.gmall.api.service.UmsMemberReceiveAddressService;
import com.atguigu.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员收货地址Service
 */
@Service
public class UmsMemberReceiveAddressServiceImpl implements UmsMemberReceiveAddressService {

    @Autowired
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    /**
     * 根据会员ID获取收货地址
     * @param memberId：会员ID
     * @return
     */
    @Override
    public List<UmsMemberReceiveAddress> getReceviceAddressByMemberId(String memberId) {
        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddressList = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        return umsMemberReceiveAddressList;
    }

    @Override
    public UmsMemberReceiveAddress getReceviceAddressDetail(String id) {
        return umsMemberReceiveAddressMapper.selectByPrimaryKey(id);
    }

    @Override
    public String addReceiveAddress(UmsMemberReceiveAddress receiveAddress) {
        int addFlag = umsMemberReceiveAddressMapper.insert(receiveAddress);
        if (addFlag == 1){
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public String delReceiveAddressById(String id) {
        int delFlag = umsMemberReceiveAddressMapper.deleteByPrimaryKey(id);
        if (delFlag == 1){
            return "删除成功！";
        }
        return "删除失败！";
    }

    @Override
    public String updateReceiveAddress(UmsMemberReceiveAddress receiveAddress) {
        UmsMemberReceiveAddress tempReceiveAddress = umsMemberReceiveAddressMapper.selectByPrimaryKey(receiveAddress.getId());
        if (tempReceiveAddress == null){
            return "收货地址不存在";
        }
        int updateFlag = umsMemberReceiveAddressMapper.updateByPrimaryKey(receiveAddress);
        if (updateFlag == 1){
            return "修改成功";
        }
        return "修改失败";
    }
}
