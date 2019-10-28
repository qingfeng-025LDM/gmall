package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.api.model.PmsBaseAttrInfo;
import com.atguigu.gmall.api.model.PmsBaseAttrValue;
import com.atguigu.gmall.api.service.PmsBaseAttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class PmsBaseAttrController {

    @Reference
    private PmsBaseAttrService pmsBaseAttrService;

    /*****************************************************属性信息AttrInfo***********************************************/
    /**
     * 根据三级分类ID查询平台属性信息
     * @param catalog3Id
     * @return
     */
    @RequestMapping("/attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){
        List<PmsBaseAttrInfo> attrInfoList = pmsBaseAttrService.attrInfoList(catalog3Id);
        return attrInfoList;
    }

    /**
     * 保存属性信息和属性值
     * @param pmsBaseAttrInfo
     * @return
     */
    @RequestMapping("/saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
        pmsBaseAttrService.saveAttrInfo(pmsBaseAttrInfo);
        return "success";
    }

    /**
     * 根据属性信息ID删除属性信息
     * @param attrId：属性信息ID
     * @return
     */
    @RequestMapping("/delAttrInfoById")
    @ResponseBody
    public String delAttrInfoById(String attrId){
       return pmsBaseAttrService.delAttrInfoById(attrId);
    }


    /***************************************************属性值AttrValue****************************************************/

    /**
     * 根据属性信息ID获取属性值
     * @param attrId：属性ID
     * @return
     */
    @RequestMapping("/getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        return pmsBaseAttrService.getAttrValueList(attrId);
    }



}
