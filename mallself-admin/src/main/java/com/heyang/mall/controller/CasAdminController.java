package com.heyang.mall.controller;

import com.heyang.mall.bo.CasUserDetails;
import com.heyang.mall.dto.CasUser;
import com.heyang.mall.dto.CommonResult;
import com.heyang.mall.dto.UmsAdminLoginParam;
import com.heyang.mall.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * creat on 2019/4/9
 * <p>
 * #author : CAS_hy
 **/
@RestController
@RequestMapping("/admin")
public class CasAdminController {
    @Value("${jwt.tokenHead}")
    private String tokenHead;

     @Autowired
    UserService userService;
    @ApiOperation(value = "登录以后返回结果")
    @PostMapping("/login")
    public Object login(@RequestBody UmsAdminLoginParam umsAdminLoginParam ){
        String token= userService.login(umsAdminLoginParam.getUsername(),umsAdminLoginParam.getPassword());
        if(token==null){
            return new CommonResult().validateFailed("用户名密码错误");
        }
        Map<String,String> tokenmap=new HashMap<String,String>();
        tokenmap.put("token",token);
        tokenmap.put("tokenHead",tokenHead);
        return new CommonResult().success(tokenmap);
    }
    @ApiOperation(value = "登录以后返回结果")
    @PostMapping("/logout")
    public Object logout(){
        return new CommonResult().success(null);
    }

    @ApiOperation(value = "测试是否拦截")
    @GetMapping("/test")
    public Object test(){
        return new CommonResult().success("为拦截");
    }

    @ApiOperation(value="获取当前人员的信息")
    @GetMapping("/info")
    public Object getInfo(Principal principal){
        String username=principal.getName();
        CasUser casUser =userService.getUserByUsername(username);
         Map<String,Object> map=new HashMap<String,Object>();
         map.put("username",casUser.getUsername());
         map.put("roles",new String[]{"test"});
         map.put("icon",casUser.getId());
        return new CommonResult().success(map);
    }
}
