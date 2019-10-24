package com.atguigu.gmall.api.service;

import com.atguigu.gmall.api.model.UmsMemberReceiveAddress;

import java.util.List;

public interface UmsMemberReceiveAddressService {
    //根据会员ID获取会员收货地址
    List<UmsMemberReceiveAddress> getReceviceAddressByMemberId(String memberId);

    //根据主键ID获取会员收货地址信息
    UmsMemberReceiveAddress getReceviceAddressDetail(String id);

    String addReceiveAddress(UmsMemberReceiveAddress receiveAddress);

    String delReceiveAddressById(String id);

    String updateReceiveAddress(UmsMemberReceiveAddress receiveAddress);
}
