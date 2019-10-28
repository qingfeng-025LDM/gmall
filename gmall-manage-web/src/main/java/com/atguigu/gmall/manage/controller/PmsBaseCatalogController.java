package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.api.model.PmsBaseCatalog1;
import com.atguigu.gmall.api.model.PmsBaseCatalog2;
import com.atguigu.gmall.api.model.PmsBaseCatalog3;
import com.atguigu.gmall.api.service.PmsBaseCatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品分类Controller
 */
@Controller
@CrossOrigin
//@RequestMapping("/catalog")
public class PmsBaseCatalogController {

    @Reference
    private PmsBaseCatalogService  pmsBaseCatalogService;

    /**
     * 查询所有一级分类
     * @return
     */
    @RequestMapping("/getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(){
        List<PmsBaseCatalog1> catalog1List = pmsBaseCatalogService.getCatalog1();
        return catalog1List;
    }

    /**
     * 根据一级分类ID查询二级分类
     * @return
     */
    @RequestMapping("/getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id){
        List<PmsBaseCatalog2> catalog2List = pmsBaseCatalogService.getCatalog2(catalog1Id);
        return catalog2List;
    }

    /**
     * 根据二级分类ID查询三级分类
     * @return
     */
    @RequestMapping("/getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id){
        List<PmsBaseCatalog3> catalog3List = pmsBaseCatalogService.getCatalog3(catalog2Id);
        return catalog3List;
    }
}
