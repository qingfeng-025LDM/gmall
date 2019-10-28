package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.api.model.PmsBaseCatalog1;
import com.atguigu.gmall.api.model.PmsBaseCatalog2;
import com.atguigu.gmall.api.model.PmsBaseCatalog3;
import com.atguigu.gmall.api.service.PmsBaseCatalogService;
import com.atguigu.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import com.atguigu.gmall.manage.mapper.PmsBaseCatalog2Mapper;
import com.atguigu.gmall.manage.mapper.PmsBaseCatalog3Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PmsBaseCatalogServiceImpl implements PmsBaseCatalogService {

    @Autowired
    private PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;
    @Autowired
    private PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;
    @Autowired
    private PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    /**
     * 查询所有一级分类
     * @return
     */
    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        List<PmsBaseCatalog1> catalog1List = pmsBaseCatalog1Mapper.selectAll();
        if (StringUtils.isEmpty(catalog1List)){
            return new ArrayList<PmsBaseCatalog1>();
        }
        return catalog1List;
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        List<PmsBaseCatalog2> catalog2List = pmsBaseCatalog2Mapper.select(pmsBaseCatalog2);
        if (StringUtils.isEmpty(catalog2List)){
            return new ArrayList<PmsBaseCatalog2>();
        }
        return catalog2List;
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        List<PmsBaseCatalog3> catalog3List = pmsBaseCatalog3Mapper.select(pmsBaseCatalog3);
        if (StringUtils.isEmpty(catalog3List)){
            return new ArrayList<PmsBaseCatalog3>();
        }
        return catalog3List;
    }
}
