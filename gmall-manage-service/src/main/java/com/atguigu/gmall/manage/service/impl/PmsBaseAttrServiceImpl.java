package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.api.model.PmsBaseAttrInfo;
import com.atguigu.gmall.api.model.PmsBaseAttrValue;
import com.atguigu.gmall.api.service.PmsBaseAttrService;
import com.atguigu.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.atguigu.gmall.manage.mapper.PmsBaseAttrValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PmsBaseAttrServiceImpl implements PmsBaseAttrService {

    @Autowired
    private PmsBaseAttrInfoMapper  pmsBaseAttrInfoMapper;
    @Autowired
    private PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    /**
     * 根据三级分类ID查询平台属性信息
     * @param catalog3Id
     * @return
     */
    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> attrInfoList = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
        if (StringUtils.isEmpty(attrInfoList)){
            return new ArrayList<PmsBaseAttrInfo>();
        }
        return attrInfoList;
    }

    /**
     * 保存属性信息和属性值
     * @param pmsBaseAttrInfo
     */
    @Override
    public void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        String attrInfoId = pmsBaseAttrInfo.getId();    //获取属性信息ID
        if (!StringUtils.isEmpty(attrInfoId)){
            //先删除原先的属性值
            PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
            pmsBaseAttrValue.setAttrId(attrInfoId);
            List<PmsBaseAttrValue> tempAttrValueList = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
            for (PmsBaseAttrValue tempAttrValue:tempAttrValueList) {
                pmsBaseAttrValueMapper.deleteByPrimaryKey(tempAttrValue.getId());
            }
            pmsBaseAttrInfoMapper.updateByPrimaryKey(pmsBaseAttrInfo);
        }else {
            //插入属性信息
            pmsBaseAttrInfoMapper.insert(pmsBaseAttrInfo);
        }
        //获取属性值list
        List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
        for (PmsBaseAttrValue attrValue:attrValueList) {    //循环插入属性值
            attrValue.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.insert(attrValue);
        }
    }

    /**
     * 删除属性信息
     * @param attrId
     */
    @Override
    public void delAttrInfoById(String attrId) {
        pmsBaseAttrInfoMapper.deleteByPrimaryKey(attrId);
    }

    /**
     * 根据属性信息ID获取属性值
     * @param attrId
     * @return
     */
    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        List<PmsBaseAttrValue> attrValueList = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
        if (StringUtils.isEmpty(attrValueList)){
            return new ArrayList<PmsBaseAttrValue>();
        }
        return attrValueList;
    }
}
