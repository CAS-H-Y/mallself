package com.heyang.mall.tony.service.impl;

import com.github.pagehelper.PageHelper;
import com.heyang.mall.tony.mbg.mapper.PmsBrandMapper;
import com.heyang.mall.tony.mbg.model.PmsBrand;
import com.heyang.mall.tony.mbg.model.PmsBrandExample;
import com.heyang.mall.tony.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 86137 on 2019/5/12.
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired PmsBrandMapper pmsBrandMapper;
    public List<PmsBrand> listAllBrand() {

        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    public int createBrand(PmsBrand brand) {

        return pmsBrandMapper.insertSelective(brand);
    }

    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return pmsBrandMapper.updateByPrimaryKeySelective(brand);
    }

    public int deleteBrand(Long id) {
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    public PmsBrand getBrand(Long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }
}
