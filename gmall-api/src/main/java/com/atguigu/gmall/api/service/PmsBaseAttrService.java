package com.atguigu.gmall.api.service;

import com.atguigu.gmall.api.model.PmsBaseAttrInfo;
import com.atguigu.gmall.api.model.PmsBaseAttrValue;

import java.util.List;

public interface PmsBaseAttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    String delAttrInfoById(String attrId);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);
}
