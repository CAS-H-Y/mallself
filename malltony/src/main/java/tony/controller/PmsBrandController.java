package com.heyang.mall.tony.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.heyang.mall.tony.common.api.CommonResult;
import com.heyang.mall.tony.mbg.model.PmsBrand;
import com.heyang.mall.tony.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 86137 on 2019/5/12.
 */
@Api(tags = "PmsBrandController",description ="商品管理")
@RestController
@RequestMapping("/v1/brand")
public class PmsBrandController {

    @Autowired
    PmsBrandService pmsBrandService;

    @ApiOperation("添加品牌")
    @PostMapping("/create")
    public CommonResult create(@RequestBody PmsBrand pmsBrandDto){
   return new CommonResult().success(pmsBrandService.createBrand(pmsBrandDto));
    }
    @ApiOperation("更新商品")
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable("id")Long id,@RequestBody  PmsBrand pmsBrandDto){
        return new CommonResult().success(pmsBrandService.updateBrand(id,pmsBrandDto));
    }
    @ApiOperation("删除品牌")
    @GetMapping("/delete/{id}")
    public CommonResult delete(@PathVariable("id")Long id){
        return new CommonResult().success(pmsBrandService.deleteBrand(id));
    }
    @ApiOperation("品牌分页")
    @GetMapping("/list")
    public CommonResult list(@RequestParam("PageNo")Integer PageNum,
                             @RequestParam("PageNum")Integer PageSize){
        return new CommonResult().success(pmsBrandService.listBrand(PageNum,PageSize));
    }
    @ApiOperation("获取某一个品牌")
    @GetMapping("/{id}")
    public CommonResult list(@PathVariable("id")Long id){
        return new CommonResult().success();
    }

    @ApiOperation("获取所有品牌列表")
    @GetMapping("/listall")
    public CommonResult lisTAll(){
        return new CommonResult().success(pmsBrandService.listAllBrand());
    }
}
