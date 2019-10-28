package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.api.model.PmsBaseAttrInfo;
import com.atguigu.gmall.api.model.PmsBaseAttrValue;
import com.atguigu.gmall.api.service.PmsBaseAttrService;
import com.atguigu.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.atguigu.gmall.manage.mapper.PmsBaseAttrValueMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

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
        if (CollectionUtils.isEmpty(attrInfoList)){
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
            //先删除原先的属性值，按照属性ID删除
            PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
            pmsBaseAttrValue.setAttrId(attrInfoId);
            pmsBaseAttrValueMapper.delete(pmsBaseAttrValue);

            //使用updateByExampleSelective修改属性信息
            Example example = new Example(PmsBaseAttrInfo.class);
            example.createCriteria().andEqualTo("id", attrInfoId);
            pmsBaseAttrInfoMapper.updateByExampleSelective(pmsBaseAttrInfo, example);
        }else {
            //插入属性信息，insert插入所有数据，insertSelective插入非空值
            pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);
        }
        //获取属性值list
        List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
        for (PmsBaseAttrValue attrValue:attrValueList) {    //循环插入属性值
            attrValue.setAttrId(attrInfoId);
            pmsBaseAttrValueMapper.insertSelective(attrValue);
        }
    }

    /**
     * 删除属性信息
     * @param attrId
     */
    @Override
    public String delAttrInfoById(String attrId) {
        if (StringUtils.isBlank(attrId)){
            return "参数不能为空";
        }
        pmsBaseAttrInfoMapper.deleteByPrimaryKey(attrId);
        return "保存成功";
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
        if (CollectionUtils.isEmpty(attrValueList)){
            return new ArrayList<PmsBaseAttrValue>();
        }
        return attrValueList;
    }
}
